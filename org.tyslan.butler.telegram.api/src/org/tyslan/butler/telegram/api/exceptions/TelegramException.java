package org.tyslan.butler.telegram.api.exceptions;

public class TelegramException extends Exception {
  private static final long serialVersionUID = 7468825867257803369L;

  public TelegramException(String message) {
    super(message);
  }
}