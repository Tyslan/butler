package org.tyslan.butler.rest.client.api.exceptions;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
@SuppressWarnings("serial")
public class ValidationException extends RestCallException {
  public ValidationException(String message) {
    super(message);
  }
}
