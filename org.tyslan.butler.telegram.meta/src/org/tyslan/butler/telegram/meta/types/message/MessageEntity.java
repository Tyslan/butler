package org.tyslan.butler.telegram.meta.types.message;

import org.tyslan.butler.telegram.meta.types.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageEntity {
  @JsonProperty(value = "type")
  private String type;
  @JsonProperty(value = "offset")
  private int offset;
  @JsonProperty(value = "length")
  private int length;
  @JsonProperty(value = "url")
  private String url;
  @JsonProperty(value = "user")
  private User user;
  @JsonProperty(value = "language")
  private String language;

  private MessageEntity() {
    // Jackson
  }

  public String getType() {
    return type;
  }

  public int getOffset() {
    return offset;
  }

  public int getLength() {
    return length;
  }

  public String getUrl() {
    return url;
  }

  public User getUser() {
    return user;
  }

  public String getLanguage() {
    return language;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((language == null) ? 0 : language.hashCode());
    result = (prime * result) + length;
    result = (prime * result) + offset;
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());
    result = (prime * result) + ((url == null) ? 0 : url.hashCode());
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
    MessageEntity other = (MessageEntity) obj;
    if (language == null) {
      if (other.language != null) {
        return false;
      }
    } else if (!language.equals(other.language)) {
      return false;
    }
    if (length != other.length) {
      return false;
    }
    if (offset != other.offset) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    if (url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (!url.equals(other.url)) {
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
    return "MessageEntity [type=" + type + ", offset=" + offset + ", length=" + length + ", url="
        + url + ", user=" + user + ", language=" + language + "]";
  }
}
