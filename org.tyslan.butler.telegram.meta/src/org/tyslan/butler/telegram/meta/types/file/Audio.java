package org.tyslan.butler.telegram.meta.types.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Audio {
  @JsonProperty(value = "file_id")
  private String fileId;
  @JsonProperty(value = "file_unique_id")
  private String fileUniqueId;
  @JsonProperty(value = "duration")
  private int duration;
  @JsonProperty(value = "performer")
  private String performer;
  @JsonProperty(value = "title")
  private String title;
  @JsonProperty(value = "mime_type")
  private String mimeType;
  @JsonProperty(value = "file_size")
  private Integer fileSize;
  @JsonProperty(value = "thumb")
  private PhoteSize thumb;

  private Audio() {
    // Jackson
  }

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
