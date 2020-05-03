package org.tyslan.butler.rest.client.api.exceptions;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
@SuppressWarnings("serial")
public class JsonParseException extends RestCallException {
  public JsonParseException(String message) {
    super(message);
  }
}