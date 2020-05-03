package org.tyslan.butler.telegram.meta.types.message;

import org.tyslan.butler.telegram.meta.types.Contact;
import org.tyslan.butler.telegram.meta.types.Dice;
import org.tyslan.butler.telegram.meta.types.Location;
import org.tyslan.butler.telegram.meta.types.User;
import org.tyslan.butler.telegram.meta.types.Venue;
import org.tyslan.butler.telegram.meta.types.chat.Chat;
import org.tyslan.butler.telegram.meta.types.file.Animation;
import org.tyslan.butler.telegram.meta.types.file.Audio;
import org.tyslan.butler.telegram.meta.types.file.Document;
import org.tyslan.butler.telegram.meta.types.file.PhoteSize;
import org.tyslan.butler.telegram.meta.types.file.Video;
import org.tyslan.butler.telegram.meta.types.file.VideoNote;
import org.tyslan.butler.telegram.meta.types.file.Voice;
import org.tyslan.butler.telegram.meta.types.payments.Invoice;
import org.tyslan.butler.telegram.meta.types.payments.SuccessfulPayment;
import org.tyslan.butler.telegram.meta.types.poll.Poll;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

  @JsonProperty(value = "message_id")
  private long messageId;

  @JsonProperty(value = "from")
  private User from;

  @JsonProperty(value = "date")
  private long unixTimestamp;

  @JsonProperty(value = "chat")
  private Chat chat;

  @JsonProperty(value = "forward_from")
  private User forwardedFrom;

  @JsonProperty(value = "forward_from_chat")
  private Chat forwardedFromChat;

  @JsonProperty(value = "forward_from_message_id")
  private Long forwarderFromMessageId;

  @JsonProperty(value = "forward_signature")
  private String forwardSignature;

  @JsonProperty(value = "forward_sender_name")
  private String forwardSenderName;

  @JsonProperty(value = "forward_date")
  private Long forwardUnixTimestamp;

  @JsonProperty(value = "reply_to_message")
  private Message replyToMessage;

  @JsonProperty(value = "edit_date")
  private Long editUnixTimestamp;

  @JsonProperty(value = "media_group_id")
  private String mediaGroupType;

  @JsonProperty(value = "author_signature")
  private String authorSignature;

  @JsonProperty(value = "text")
  private String text;

  @JsonProperty(value = "entities")
  private MessageEntity[] entities;

  @JsonProperty(value = "caption_entities")
  private MessageEntity[] captionEntities;

  @JsonProperty(value = "audio")
  private Audio audio;

  @JsonProperty(value = "document")
  private Document document;

  @JsonProperty(value = "animation")
  private Animation animation;
  // TODO Game

  @JsonProperty(value = "photo")
  private PhoteSize[] photo;
  // TODO Sticker

  @JsonProperty(value = "video")
  private Video video;

  @JsonProperty(value = "voice")
  private Voice voice;

  @JsonProperty(value = "video_note")
  private VideoNote videoNote;

  @JsonProperty(value = "caption")
  private String caption;

  @JsonProperty(value = "contact")
  private Contact contact;

  @JsonProperty(value = "location")
  private Location location;

  @JsonProperty(value = "venue")
  private Venue venue;

  @JsonProperty(value = "poll")
  private Poll poll;

  @JsonProperty(value = "dice")
  private Dice dice;

  @JsonProperty(value = "new_chat_members")
  private User[] newChatMembers;

  @JsonProperty(value = "left_chat_member")
  private User leftChatMember;

  @JsonProperty(value = "new_chat_title")
  private String newChatTitle;

  @JsonProperty("new_chat_photo")
  private PhoteSize[] newChatPhoto;

  @JsonProperty("delete_chat_photo")
  private Boolean deleteChatPhoto;

  @JsonProperty(value = "group_chat_created")
  private Boolean groupChatCreated;

  @JsonProperty(value = "supergroup_chat_created")
  private Boolean superGroupChatCreated;

  @JsonProperty(value = "channel_chat_created")
  private Boolean channelChatCreated;

  @JsonProperty(value = "migrate_to_chat_id")
  private Long migrateToChatId;

  @JsonProperty(value = "migrate_from_chat_id")
  private Long migrateFromChatId;

  @JsonProperty(value = "pinned_message")
  private Message pinnedMessage;

  @JsonProperty(value = "invoice")
  private Invoice invoice;

  @JsonProperty(value = "successful_payment")
  private SuccessfulPayment succesfulPayment;

  @JsonProperty(value = "connected_webiste")
  private String connectedWebsite;
  // TODO PassportData
  // TODO InlineKeyboardMarkup

  private Message() {
    // Jackson
  }
}
