package org.tyslan.butler.rest.client.api.method;

import org.osgi.annotation.versioning.ProviderType;
import org.tyslan.butler.rest.client.api.exceptions.JsonParseException;
import org.tyslan.butler.rest.client.api.validation.Validatable;

@ProviderType
public interface RestMethod<T> extends Validatable {
  /**
   *
   * @return path for the API call
   */
  String getMethod();

  /**
   *
   * @return Type of the REST Call
   */
  RestMethodType getType();

  /**
   *
   * @param json String representing the received Object
   * @return Received Object as Java class
   * @throws JsonParseException
   */
  T fromJson(String json) throws JsonParseException;
}
