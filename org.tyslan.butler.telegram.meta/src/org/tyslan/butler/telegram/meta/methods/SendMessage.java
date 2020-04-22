package org.tyslan.butler.telegram.meta.methods;

import org.tyslan.butler.telegram.meta.api.methods.BotPostMethod;
import org.tyslan.butler.telegram.meta.exceptions.TelegramValidationExeception;
import org.tyslan.butler.telegram.meta.types.message.Message;
import org.tyslan.butler.telegram.meta.types.message.ParseMode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendMessage extends BotPostMethod<Message> {
  private static final String PATH = "sendMessage";

  @Expose
  @SerializedName(value = "chat_id")
  private long chatId;
  @Expose
  @SerializedName(value = "text")
  private String text;
  @Expose
  @SerializedName(value = "parse_mode")
  private String parseMode;
  @Expose
  @SerializedName(value = "disable_web_page_preview")
  private Boolean disableWebPagePreview;
  @Expose
  @SerializedName(value = "disable_notification")
  private Boolean disableNotification;
  @Expose
  @SerializedName(value = "reply_to_message_id")
  private Long replyToMessageId;
  // TODO
  // private ? replyMarkup

  public SendMessage(long chatId, String text) {
    super(Message.class);
    this.chatId = chatId;
    this.text = text;
  }

  public void setChatId(long chatId) {
    this.chatId = chatId;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setParseMode(ParseMode parseMode) {
    this.parseMode = parseMode.toString();
  }

  public void setDisableWebPagePreview(boolean disableWebPagePreview) {
    this.disableWebPagePreview = disableWebPagePreview;
  }

  public void setDisableNotification(boolean disableNotification) {
    this.disableNotification = disableNotification;
  }

  public void setReplyToMessageId(long replyToMessageId) {
    this.replyToMessageId = replyToMessageId;
  }

  @Override
  public String getMethod() {
    return PATH;
  }

  @Override
  public void validate() throws TelegramValidationExeception {
    if (text == null) {
      throw new TelegramValidationExeception("Text cannot be null;");
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (int) (chatId ^ (chatId >>> 32));
    result =
        (prime * result) + ((disableNotification == null) ? 0 : disableNotification.hashCode());
    result =
        (prime * result) + ((disableWebPagePreview == null) ? 0 : disableWebPagePreview.hashCode());
    result = (prime * result) + ((parseMode == null) ? 0 : parseMode.hashCode());
    result = (prime * result) + ((replyToMessageId == null) ? 0 : replyToMessageId.hashCode());
    result = (prime * result) + ((text == null) ? 0 : text.hashCode());
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
    SendMessage other = (SendMessage) obj;
    if (chatId != other.chatId) {
      return false;
    }
    if (disableNotification == null) {
      if (other.disableNotification != null) {
        return false;
      }
    } else if (!disableNotification.equals(other.disableNotification)) {
      return false;
    }
    if (disableWebPagePreview == null) {
      if (other.disableWebPagePreview != null) {
        return false;
      }
    } else if (!disableWebPagePreview.equals(other.disableWebPagePreview)) {
      return false;
    }
    if (parseMode == null) {
      if (other.parseMode != null) {
        return false;
      }
    } else if (!parseMode.equals(other.parseMode)) {
      return false;
    }
    if (replyToMessageId == null) {
      if (other.replyToMessageId != null) {
        return false;
      }
    } else if (!replyToMessageId.equals(other.replyToMessageId)) {
      return false;
    }
    if (text == null) {
      if (other.text != null) {
        return false;
      }
    } else if (!text.equals(other.text)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "SendMessage [chatId=" + chatId + ", text=" + text + ", parseMode=" + parseMode
        + ", disableWebPagePreview=" + disableWebPagePreview + ", disableNotification="
        + disableNotification + ", replyToMessageId=" + replyToMessageId + "]";
  }
}
