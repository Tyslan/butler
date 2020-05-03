package org.tyslan.butler.telegram.meta.methods;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.JsonParseException;
import org.tyslan.butler.rest.client.api.exceptions.JsonSerializationException;
import org.tyslan.butler.rest.client.api.exceptions.ValidationException;
import org.tyslan.butler.rest.client.api.method.RestMethodType;
import org.tyslan.butler.rest.client.api.method.RestPostMethod;
import org.tyslan.butler.telegram.api.TelegramResponse;
import org.tyslan.butler.telegram.api.TelegramRestMethod;
import org.tyslan.butler.telegram.meta.Constants;
import org.tyslan.butler.telegram.meta.types.Update;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetUpdates extends TelegramRestMethod<TelegramResponse<List<Update>>>
    implements RestPostMethod<TelegramResponse<List<Update>>> {
  private static final Logger logger = LoggerFactory.getLogger(GetUpdates.class);

  private static final String PATH = "getUpdates";

  private ObjectMapper mapper;
  private JavaType type;

  @JsonProperty(value = "offset")
  private Long offset;
  @JsonProperty(value = "limit")
  private Integer limit;
  @JsonProperty(value = "timeout")
  private Integer timeout;
  @JsonProperty(value = "allowed_updates")
  private String[] allowedUpdates;

  public GetUpdates() {
    mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.setSerializationInclusion(Include.NON_NULL);

    JavaType collectionType =
        mapper.getTypeFactory().constructCollectionType(List.class, Update.class);
    type = mapper.getTypeFactory().constructParametricType(TelegramResponse.class, collectionType);
  }

  @Override
  @JsonIgnore
  public String getMethod() {
    return PATH;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public void setAllowedUpdates(String[] allowedUpdates) {
    this.allowedUpdates = allowedUpdates;
  }

  @Override
  public void validate() throws ValidationException {
    if (limit != null) {
      if ((limit < Constants.GETUPDATES_LOWER_LIMIT)
          || (limit > Constants.GETUPDATES_UPPER_LIMIT)) {
        throw new ValidationException(String.format("Limit should be between %d and %d.",
            Constants.GETUPDATES_LOWER_LIMIT, Constants.GETUPDATES_UPPER_LIMIT));
      }
    }
  }

  @Override
  public RestMethodType getType() {
    return RestMethodType.POST;
  }

  @Override
  public TelegramResponse<List<Update>> fromJson(String json) throws JsonParseException {
    try {
      return mapper.readValue(json, type);
    } catch (JsonProcessingException e) {
      logger.error(e.getMessage(), e);
      throw new JsonParseException(
          "Parsing exception during parsing of class: " + Update.class.getCanonicalName());
    }
  }

  @Override
  public String parametersAsJson() throws JsonSerializationException {
    try {
      return mapper.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      logger.error(e.getMessage(), e);
      throw new JsonSerializationException("Serialization exception during serialization of class: "
          + this.getClass().getCanonicalName());
    }
  }
}
