package org.tyslan.butler.telegram.meta.types.file;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
  @JsonProperty(value = "file_id")
  private String fileId;
  @JsonProperty(value = "file_unique_id")
  private String fileUniqueId;
  @JsonProperty(value = "thumb")
  private PhoteSize thumb;
  @JsonProperty(value = "file_name")
  private String fileName;
  @JsonProperty(value = "mime_type")
  private String mimeType;
  @JsonProperty(value = "file_size")
  private Integer fileSize;

  private Document() {
    // Jackson
  }

  public String getFileId() {
    return fileId;
  }

  public String getFileUniqueId() {
    return fileUniqueId;
  }

  public PhoteSize getThumb() {
    return thumb;
  }

  public String getFileName() {
    return fileName;
  }

  public String getMimeType() {
    return mimeType;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((fileId == null) ? 0 : fileId.hashCode());
    result = (prime * result) + ((fileName == null) ? 0 : fileName.hashCode());
    result = (prime * result) + ((fileSize == null) ? 0 : fileSize.hashCode());
    result = (prime * result) + ((fileUniqueId == null) ? 0 : fileUniqueId.hashCode());
    result = (prime * result) + ((mimeType == null) ? 0 : mimeType.hashCode());
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
    Document other = (Document) obj;
    if (fileId == null) {
      if (other.fileId != null) {
        return false;
      }
    } else if (!fileId.equals(other.fileId)) {
      return false;
    }
    if (fileName == null) {
      if (other.fileName != null) {
        return false;
      }
    } else if (!fileName.equals(other.fileName)) {
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
    return "Document [fileId=" + fileId + ", fileUniqueId=" + fileUniqueId + ", thumb=" + thumb
        + ", fileName=" + fileName + ", mimeType=" + mimeType + ", fileSize=" + fileSize + "]";
  }
}
