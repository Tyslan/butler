package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.object.RestObject;

@ProviderType
public interface RestPostMethod<T extends RestObject> extends RestMethod<T> {
  /**
   *
   * @return the method parameters as json;
   */
  String parametersAsJson();
}
