package org.tyslan.butler.telegram.meta.receiver;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.telegram.meta.Constants;
import org.tyslan.butler.telegram.meta.api.bot.UpdateSupplier;
import org.tyslan.butler.telegram.meta.exceptions.TelegramCallException;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;
import org.tyslan.butler.telegram.meta.methods.GetUpdates;
import org.tyslan.butler.telegram.meta.types.Update;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


public class LongPollingUpdateSupplier implements UpdateSupplier {
  private static final Logger logger = LoggerFactory.getLogger(LongPollingUpdateSupplier.class);
  private static final Type LIST_TYPE = new TypeToken<List<Update>>() {}.getType();

  private String endpointUrl;
  private CloseableHttpClient httpclient;
  private ResponseHandler<String> responseHandler;
  private Gson gson;

  public LongPollingUpdateSupplier(String botToken) {
    httpclient = HttpClients.createDefault();
    responseHandler = new BasicResponseHandler();
    gson = new Gson();
    endpointUrl = Constants.END_POINT_URL_FORMAT.replace(Constants.TOKEN_FORMAT, botToken);
  }

  @Override
  public List<Update> getUpdates() throws TelegramException {
    return getUpdates(0);
  }

  @Override
  public List<Update> getUpdates(long offset) throws TelegramException {
    GetUpdates request = new GetUpdates();
    request.setOffset(offset);
    request.setLimit(Constants.GETUPDATES_LIMIT);
    request.setTimeout(Constants.GETUPDATES_TIMEOUT);
    try {
      return executePost(request);
    } catch (URISyntaxException | IOException e) {
      logger.error(e.getMessage(), e);
      throw new TelegramException(e.getMessage());
    }
  }

  private List<Update> executePost(GetUpdates method)
      throws URISyntaxException, TelegramCallException, IOException {
    /* Make url */
    URI uri = new URIBuilder().setScheme("https").setHost(endpointUrl).setPath(method.getMethod())
        .build();
    return postJson(uri, method);
  }

  private List<Update> postJson(URI uri, GetUpdates method)
      throws IOException, TelegramCallException {
    /* Prepare POST */
    HttpPost httppost = new HttpPost(uri);
    httppost.addHeader("charset", StandardCharsets.UTF_8.name());
    httppost.setEntity(new StringEntity(method.toJson(), ContentType.APPLICATION_JSON));
    logger.trace("Calling: {}", httppost.getURI());
    CloseableHttpResponse response = httpclient.execute(httppost);
    String telegramResponse = responseHandler.handleResponse(response);
    logger.trace(telegramResponse);
    JsonObject jsonObject = JsonParser.parseString(telegramResponse).getAsJsonObject();
    boolean isOk = jsonObject.getAsJsonPrimitive(Constants.RESPONSE_FIELD_OK).getAsBoolean();
    if (!isOk) {
      throwTelegramCallException(jsonObject);
    }
    // If response timed out. Telegram answers OK with empty array as result.
    JsonArray result = jsonObject.getAsJsonArray(Constants.RESPONSE_FIELD_RESULT);
    return gson.fromJson(result, LIST_TYPE);
  }

  private void throwTelegramCallException(JsonObject jsonObject) throws TelegramCallException {
    String description = jsonObject.getAsJsonPrimitive("description").getAsString();
    int errorCode = jsonObject.getAsJsonPrimitive("error_code").getAsInt();
    throw new TelegramCallException(errorCode, description);
  }
}
