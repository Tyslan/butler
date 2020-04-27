package org.tyslan.butler.telegram.meta.types;

import org.tyslan.butler.telegram.meta.types.inline.InlineQuery;
import org.tyslan.butler.telegram.meta.types.inline.result.ChosenInlineResult;
import org.tyslan.butler.telegram.meta.types.message.Message;
import org.tyslan.butler.telegram.meta.types.payments.PreCheckoutQuery;
import org.tyslan.butler.telegram.meta.types.payments.ShippingQuery;
import org.tyslan.butler.telegram.meta.types.poll.Poll;
import org.tyslan.butler.telegram.meta.types.poll.PollAnswer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Update {
  @JsonProperty(value = "update_id")
  private long id;
  @JsonProperty(value = "message")
  private Message message;
  @JsonProperty(value = "edited_message")
  private Message editedMessage;
  @JsonProperty(value = "channel_post")
  private Message channelPost;
  @JsonProperty(value = "edited_channel_post")
  private Message editedChannelPost;
  @JsonProperty(value = "inline_query")
  private InlineQuery inlineQuery;
  @JsonProperty(value = "chosen_inline_result")
  private ChosenInlineResult choosenInlineResult;
  @JsonProperty(value = "callback_query")
  private CallbackQuery callbackQuery;
  @JsonProperty(value = "shipping_query")
  private ShippingQuery shippingQuery;
  @JsonProperty(value = "pre_checkout_query")
  private PreCheckoutQuery preCheckoutQuery;
  @JsonProperty(value = "poll")
  private Poll poll;
  @JsonProperty(value = "poll_answer")
  private PollAnswer pollAnswer;

  private Update() {
    // Jackson
  }

  public long getId() {
    return id;
  }

  public Message getMessage() {
    return message;
  }

  public Message getEditedMessage() {
    return editedMessage;
  }

  public Message getChannelPost() {
    return channelPost;
  }

  public Message getEditedChannelPost() {
    return editedChannelPost;
  }

  public InlineQuery getInlineQuery() {
    return inlineQuery;
  }

  public ChosenInlineResult getChoosenInlineResult() {
    return choosenInlineResult;
  }

  public CallbackQuery getCallbackQuery() {
    return callbackQuery;
  }

  public ShippingQuery getShippingQuery() {
    return shippingQuery;
  }

  public PreCheckoutQuery getPreCheckoutQuery() {
    return preCheckoutQuery;
  }

  public Poll getPoll() {
    return poll;
  }

  public PollAnswer getPollAnswer() {
    return pollAnswer;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((callbackQuery == null) ? 0 : callbackQuery.hashCode());
    result = (prime * result) + ((channelPost == null) ? 0 : channelPost.hashCode());
    result =
        (prime * result) + ((choosenInlineResult == null) ? 0 : choosenInlineResult.hashCode());
    result = (prime * result) + ((editedChannelPost == null) ? 0 : editedChannelPost.hashCode());
    result = (prime * result) + ((editedMessage == null) ? 0 : editedMessage.hashCode());
    result = (prime * result) + (int) (id ^ (id >>> 32));
    result = (prime * result) + ((inlineQuery == null) ? 0 : inlineQuery.hashCode());
    result = (prime * result) + ((message == null) ? 0 : message.hashCode());
    result = (prime * result) + ((poll == null) ? 0 : poll.hashCode());
    result = (prime * result) + ((pollAnswer == null) ? 0 : pollAnswer.hashCode());
    result = (prime * result) + ((preCheckoutQuery == null) ? 0 : preCheckoutQuery.hashCode());
    result = (prime * result) + ((shippingQuery == null) ? 0 : shippingQuery.hashCode());
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
    Update other = (Update) obj;
    if (callbackQuery == null) {
      if (other.callbackQuery != null) {
        return false;
      }
    } else if (!callbackQuery.equals(other.callbackQuery)) {
      return false;
    }
    if (channelPost == null) {
      if (other.channelPost != null) {
        return false;
      }
    } else if (!channelPost.equals(other.channelPost)) {
      return false;
    }
    if (choosenInlineResult == null) {
      if (other.choosenInlineResult != null) {
        return false;
      }
    } else if (!choosenInlineResult.equals(other.choosenInlineResult)) {
      return false;
    }
    if (editedChannelPost == null) {
      if (other.editedChannelPost != null) {
        return false;
      }
    } else if (!editedChannelPost.equals(other.editedChannelPost)) {
      return false;
    }
    if (editedMessage == null) {
      if (other.editedMessage != null) {
        return false;
      }
    } else if (!editedMessage.equals(other.editedMessage)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (inlineQuery == null) {
      if (other.inlineQuery != null) {
        return false;
      }
    } else if (!inlineQuery.equals(other.inlineQuery)) {
      return false;
    }
    if (message == null) {
      if (other.message != null) {
        return false;
      }
    } else if (!message.equals(other.message)) {
      return false;
    }
    if (poll == null) {
      if (other.poll != null) {
        return false;
      }
    } else if (!poll.equals(other.poll)) {
      return false;
    }
    if (pollAnswer == null) {
      if (other.pollAnswer != null) {
        return false;
      }
    } else if (!pollAnswer.equals(other.pollAnswer)) {
      return false;
    }
    if (preCheckoutQuery == null) {
      if (other.preCheckoutQuery != null) {
        return false;
      }
    } else if (!preCheckoutQuery.equals(other.preCheckoutQuery)) {
      return false;
    }
    if (shippingQuery == null) {
      if (other.shippingQuery != null) {
        return false;
      }
    } else if (!shippingQuery.equals(other.shippingQuery)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Update [id=" + id + ", message=" + message + ", editedMessage=" + editedMessage
        + ", channelPost=" + channelPost + ", editedChannelPost=" + editedChannelPost
        + ", inlineQuery=" + inlineQuery + ", choosenInlineResult=" + choosenInlineResult
        + ", callbackQuery=" + callbackQuery + ", shippingQuery=" + shippingQuery
        + ", preCheckoutQuery=" + preCheckoutQuery + ", poll=" + poll + ", pollAnswer=" + pollAnswer
        + "]";
  }
}
