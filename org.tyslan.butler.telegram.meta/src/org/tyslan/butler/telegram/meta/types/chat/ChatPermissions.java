package org.tyslan.butler.telegram.meta.types.chat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatPermissions {
  @JsonProperty(value = "can_send_messages")
  private Boolean canSendMessages;
  @JsonProperty(value = "can_send_media_messages")
  private Boolean canSendMediaMessages;
  @JsonProperty(value = "can_send_polls")
  private Boolean canSendPolls;
  @JsonProperty(value = "can_send_other_messages")
  private Boolean canSendOtherMessages;
  @JsonProperty(value = "can_add_web_page_previews")
  private Boolean canAddWebPagePreviews;
  @JsonProperty(value = "can_change_info")
  private Boolean canChangeInfo;
  @JsonProperty(value = "can_invite_users")
  private Boolean canInvateUsers;
  @JsonProperty(value = "can_pin_messages")
  private Boolean canPinMessages;

  private ChatPermissions() {
    // Jackson
  }

  public Boolean getCanSendMessages() {
    return canSendMessages;
  }

  public Boolean getCanSendMediaMessages() {
    return canSendMediaMessages;
  }

  public Boolean getCanSendPolls() {
    return canSendPolls;
  }

  public Boolean getCanSendOtherMessages() {
    return canSendOtherMessages;
  }

  public Boolean getCanAddWebPagePreviews() {
    return canAddWebPagePreviews;
  }

  public Boolean getCanChangeInfo() {
    return canChangeInfo;
  }

  public Boolean getCanInvateUsers() {
    return canInvateUsers;
  }

  public Boolean getCanPinMessages() {
    return canPinMessages;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        (prime * result) + ((canAddWebPagePreviews == null) ? 0 : canAddWebPagePreviews.hashCode());
    result = (prime * result) + ((canChangeInfo == null) ? 0 : canChangeInfo.hashCode());
    result = (prime * result) + ((canInvateUsers == null) ? 0 : canInvateUsers.hashCode());
    result = (prime * result) + ((canPinMessages == null) ? 0 : canPinMessages.hashCode());
    result =
        (prime * result) + ((canSendMediaMessages == null) ? 0 : canSendMediaMessages.hashCode());
    result = (prime * result) + ((canSendMessages == null) ? 0 : canSendMessages.hashCode());
    result =
        (prime * result) + ((canSendOtherMessages == null) ? 0 : canSendOtherMessages.hashCode());
    result = (prime * result) + ((canSendPolls == null) ? 0 : canSendPolls.hashCode());
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
    ChatPermissions other = (ChatPermissions) obj;
    if (canAddWebPagePreviews == null) {
      if (other.canAddWebPagePreviews != null) {
        return false;
      }
    } else if (!canAddWebPagePreviews.equals(other.canAddWebPagePreviews)) {
      return false;
    }
    if (canChangeInfo == null) {
      if (other.canChangeInfo != null) {
        return false;
      }
    } else if (!canChangeInfo.equals(other.canChangeInfo)) {
      return false;
    }
    if (canInvateUsers == null) {
      if (other.canInvateUsers != null) {
        return false;
      }
    } else if (!canInvateUsers.equals(other.canInvateUsers)) {
      return false;
    }
    if (canPinMessages == null) {
      if (other.canPinMessages != null) {
        return false;
      }
    } else if (!canPinMessages.equals(other.canPinMessages)) {
      return false;
    }
    if (canSendMediaMessages == null) {
      if (other.canSendMediaMessages != null) {
        return false;
      }
    } else if (!canSendMediaMessages.equals(other.canSendMediaMessages)) {
      return false;
    }
    if (canSendMessages == null) {
      if (other.canSendMessages != null) {
        return false;
      }
    } else if (!canSendMessages.equals(other.canSendMessages)) {
      return false;
    }
    if (canSendOtherMessages == null) {
      if (other.canSendOtherMessages != null) {
        return false;
      }
    } else if (!canSendOtherMessages.equals(other.canSendOtherMessages)) {
      return false;
    }
    if (canSendPolls == null) {
      if (other.canSendPolls != null) {
        return false;
      }
    } else if (!canSendPolls.equals(other.canSendPolls)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ChatPermissions [canSendMessages=" + canSendMessages + ", canSendMediaMessages="
        + canSendMediaMessages + ", canSendPolls=" + canSendPolls + ", canSendOtherMessages="
        + canSendOtherMessages + ", canAddWebPagePreviews=" + canAddWebPagePreviews
        + ", canChangeInfo=" + canChangeInfo + ", canInvateUsers=" + canInvateUsers
        + ", canPinMessages=" + canPinMessages + "]";
  }
}
