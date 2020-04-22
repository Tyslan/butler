package org.tyslan.butler.telegram.meta.api.methods;

import org.tyslan.butler.telegram.meta.api.Validatable;
import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;

public interface BotMethod<T extends ApiObject> extends Validatable {
  /**
   *
   * @return path for the API call
   */
  String getMethod();

  /**
   *
   * @return Type of the REST Call
   */
  MethodType getType();

  /**
   *
   * @param json String representing the received Object
   * @return Received Object as Java class
   * @throws TelegramException
   */
  T fromJson(String json) throws TelegramException;
}
