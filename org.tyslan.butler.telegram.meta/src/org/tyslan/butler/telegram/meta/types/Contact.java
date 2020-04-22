package org.tyslan.butler.telegram.meta.types;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Contact implements ApiObject {
  @Expose
  @SerializedName(value = "phone_number")
  private String phoneNumber;
  @Expose
  @SerializedName(value = "first_name")
  private String firstName;
  @Expose
  @SerializedName(value = "last_name")
  private String lastName;
  @Expose
  @SerializedName(value = "user_id")
  private String userId;
  @Expose
  @SerializedName(value = "vcard")
  private String vCard;

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserId() {
    return userId;
  }

  public String getvCard() {
    return vCard;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((firstName == null) ? 0 : firstName.hashCode());
    result = (prime * result) + ((lastName == null) ? 0 : lastName.hashCode());
    result = (prime * result) + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = (prime * result) + ((userId == null) ? 0 : userId.hashCode());
    result = (prime * result) + ((vCard == null) ? 0 : vCard.hashCode());
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
    Contact other = (Contact) obj;
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }
    if (userId == null) {
      if (other.userId != null) {
        return false;
      }
    } else if (!userId.equals(other.userId)) {
      return false;
    }
    if (vCard == null) {
      if (other.vCard != null) {
        return false;
      }
    } else if (!vCard.equals(other.vCard)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Contact [phoneNumber=" + phoneNumber + ", firstName=" + firstName + ", lastName="
        + lastName + ", userId=" + userId + ", vCard=" + vCard + "]";
  }
}
