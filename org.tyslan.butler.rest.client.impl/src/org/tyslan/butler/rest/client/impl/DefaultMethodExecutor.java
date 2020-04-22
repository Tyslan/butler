package org.tyslan.butler.rest.client.impl;

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
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.JsonParseException;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.rest.client.api.method.RestGetMethod;
import org.tyslan.butler.rest.client.api.method.RestMethod;
import org.tyslan.butler.rest.client.api.method.RestMethodExecutor;
import org.tyslan.butler.rest.client.api.method.RestPostMethod;
import org.tyslan.butler.rest.client.api.object.RestObject;

public class DefaultMethodExecutor implements RestMethodExecutor {
  private static final Logger logger = LoggerFactory.getLogger(DefaultMethodExecutor.class);

  private final String endpointUrl;
  private final CloseableHttpClient httpclient;
  private final ResponseHandler<String> responseHandler;

  public DefaultMethodExecutor(String endpointUrl) {
    this.endpointUrl = endpointUrl;
    this.httpclient = HttpClients.createDefault();
    this.responseHandler = new BasicResponseHandler();
  }

  @Override
  public <T extends RestObject, M extends RestMethod<T>> T execute(M method)
      throws RestCallException {
    if (method == null) {
      throw new RestCallException("Parameter method can not be null");
    }
    return sendMethod(method);
  }

  @Override
  public <T extends RestObject, M extends RestMethod<T>> String call(M method)
      throws RestCallException {
    if (method == null) {
      throw new RestCallException("Parameter method can not be null");
    }
    try {
      return sendMethodRequest(method);
    } catch (IOException | URISyntaxException e) {
      logger.error(e.getMessage(), e);
      throw new RestCallException("Unable to execute " + method.getMethod() + " method");
    }
  }

  private <T extends RestObject, M extends RestMethod<T>> T sendMethod(M method)
      throws RestCallException {
    try {
      String jsonResponse = sendMethodRequest(method);
      return method.fromJson(jsonResponse);
    } catch (IOException | URISyntaxException | JsonParseException e) {
      logger.error(e.getMessage(), e);
      throw new RestCallException("Unable to execute " + method.getMethod() + " method");
    }
  }

  @SuppressWarnings("unchecked")
  private <T extends RestObject, M extends RestMethod<T>> String sendMethodRequest(M method)
      throws RestCallException, URISyntaxException, IOException {
    method.validate();
    switch (method.getType()) {
      case GET:
        return executeGet((RestGetMethod<RestObject>) method);
      case POST:
        return executePost((RestPostMethod<RestObject>) method);
      default:
        throw new RestCallException("Unknown type: " + method.getType());
    }
  }

  private String executeGet(RestGetMethod<RestObject> method)
      throws IOException, URISyntaxException {
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

  private String getJson(URI uri) throws IOException {
    /* Prepare GET */
    HttpGet httpget = new HttpGet(uri);
    httpget.addHeader("Content-Type", "application/json");
    logger.trace("Calling: {}", httpget.getURI());

    /* Get response */
    CloseableHttpResponse response = httpclient.execute(httpget);
    return responseHandler.handleResponse(response);
  }

  private String executePost(RestPostMethod<RestObject> method)
      throws URISyntaxException, IOException {
    /* Make url */
    URI uri = new URIBuilder().setScheme("https").setHost(endpointUrl).setPath(method.getMethod())
        .build();
    String response = postJson(uri, method);
    logger.trace(response);
    return response;
  }

  private String postJson(URI uri, RestPostMethod<RestObject> method) throws IOException {
    /* Prepare POST */
    HttpPost httppost = new HttpPost(uri);
    httppost.addHeader("charset", StandardCharsets.UTF_8.name());
    httppost.setEntity(new StringEntity(method.parametersAsJson(), ContentType.APPLICATION_JSON));
    logger.trace("Calling: {}", httppost.getURI());
    CloseableHttpResponse response = httpclient.execute(httppost);
    return responseHandler.handleResponse(response);
  }
}
