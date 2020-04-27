package org.tyslan.butler.telegram.meta.types;

import org.tyslan.butler.telegram.meta.types.message.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CallbackQuery {
  @JsonProperty(value = "id")
  private String id;
  @JsonProperty(value = "from")
  private User from;
  @JsonProperty(value = "message")
  private Message message;
  @JsonProperty(value = "inline_message_id")
  private String inlineMessageId;
  @JsonProperty(value = "chat_instance")
  private String chatInstance;
  @JsonProperty(value = "data")
  private String data;
  @JsonProperty(value = "game_short_name")
  private String gameShortName;

  private CallbackQuery() {
    // Jackson
  }

  public String getId() {
    return id;
  }

  public User getFrom() {
    return from;
  }

  public Message getMessage() {
    return message;
  }

  public String getInlineMessageId() {
    return inlineMessageId;
  }

  public String getChatInstance() {
    return chatInstance;
  }

  public String getData() {
    return data;
  }

  public String getGameShortName() {
    return gameShortName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((chatInstance == null) ? 0 : chatInstance.hashCode());
    result = (prime * result) + ((data == null) ? 0 : data.hashCode());
    result = (prime * result) + ((from == null) ? 0 : from.hashCode());
    result = (prime * result) + ((gameShortName == null) ? 0 : gameShortName.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + ((inlineMessageId == null) ? 0 : inlineMessageId.hashCode());
    result = (prime * result) + ((message == null) ? 0 : message.hashCode());
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
    CallbackQuery other = (CallbackQuery) obj;
    if (chatInstance == null) {
      if (other.chatInstance != null) {
        return false;
      }
    } else if (!chatInstance.equals(other.chatInstance)) {
      return false;
    }
    if (data == null) {
      if (other.data != null) {
        return false;
      }
    } else if (!data.equals(other.data)) {
      return false;
    }
    if (from == null) {
      if (other.from != null) {
        return false;
      }
    } else if (!from.equals(other.from)) {
      return false;
    }
    if (gameShortName == null) {
      if (other.gameShortName != null) {
        return false;
      }
    } else if (!gameShortName.equals(other.gameShortName)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (inlineMessageId == null) {
      if (other.inlineMessageId != null) {
        return false;
      }
    } else if (!inlineMessageId.equals(other.inlineMessageId)) {
      return false;
    }
    if (message == null) {
      if (other.message != null) {
        return false;
      }
    } else if (!message.equals(other.message)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CallbackQuery [id=" + id + ", from=" + from + ", message=" + message
        + ", inlineMessageId=" + inlineMessageId + ", chatInstance=" + chatInstance + ", data="
        + data + ", gameShortName=" + gameShortName + "]";
  }
}
