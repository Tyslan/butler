package org.tyslan.butler.telegram.meta.types.poll;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PollOption {
  @JsonProperty(value = "text")
  private String text;
  @JsonProperty(value = "voter_count")
  private int voterCount;

  private PollOption() {
    // Jackson
  }

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
