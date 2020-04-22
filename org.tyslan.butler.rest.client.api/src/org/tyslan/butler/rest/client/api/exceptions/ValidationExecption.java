package org.tyslan.butler.rest.client.api.exceptions;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
@SuppressWarnings("serial")
public class ValidationExecption extends Exception {
  public ValidationExecption(String message) {
    super(message);
  }
}
