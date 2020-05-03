package org.tyslan.butler.rest.client.api.exceptions;

import org.osgi.annotation.versioning.ProviderType;

@SuppressWarnings("serial")
@ProviderType
public class JsonSerializationException extends RestCallException {
  public JsonSerializationException(String message) {
    super(message);
  }
}
