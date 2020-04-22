package org.tyslan.butler.telegram.meta.types.poll;

import java.util.Arrays;
import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.types.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class PollAnswer implements ApiObject {
  @Expose
  @SerializedName(value = "poll_id")
  private String pollId;
  @Expose
  @SerializedName(value = "user")
  private User user;
  @Expose
  @SerializedName(value = "option_ids")
  private int[] optionIds;

  public String getPollId() {
    return pollId;
  }

  public User getUser() {
    return user;
  }

  public int[] getOptionIds() {
    return optionIds;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + Arrays.hashCode(optionIds);
    result = (prime * result) + ((pollId == null) ? 0 : pollId.hashCode());
    result = (prime * result) + ((user == null) ? 0 : user.hashCode());
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
    PollAnswer other = (PollAnswer) obj;
    if (!Arrays.equals(optionIds, other.optionIds)) {
      return false;
    }
    if (pollId == null) {
      if (other.pollId != null) {
        return false;
      }
    } else if (!pollId.equals(other.pollId)) {
      return false;
    }
    if (user == null) {
      if (other.user != null) {
        return false;
      }
    } else if (!user.equals(other.user)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PollAnswer [pollId=" + pollId + ", user=" + user + ", optionIds="
        + Arrays.toString(optionIds) + "]";
  }
}
