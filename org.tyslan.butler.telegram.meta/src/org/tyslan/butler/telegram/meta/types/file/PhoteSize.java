package org.tyslan.butler.telegram.meta.types.file;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class PhoteSize implements ApiObject {
  @Expose
  @SerializedName(value = "file_id")
  private String fileId;
  @Expose
  @SerializedName(value = "file_unique_id")
  private String fileUniqueId;
  @Expose
  @SerializedName(value = "width")
  private int width;
  @Expose
  @SerializedName(value = "height")
  private int height;
  @Expose
  @SerializedName(value = "file_size")
  private Integer fileSize;

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
