package org.tyslan.butler.telegram.meta.types.chat;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.types.message.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Chat implements ApiObject {
  @Expose
  @SerializedName(value = "id")
  private long id;
  @Expose
  @SerializedName(value = "type")
  private String type;
  @Expose
  @SerializedName(value = "title")
  private String title;
  @Expose
  @SerializedName(value = "username")
  private String userName;
  @Expose
  @SerializedName(value = "first_name")
  private String firstName;
  @Expose
  @SerializedName(value = "last_name")
  private String lastName;
  @Expose
  @SerializedName(value = "photo")
  private ChatPhoto photo;
  @Expose
  @SerializedName(value = "description")
  private String description;
  @Expose
  @SerializedName(value = "invite_link")
  private String inviteLink;
  @Expose
  @SerializedName(value = "pinned_message")
  private Message pinnedMessage;
  @Expose
  @SerializedName(value = "permissions")
  private ChatPermissions permissions;
  @Expose
  @SerializedName(value = "slow_mode_delay")
  private Integer slowModeDelay;
  @Expose
  @SerializedName(value = "sticker_set_name")
  private String stickerSetName;
  @Expose
  @SerializedName(value = "can_set_sticker_set")
  private Boolean canSetStickerSet;

  public long getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getTitle() {
    return title;
  }

  public String getUserName() {
    return userName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public ChatPhoto getPhoto() {
    return photo;
  }

  public String getDescription() {
    return description;
  }

  public String getInviteLink() {
    return inviteLink;
  }

  public Message getPinnedMessage() {
    return pinnedMessage;
  }

  public ChatPermissions getPermissions() {
    return permissions;
  }

  public Integer getSlowModeDelay() {
    return slowModeDelay;
  }

  public String getStickerSetName() {
    return stickerSetName;
  }

  public Boolean getCanSetStickerSet() {
    return canSetStickerSet;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((canSetStickerSet == null) ? 0 : canSetStickerSet.hashCode());
    result = (prime * result) + ((description == null) ? 0 : description.hashCode());
    result = (prime * result) + ((firstName == null) ? 0 : firstName.hashCode());
    result = (prime * result) + (int) (id ^ (id >>> 32));
    result = (prime * result) + ((inviteLink == null) ? 0 : inviteLink.hashCode());
    result = (prime * result) + ((lastName == null) ? 0 : lastName.hashCode());
    result = (prime * result) + ((permissions == null) ? 0 : permissions.hashCode());
    result = (prime * result) + ((photo == null) ? 0 : photo.hashCode());
    result = (prime * result) + ((pinnedMessage == null) ? 0 : pinnedMessage.hashCode());
    result = (prime * result) + ((slowModeDelay == null) ? 0 : slowModeDelay.hashCode());
    result = (prime * result) + ((stickerSetName == null) ? 0 : stickerSetName.hashCode());
    result = (prime * result) + ((title == null) ? 0 : title.hashCode());
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());
    result = (prime * result) + ((userName == null) ? 0 : userName.hashCode());
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
    Chat other = (Chat) obj;
    if (canSetStickerSet == null) {
      if (other.canSetStickerSet != null) {
        return false;
      }
    } else if (!canSetStickerSet.equals(other.canSetStickerSet)) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (inviteLink == null) {
      if (other.inviteLink != null) {
        return false;
      }
    } else if (!inviteLink.equals(other.inviteLink)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (permissions == null) {
      if (other.permissions != null) {
        return false;
      }
    } else if (!permissions.equals(other.permissions)) {
      return false;
    }
    if (photo == null) {
      if (other.photo != null) {
        return false;
      }
    } else if (!photo.equals(other.photo)) {
      return false;
    }
    if (pinnedMessage == null) {
      if (other.pinnedMessage != null) {
        return false;
      }
    } else if (!pinnedMessage.equals(other.pinnedMessage)) {
      return false;
    }
    if (slowModeDelay == null) {
      if (other.slowModeDelay != null) {
        return false;
      }
    } else if (!slowModeDelay.equals(other.slowModeDelay)) {
      return false;
    }
    if (stickerSetName == null) {
      if (other.stickerSetName != null) {
        return false;
      }
    } else if (!stickerSetName.equals(other.stickerSetName)) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    if (userName == null) {
      if (other.userName != null) {
        return false;
      }
    } else if (!userName.equals(other.userName)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Chat [id=" + id + ", type=" + type + ", title=" + title + ", userName=" + userName
        + ", firstName=" + firstName + ", lastName=" + lastName + ", photo=" + photo
        + ", description=" + description + ", inviteLink=" + inviteLink + ", pinnedMessage="
        + pinnedMessage + ", permissions=" + permissions + ", slowModeDelay=" + slowModeDelay
        + ", stickerSetName=" + stickerSetName + ", canSetStickerSet=" + canSetStickerSet + "]";
  }
}
