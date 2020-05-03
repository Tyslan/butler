package org.tyslan.butler.telegram.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TelegramResponse<T> {
  @JsonProperty("ok")
  private boolean responseStatus;
  @JsonProperty("result")
  private T response;
  @JsonProperty("description")
  private String description;
  @JsonProperty("error_code")
  private Integer errorCode;

  private TelegramResponse() {
    // Jackson
  }

  @JsonIgnore
  public boolean isResponseStatus() {
    return responseStatus;
  }

  @JsonIgnore
  public T getResponse() {
    return response;
  }

  @JsonIgnore
  public String getDescription() {
    return description;
  }

  @JsonIgnore
  public Integer getErrorCode() {
    return errorCode;
  }
}
