package org.tyslan.butler.telegram.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.telegram.api.TelegramResponse;
import org.tyslan.butler.telegram.api.TelegramRestMethod;
import org.tyslan.butler.telegram.api.TelegramService;
import org.tyslan.butler.telegram.api.exceptions.TelegramCallException;

@Component(immediate = true)
@Designate(ocd = TelegramServiceConfig.class)
public class TelegramServiceImpl implements TelegramService {
  private static final Logger logger = LoggerFactory.getLogger(TelegramServiceImpl.class);

  private MethodExecutor executor;
  // private LongPollingSession session;

  @Activate
  public TelegramServiceImpl(TelegramServiceConfig config) {
    executor = new MethodExecutor(config.getBotToken());
    logger.debug("TelegramService active");
  }

  @Override
  public <T> void execute(TelegramRestMethod<TelegramResponse<T>> method)
      throws TelegramCallException, RestCallException {
    executor.execute(method);

  }
}
