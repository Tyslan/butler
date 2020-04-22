package org.tyslan.butler.telegram.meta.exceptions;

public class TelegramCallException extends TelegramException {
  private static final long serialVersionUID = -5058463351702172078L;

  public TelegramCallException(int errorCode, String description) {
    super(String.format("Error %d: %s", errorCode, description));
  }
}
