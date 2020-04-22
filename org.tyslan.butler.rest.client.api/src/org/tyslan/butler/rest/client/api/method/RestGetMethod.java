package org.tyslan.butler.rest.client.api.method;

import java.util.Map;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface RestGetMethod {
  /**
   *
   * @return the parameters of the GET method as Immutable map
   */
  Map<String, String> getParameters();
}
