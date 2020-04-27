package org.tyslan.butler.telegram.meta.types.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PhoteSize {
  @JsonProperty(value = "file_id")
  private String fileId;
  @JsonProperty(value = "file_unique_id")
  private String fileUniqueId;
  @JsonProperty(value = "width")
  private int width;
  @JsonProperty(value = "height")
  private int height;
  @JsonProperty(value = "file_size")
  private Integer fileSize;

  private PhoteSize() {
    // Jackson
  }

  public String getFileId() {
    return fileId;
  }

  public String getFileUniqueId() {
    return fileUniqueId;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((fileId == null) ? 0 : fileId.hashCode());
    result = (prime * result) + ((fileSize == null) ? 0 : fileSize.hashCode());
    result = (prime * result) + ((fileUniqueId == null) ? 0 : fileUniqueId.hashCode());
    result = (prime * result) + height;
    result = (prime * result) + width;
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
    PhoteSize other = (PhoteSize) obj;
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
    if (height != other.height) {
      return false;
    }
    if (width != other.width) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PhoteSize [fileId=" + fileId + ", fileUniqueId=" + fileUniqueId + ", width=" + width
        + ", height=" + height + ", fileSize=" + fileSize + "]";
  }
}
