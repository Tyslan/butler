package org.tyslan.butler.telegram.api;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.telegram.api.exceptions.TelegramCallException;

@ProviderType
public interface TelegramService {
  <T> void execute(TelegramRestMethod<TelegramResponse<T>> telegramMethod)
      throws TelegramCallException, RestCallException;
}
