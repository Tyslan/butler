package org.tyslan.butler.telegram.api.exceptions;

public class TelegramValidationExeception extends TelegramException {
  private static final long serialVersionUID = 2519466480774823428L;

  public TelegramValidationExeception(String message) {
    super(message);
  }

}
