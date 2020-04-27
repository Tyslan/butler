package org.tyslan.butler.telegram.meta.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
  @JsonProperty(value = "@id")
  private long id;
  @JsonProperty(value = "is_bot")
  private boolean isBot;
  @JsonProperty(value = "first_name")
  private String firstName;
  @JsonProperty(value = "last_name")
  private String lastName;
  @JsonProperty(value = "username")
  private String username;
  @JsonProperty(value = "language_code")
  private String languageCode;
  @JsonProperty(value = "can_join_groups")
  private Boolean canJoinGroups;
  @JsonProperty(value = "can_read_all_group_messages")
  private Boolean canReadAllGroupMessages;
  @JsonProperty(value = "supports_inline_queries")
  private Boolean supportsInlineQueries;

  private User() {
    // Jackson
  }

  public long getId() {
    return id;
  }

  public boolean isBot() {
    return isBot;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  public String getLanguageCode() {
    return languageCode;
  }

  public Boolean getCanJoinGroups() {
    return canJoinGroups;
  }

  public Boolean getCanReadAllGroupMessages() {
    return canReadAllGroupMessages;
  }

  public Boolean getSupportsInlineQueries() {
    return supportsInlineQueries;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((canJoinGroups == null) ? 0 : canJoinGroups.hashCode());
    result = (prime * result)
        + ((canReadAllGroupMessages == null) ? 0 : canReadAllGroupMessages.hashCode());
    result = (prime * result) + ((firstName == null) ? 0 : firstName.hashCode());
    result = (prime * result) + (int) (id ^ (id >>> 32));
    result = (prime * result) + (isBot ? 1231 : 1237);
    result = (prime * result) + ((languageCode == null) ? 0 : languageCode.hashCode());
    result = (prime * result) + ((lastName == null) ? 0 : lastName.hashCode());
    result =
        (prime * result) + ((supportsInlineQueries == null) ? 0 : supportsInlineQueries.hashCode());
    result = (prime * result) + ((username == null) ? 0 : username.hashCode());
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
    User other = (User) obj;
    if (canJoinGroups == null) {
      if (other.canJoinGroups != null) {
        return false;
      }
    } else if (!canJoinGroups.equals(other.canJoinGroups)) {
      return false;
    }
    if (canReadAllGroupMessages == null) {
      if (other.canReadAllGroupMessages != null) {
        return false;
      }
    } else if (!canReadAllGroupMessages.equals(other.canReadAllGroupMessages)) {
      return false;
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (isBot != other.isBot) {
      return false;
    }
    if (languageCode == null) {
      if (other.languageCode != null) {
        return false;
      }
    } else if (!languageCode.equals(other.languageCode)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (supportsInlineQueries == null) {
      if (other.supportsInlineQueries != null) {
        return false;
      }
    } else if (!supportsInlineQueries.equals(other.supportsInlineQueries)) {
      return false;
    }
    if (username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!username.equals(other.username)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", isBot=" + isBot + ", firstName=" + firstName + ", lastName="
        + lastName + ", username=" + username + ", languageCode=" + languageCode
        + ", canJoinGroups=" + canJoinGroups + ", canReadAllGroupMessages="
        + canReadAllGroupMessages + ", supportsInlineQueries=" + supportsInlineQueries + "]";
  }

}
