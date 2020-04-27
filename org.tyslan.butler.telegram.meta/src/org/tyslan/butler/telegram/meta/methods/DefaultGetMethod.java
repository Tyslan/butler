package org.tyslan.butler.telegram.meta.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.JsonParseException;
import org.tyslan.butler.rest.client.api.method.RestGetMethod;
import org.tyslan.butler.rest.client.api.method.RestMethodType;
import org.tyslan.butler.telegram.api.TelegramResponse;
import org.tyslan.butler.telegram.api.TelegramRestMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class DefaultGetMethod<T> extends TelegramRestMethod<TelegramResponse<T>>
    implements RestGetMethod<TelegramResponse<T>> {
  private static final Logger logger = LoggerFactory.getLogger(DefaultGetMethod.class);

  private ObjectMapper mapper;
  private JavaType type;

  protected DefaultGetMethod(Class<T> methodResultType) {

    mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    type =
        mapper.getTypeFactory().constructParametricType(TelegramResponse.class, methodResultType);
  }

  @Override
  @JsonIgnore
  public RestMethodType getType() {
    return RestMethodType.GET;
  }

  @Override
  public TelegramResponse<T> fromJson(String json) throws JsonParseException {
    try {
      return mapper.readValue(json, type);
    } catch (JsonProcessingException e) {
      logger.error(e.getMessage(), e);
      throw new JsonParseException(
          "Parsing exception during parsing of class: " + type.toCanonical());
    }
  }
}
