package org.tyslan.butler.rest.client.api.validation;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.exceptions.ValidationException;

@ProviderType
public interface Validatable {
  /**
   * Make the object validate itself.
   */
  void validate() throws ValidationException;
}
