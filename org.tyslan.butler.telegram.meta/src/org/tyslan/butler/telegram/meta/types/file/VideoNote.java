package org.tyslan.butler.telegram.meta.types.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoNote {
  @JsonProperty(value = "file_id")
  private String fileId;
  @JsonProperty(value = "file_unique_id")
  private String fileUniqueId;
  @JsonProperty(value = "length")
  private int length;
  @JsonProperty(value = "duration")
  private int duration;
  @JsonProperty(value = "thumb")
  private PhoteSize thumb;
  @JsonProperty(value = "file_size")
  private Integer fileSize;

  private VideoNote() {
    // Jackson
  }

  public String getFileId() {
    return fileId;
  }

  public String getFileUniqueId() {
    return fileUniqueId;
  }

  public int getLength() {
    return length;
  }

  public int getDuration() {
    return duration;
  }

  public PhoteSize getThumb() {
    return thumb;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + duration;
    result = (prime * result) + ((fileId == null) ? 0 : fileId.hashCode());
    result = (prime * result) + ((fileSize == null) ? 0 : fileSize.hashCode());
    result = (prime * result) + ((fileUniqueId == null) ? 0 : fileUniqueId.hashCode());
    result = (prime * result) + length;
    result = (prime * result) + ((thumb == null) ? 0 : thumb.hashCode());
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
    VideoNote other = (VideoNote) obj;
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
    if (length != other.length) {
      return false;
    }
    if (thumb == null) {
      if (other.thumb != null) {
        return false;
      }
    } else if (!thumb.equals(other.thumb)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "VideoNote [fileId=" + fileId + ", fileUniqueId=" + fileUniqueId + ", length=" + length
        + ", duration=" + duration + ", thumb=" + thumb + ", fileSize=" + fileSize + "]";
  }
}
