package org.tyslan.butler.telegram.impl;

import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.rest.client.impl.DefaultMethodExecutor;
import org.tyslan.butler.telegram.api.TelegramResponse;
import org.tyslan.butler.telegram.api.TelegramRestMethod;
import org.tyslan.butler.telegram.api.exceptions.TelegramCallException;

public class MethodExecutor {
  private DefaultMethodExecutor executor;

  public MethodExecutor(String botToken) {
    String endpointUrl = Constants.END_POINT_URL_FORMAT.replace(Constants.TOKEN_FORMAT, botToken);
    executor = new DefaultMethodExecutor(endpointUrl);
  }

  public <T> T execute(TelegramRestMethod<TelegramResponse<T>> method)
      throws RestCallException, TelegramCallException {
    TelegramResponse<T> apiResponse = executor.execute(method);
    if (apiResponse.isResponseStatus()) {
      return apiResponse.getResponse();
    }
    throw new TelegramCallException(apiResponse.getErrorCode(), apiResponse.getDescription());
  }
}
