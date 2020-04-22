package org.tyslan.butler.telegram.meta.methods;

import org.tyslan.butler.telegram.meta.api.methods.BotPostMethod;
import org.tyslan.butler.telegram.meta.exceptions.TelegramValidationExeception;
import org.tyslan.butler.telegram.meta.types.Update;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUpdates extends BotPostMethod<Update> {
  private static final String PATH = "getUpdates";

  @Expose
  @SerializedName(value = "offset")
  private Long offset;
  @Expose
  @SerializedName(value = "limit")
  private Integer limit;
  @Expose
  @SerializedName(value = "timeout")
  private Integer timeout;
  @Expose
  @SerializedName(value = "allowed_updates")
  private String[] allowedUpdates;

  public GetUpdates() {
    super(Update.class);
  }

  @Override
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
  public void validate() throws TelegramValidationExeception {
    if (limit != null) {
      if ((limit < 1) || (limit > 100)) {
        throw new TelegramValidationExeception("Limit should be 1 and 100.");
      }
    }
    // TODO Auto-generated method stub

  }
}
