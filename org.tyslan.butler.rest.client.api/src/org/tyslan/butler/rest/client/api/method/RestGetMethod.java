package org.tyslan.butler.rest.client.api.method;

import java.util.Map;
import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.object.RestObject;

@ProviderType
public interface RestGetMethod<T extends RestObject> extends RestMethod<T> {
  /**
   *
   * @return the parameters of the GET method as Immutable map
   */
  Map<String, String> getParameters();
}
