package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.object.RestObject;

@ProviderType
public interface RestMethodExecutor {
  <T extends RestObject, M extends RestMethod<T>> T execute(M method);
}
