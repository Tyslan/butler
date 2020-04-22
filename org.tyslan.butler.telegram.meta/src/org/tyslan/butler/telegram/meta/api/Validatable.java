package org.tyslan.butler.telegram.meta.api;

import org.tyslan.butler.telegram.meta.exceptions.TelegramValidationExeception;

public interface Validatable {
  /**
   * Let the object validate itself.
   *
   * @throws TelegramValidationExeception
   */
  void validate() throws TelegramValidationExeception;
}
