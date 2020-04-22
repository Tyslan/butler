package org.tyslan.butler.telegram.meta.types.chat;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class ChatPhoto implements ApiObject {
  @Expose
  @SerializedName(value = "small_file_id")
  private String smallFileId;
  @Expose
  @SerializedName(value = "small_file_unique_id")
  private String smallFileUniqueId;
  @Expose
  @SerializedName(value = "big_file_id")
  private String bigFileId;
  @Expose
  @SerializedName("big_file_unique_id")
  private String bigFileUniqueId;

  public String getSmallFileId() {
    return smallFileId;
  }

  public String getSmallFileUniqueId() {
    return smallFileUniqueId;
  }

  public String getBigFileId() {
    return bigFileId;
  }

  public String getBigFileUniqueId() {
    return bigFileUniqueId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((bigFileId == null) ? 0 : bigFileId.hashCode());
    result = (prime * result) + ((bigFileUniqueId == null) ? 0 : bigFileUniqueId.hashCode());
    result = (prime * result) + ((smallFileId == null) ? 0 : smallFileId.hashCode());
    result = (prime * result) + ((smallFileUniqueId == null) ? 0 : smallFileUniqueId.hashCode());
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
    ChatPhoto other = (ChatPhoto) obj;
    if (bigFileId == null) {
      if (other.bigFileId != null) {
        return false;
      }
    } else if (!bigFileId.equals(other.bigFileId)) {
      return false;
    }
    if (bigFileUniqueId == null) {
      if (other.bigFileUniqueId != null) {
        return false;
      }
    } else if (!bigFileUniqueId.equals(other.bigFileUniqueId)) {
      return false;
    }
    if (smallFileId == null) {
      if (other.smallFileId != null) {
        return false;
      }
    } else if (!smallFileId.equals(other.smallFileId)) {
      return false;
    }
    if (smallFileUniqueId == null) {
      if (other.smallFileUniqueId != null) {
        return false;
      }
    } else if (!smallFileUniqueId.equals(other.smallFileUniqueId)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ChatPhoto [smallFileId=" + smallFileId + ", smallFileUniqueId=" + smallFileUniqueId
        + ", bigFileId=" + bigFileId + ", bigFileUniqueId=" + bigFileUniqueId + "]";
  }
}
