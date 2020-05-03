package org.tyslan.butler.rest.client.api.exceptions;

@SuppressWarnings("serial")
public class RestCallException extends Exception {
  public RestCallException(String message) {
    super(message);
  }
}
