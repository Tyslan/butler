package org.tyslan.butler.telegram.meta.types.message;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message implements ApiObject {
  @Expose
  @SerializedName(value = "message_id")
  private long messageId;
  @Expose
  @SerializedName(value = "from")
  private User from;
  @Expose
  @SerializedName(value = "date")
  private long unixTimestamp;
  @Expose
  @SerializedName(value = "chat")
  private Chat chat;
  @Expose
  @SerializedName(value = "forward_from")
  private User forwardedFrom;
  @Expose
  @SerializedName(value = "forward_from_chat")
  private Chat forwardedFromChat;
  @Expose
  @SerializedName(value = "forward_from_message_id")
  private Long forwarderFromMessageId;
  @Expose
  @SerializedName(value = "forward_signature")
  private String forwardSignature;
  @Expose
  @SerializedName(value = "forward_sender_name")
  private String forwardSenderName;
  @Expose
  @SerializedName(value = "forward_date")
  private Long forwardUnixTimestamp;
  @Expose
  @SerializedName(value = "reply_to_message")
  private Message replyToMessage;
  @Expose
  @SerializedName(value = "edit_date")
  private Long editUnixTimestamp;
  @Expose
  @SerializedName(value = "media_group_id")
  private String mediaGroupType;
  @Expose
  @SerializedName(value = "author_signature")
  private String authorSignature;
  @Expose
  @SerializedName(value = "text")
  private String text;
  @Expose
  @SerializedName(value = "entities")
  private MessageEntity[] entities;
  @Expose
  @SerializedName(value = "caption_entities")
  private MessageEntity[] captionEntities;
  @Expose
  @SerializedName(value = "audio")
  private Audio audio;
  @Expose
  @SerializedName(value = "document")
  private Document document;
  @Expose
  @SerializedName(value = "animation")
  private Animation animation;
  // TODO Game
  @Expose
  @SerializedName(value = "photo")
  private PhoteSize[] photo;
  // TODO Sticker
  @Expose
  @SerializedName(value = "video")
  private Video video;
  @Expose
  @SerializedName(value = "voice")
  private Voice voice;
  @Expose
  @SerializedName(value = "video_note")
  private VideoNote videoNote;
  @Expose
  @SerializedName(value = "caption")
  private String caption;
  @Expose
  @SerializedName(value = "contact")
  private Contact contact;
  @Expose
  @SerializedName(value = "location")
  private Location location;
  @Expose
  @SerializedName(value = "venue")
  private Venue venue;
  @Expose
  @SerializedName(value = "poll")
  private Poll poll;
  @Expose
  @SerializedName(value = "dice")
  private Dice dice;
  @Expose
  @SerializedName(value = "new_chat_members")
  private User[] newChatMembers;
  @Expose
  @SerializedName(value = "left_chat_member")
  private User leftChatMember;
  @Expose
  @SerializedName(value = "new_chat_title")
  private String newChatTitle;
  @Expose
  @SerializedName("new_chat_photo")
  private PhoteSize[] newChatPhoto;
  @Expose
  @SerializedName("delete_chat_photo")
  private Boolean deleteChatPhoto;
  @Expose
  @SerializedName(value = "group_chat_created")
  private Boolean groupChatCreated;
  @Expose
  @SerializedName(value = "supergroup_chat_created")
  private Boolean superGroupChatCreated;
  @Expose
  @SerializedName(value = "channel_chat_created")
  private Boolean channelChatCreated;
  @Expose
  @SerializedName(value = "migrate_to_chat_id")
  private Long migrateToChatId;
  @Expose
  @SerializedName(value = "migrate_from_chat_id")
  private Long migrateFromChatId;
  @Expose
  @SerializedName(value = "pinned_message")
  private Message pinnedMessage;
  @Expose
  @SerializedName(value = "invoice")
  private Invoice invoice;
  @Expose
  @SerializedName(value = "successful_payment")
  private SuccessfulPayment succesfulPayment;
  @Expose
  @SerializedName(value = "connected_webiste")
  private String connectedWebsite;
  // TODO PassportData
  // TODO InlineKeyboardMarkup
}
