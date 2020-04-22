package org.tyslan.butler.telegram.meta.api.bot;

import org.tyslan.butler.telegram.meta.api.methods.BotMethod;
import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;

public interface ApiCaller {
  default <T extends ApiObject, M extends BotMethod<T>> T execute(M method)
      throws TelegramException {
    if (method == null) {
      throw new TelegramException("Parameter method can not be null");
    }
    return sendMethod(method);
  }

  <T extends ApiObject, M extends BotMethod<T>> T sendMethod(M method) throws TelegramException;
}
