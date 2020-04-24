package org.tyslan.butler.weather.openweathermap.meta.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.JsonParseException;
import org.tyslan.butler.rest.client.api.method.RestGetMethod;
import org.tyslan.butler.rest.client.api.method.RestMethodType;
import org.tyslan.butler.rest.client.api.object.RestObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class DefaultGetMethod<T extends RestObject> implements RestGetMethod<T> {
  private static final Logger logger = LoggerFactory.getLogger(DefaultGetMethod.class);
  protected ObjectMapper mapper;
  protected Class<T> methodResultType;

  public DefaultGetMethod(Class<T> methodResultType) {
    this.methodResultType = methodResultType;
    this.mapper = new ObjectMapper();

    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  @Override
  public RestMethodType getType() {
    return RestMethodType.GET;
  }

  @Override
  public T fromJson(String json) throws JsonParseException {
    try {
      return mapper.readValue(json, methodResultType);
    } catch (JsonProcessingException e) {
      logger.error(e.getMessage(), e);
      throw new JsonParseException(
          "Parsing exception during parsing of class: " + methodResultType.getCanonicalName());
    }
  }

}
