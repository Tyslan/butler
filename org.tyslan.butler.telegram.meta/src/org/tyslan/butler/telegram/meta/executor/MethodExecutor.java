package org.tyslan.butler.telegram.meta.executor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map.Entry;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.tyslan.butler.telegram.meta.Constants;
import org.tyslan.butler.telegram.meta.api.bot.ApiCaller;
import org.tyslan.butler.telegram.meta.api.methods.BotGetMethod;
import org.tyslan.butler.telegram.meta.api.methods.BotMethod;
import org.tyslan.butler.telegram.meta.api.methods.BotPostMethod;
import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.exceptions.TelegramCallException;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MethodExecutor implements ApiCaller {
  private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MethodExecutor.class);

  private final String endpointUrl;
  private CloseableHttpClient httpclient;
  private ResponseHandler<String> responseHandler;

  public MethodExecutor(String botToken) {
    httpclient = HttpClients.createDefault();
    responseHandler = new BasicResponseHandler();
    endpointUrl = Constants.END_POINT_URL_FORMAT.replace(Constants.TOKEN_FORMAT, botToken);
  }

  @Override
  public <T extends ApiObject, M extends BotMethod<T>> T sendMethod(M method)
      throws TelegramException {
    try {
      String jsonResponse = sendMethodRequest(method);
      return method.fromJson(jsonResponse);
    } catch (IOException | URISyntaxException e) {
      logger.error("", e);
      throw new TelegramException("Unable to execute " + method.getMethod() + " method");
    }
  }

  @SuppressWarnings("unchecked")
  private <T extends ApiObject, M extends BotMethod<T>> String sendMethodRequest(M method)
      throws TelegramException, URISyntaxException, IOException {
    method.validate();
    switch (method.getType()) {
      case GET:
        return executeGet((BotGetMethod<ApiObject>) method);
      case POST:
        return executePost((BotPostMethod<ApiObject>) method);
      default:
        throw new TelegramException("Unknown type: " + method.getType());
    }
  }

  private String executeGet(BotGetMethod<ApiObject> method)
      throws URISyntaxException, IOException, TelegramCallException {
    /* Make url */
    URIBuilder builder =
        new URIBuilder().setScheme("https").setHost(endpointUrl).setPath(method.getMethod());
    for (Entry<String, String> entry : method.getParameters().entrySet()) {
      builder.setParameter(entry.getKey(), entry.getValue());
    }
    URI uri = builder.build();

    String response = getJson(uri);
    logger.trace(response);
    return response;
  }

  private String getJson(URI uri) throws IOException, TelegramCallException {
    /* Prepare GET */
    HttpGet httpget = new HttpGet(uri);
    httpget.addHeader("Content-Type", "application/json");
    logger.trace("Calling: {}", httpget.getURI());

    /* Get response */
    CloseableHttpResponse response = httpclient.execute(httpget);
    String telegramResponse = responseHandler.handleResponse(response);
    JsonObject jsonObject = JsonParser.parseString(telegramResponse).getAsJsonObject();
    boolean isOk = jsonObject.getAsJsonPrimitive(Constants.RESPONSE_FIELD_OK).getAsBoolean();
    if (!isOk) {
      throwTelegramCallException(jsonObject);
    }
    JsonObject result = jsonObject.getAsJsonObject(Constants.RESPONSE_FIELD_RESULT);
    return result.toString();
  }

  private void throwTelegramCallException(JsonObject jsonObject) throws TelegramCallException {
    String description = jsonObject.getAsJsonPrimitive("description").getAsString();
    int errorCode = jsonObject.getAsJsonPrimitive("error_code").getAsInt();
    throw new TelegramCallException(errorCode, description);
  }

  private String executePost(BotPostMethod<ApiObject> method)
      throws URISyntaxException, TelegramCallException, IOException {
    /* Make url */
    URI uri = new URIBuilder().setScheme("https").setHost(endpointUrl).setPath(method.getMethod())
        .build();
    String response = postJson(uri, method);
    logger.trace(response);
    return response;
  }

  private String postJson(URI uri, BotPostMethod<ApiObject> method)
      throws IOException, TelegramCallException {
    /* Prepare POST */
    HttpPost httppost = new HttpPost(uri);
    httppost.addHeader("charset", StandardCharsets.UTF_8.name());
    httppost.setEntity(new StringEntity(method.toJson(), ContentType.APPLICATION_JSON));
    logger.trace("Calling: {}", httppost.getURI());
    CloseableHttpResponse response = httpclient.execute(httppost);
    String telegramResponse = responseHandler.handleResponse(response);
    JsonObject jsonObject = JsonParser.parseString(telegramResponse).getAsJsonObject();
    boolean isOk = jsonObject.getAsJsonPrimitive(Constants.RESPONSE_FIELD_OK).getAsBoolean();
    if (!isOk) {
      throwTelegramCallException(jsonObject);
    }
    JsonObject result = jsonObject.getAsJsonObject(Constants.RESPONSE_FIELD_RESULT);
    return result.toString();
  }

}
