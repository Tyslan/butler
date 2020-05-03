package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.exceptions.JsonSerializationException;

@ProviderType
public interface RestPostMethod<T> extends RestMethod<T> {
  /**
   *
   * @return the method parameters as json;
   * @throws JsonSerializationException
   */
  String parametersAsJson() throws JsonSerializationException;
}
