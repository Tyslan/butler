package org.tyslan.butler.telegram.meta.types.file;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Audio implements ApiObject {
  @Expose
  @SerializedName(value = "file_id")
  private String fileId;
  @Expose
  @SerializedName(value = "file_unique_id")
  private String fileUniqueId;
  @Expose
  @SerializedName(value = "duration")
  private int duration;
  @Expose
  @SerializedName(value = "performer")
  private String performer;
  @Expose
  @SerializedName(value = "title")
  private String title;
  @Expose
  @SerializedName(value = "mime_type")
  private String mimeType;
  @Expose
  @SerializedName(value = "file_size")
  private Integer fileSize;
  @Expose
  @SerializedName(value = "thumb")
  private PhoteSize thumb;

  public String getFileId() {
    return fileId;
  }

  public String getFileUniqueId() {
    return fileUniqueId;
  }

  public int getDuration() {
    return duration;
  }

  public String getPerformer() {
    return performer;
  }

  public String getTitle() {
    return title;
  }

  public String getMimeType() {
    return mimeType;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  public PhoteSize getThumb() {
    return thumb;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + duration;
    result = (prime * result) + ((fileId == null) ? 0 : fileId.hashCode());
    result = (prime * result) + ((fileSize == null) ? 0 : fileSize.hashCode());
    result = (prime * result) + ((fileUniqueId == null) ? 0 : fileUniqueId.hashCode());
    result = (prime * result) + ((mimeType == null) ? 0 : mimeType.hashCode());
    result = (prime * result) + ((performer == null) ? 0 : performer.hashCode());
    result = (prime * result) + ((thumb == null) ? 0 : thumb.hashCode());
    result = (prime * result) + ((title == null) ? 0 : title.hashCode());
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
    Audio other = (Audio) obj;
    if (duration != other.duration) {
      return false;
    }
    if (fileId == null) {
      if (other.fileId != null) {
        return false;
      }
    } else if (!fileId.equals(other.fileId)) {
      return false;
    }
    if (fileSize == null) {
      if (other.fileSize != null) {
        return false;
      }
    } else if (!fileSize.equals(other.fileSize)) {
      return false;
    }
    if (fileUniqueId == null) {
      if (other.fileUniqueId != null) {
        return false;
      }
    } else if (!fileUniqueId.equals(other.fileUniqueId)) {
      return false;
    }
    if (mimeType == null) {
      if (other.mimeType != null) {
        return false;
      }
    } else if (!mimeType.equals(other.mimeType)) {
      return false;
    }
    if (performer == null) {
      if (other.performer != null) {
        return false;
      }
    } else if (!performer.equals(other.performer)) {
      return false;
    }
    if (thumb == null) {
      if (other.thumb != null) {
        return false;
      }
    } else if (!thumb.equals(other.thumb)) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Audio [fileId=" + fileId + ", fileUniqueId=" + fileUniqueId + ", duration=" + duration
        + ", performer=" + performer + ", title=" + title + ", mimeType=" + mimeType + ", fileSize="
        + fileSize + ", thumb=" + thumb + "]";
  }
}
