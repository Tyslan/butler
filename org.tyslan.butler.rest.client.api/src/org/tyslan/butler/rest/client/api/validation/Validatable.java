package org.tyslan.butler.rest.client.api.validation;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Validatable {
  /**
   * Make the object validate itself.
   */
  void validate();
}
