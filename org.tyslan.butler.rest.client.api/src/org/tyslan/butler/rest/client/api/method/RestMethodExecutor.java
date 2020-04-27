package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.rest.client.api.exceptions.ValidationException;

@ProviderType
public interface RestMethodExecutor {
  /**
   *
   * @param <T> Type of the POJO
   * @param <M> Type of the method
   * @param method Rest call to execute
   * @return result of the REST call as POJO
   * @throws RestCallException
   * @throws ValidationException
   */
  <T, M extends RestMethod<T>> T execute(M method) throws RestCallException;

  /**
   *
   * @param <T> Type of the POJO the json represents
   * @param <M> Type of the method
   * @param method Rest call to execute
   * @return result of the REST call as json String;
   * @throws RestCallException
   * @throws ValidationException
   */
  <T, M extends RestMethod<T>> String call(M method) throws RestCallException;
}
