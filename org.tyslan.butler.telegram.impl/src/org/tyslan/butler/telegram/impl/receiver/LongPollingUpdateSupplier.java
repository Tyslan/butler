package org.tyslan.butler.telegram.impl.receiver;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.rest.client.api.method.RestMethodExecutor;
import org.tyslan.butler.rest.client.impl.DefaultMethodExecutor;
import org.tyslan.butler.telegram.api.TelegramResponse;
import org.tyslan.butler.telegram.api.exceptions.TelegramException;
import org.tyslan.butler.telegram.impl.Constants;
import org.tyslan.butler.telegram.impl.abs.UpdateSupplier;
import org.tyslan.butler.telegram.meta.methods.GetUpdates;
import org.tyslan.butler.telegram.meta.types.Update;


public class LongPollingUpdateSupplier implements UpdateSupplier {
  private static final Logger logger = LoggerFactory.getLogger(LongPollingUpdateSupplier.class);

  private String endpointUrl;
  private RestMethodExecutor executor;

  public LongPollingUpdateSupplier(String botToken) {
    endpointUrl = Constants.END_POINT_URL_FORMAT.replace(Constants.TOKEN_FORMAT, botToken);
    executor = new DefaultMethodExecutor(endpointUrl);

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
      TelegramResponse<List<Update>> apiResponse = executor.execute(request);
      return apiResponse.getResponse();
    } catch (RestCallException e) {
      logger.error(e.getMessage(), e);
      throw new TelegramException(e.getMessage());
    }
  }
}
