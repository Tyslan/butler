package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface RestPostMethod {
  /**
   *
   * @return the method parameters as json;
   */
  String parametersAsJson();
}
