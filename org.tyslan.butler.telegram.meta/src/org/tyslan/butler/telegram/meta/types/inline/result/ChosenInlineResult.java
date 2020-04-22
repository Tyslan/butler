package org.tyslan.butler.telegram.meta.types.inline.result;

import org.tyslan.butler.telegram.meta.types.Location;
import org.tyslan.butler.telegram.meta.types.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class ChosenInlineResult implements InlineQueryResult {
  @Expose
  @SerializedName(value = "result_id")
  private String resultId;
  @Expose
  @SerializedName(value = "from")
  private User from;
  @Expose
  @SerializedName(value = "location")
  private Location location;
  @Expose
  @SerializedName(value = "inline_message_id")
  private String inlineMessageId;
  @Expose
  @SerializedName(value = "query")
  private String query;

  public String getResultId() {
    return resultId;
  }

  public User getFrom() {
    return from;
  }

  public Location getLocation() {
    return location;
  }

  public String getInlineMessageId() {
    return inlineMessageId;
  }

  public String getQuery() {
    return query;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((from == null) ? 0 : from.hashCode());
    result = (prime * result) + ((inlineMessageId == null) ? 0 : inlineMessageId.hashCode());
    result = (prime * result) + ((location == null) ? 0 : location.hashCode());
    result = (prime * result) + ((query == null) ? 0 : query.hashCode());
    result = (prime * result) + ((resultId == null) ? 0 : resultId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ChosenInlineResult other = (ChosenInlineResult) obj;
    if (from == null) {
      if (other.from != null) {
        return false;
      }
    } else if (!from.equals(other.from)) {
      return false;
    }
    if (inlineMessageId == null) {
      if (other.inlineMessageId != null) {
        return false;
      }
    } else if (!inlineMessageId.equals(other.inlineMessageId)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (query == null) {
      if (other.query != null) {
        return false;
      }
    } else if (!query.equals(other.query)) {
      return false;
    }
    if (resultId == null) {
      if (other.resultId != null) {
        return false;
      }
    } else if (!resultId.equals(other.resultId)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ChosenInlineResult [resultId=" + resultId + ", from=" + from + ", location=" + location
        + ", inlineMessageId=" + inlineMessageId + ", query=" + query + "]";
  }
}
