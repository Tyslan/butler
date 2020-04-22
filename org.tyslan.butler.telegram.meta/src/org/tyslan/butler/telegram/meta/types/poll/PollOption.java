package org.tyslan.butler.telegram.meta.types.poll;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class PollOption implements ApiObject {
  @Expose
  @SerializedName(value = "text")
  private String text;
  @Expose
  @SerializedName(value = "voter_count")
  private int voterCount;

  public String getText() {
    return text;
  }

  public int getVoterCount() {
    return voterCount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((text == null) ? 0 : text.hashCode());
    result = (prime * result) + voterCount;
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
    PollOption other = (PollOption) obj;
    if (text == null) {
      if (other.text != null) {
        return false;
      }
    } else if (!text.equals(other.text)) {
      return false;
    }
    if (voterCount != other.voterCount) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PollOption [text=" + text + ", voterCount=" + voterCount + "]";
  }
}
