package org.tyslan.butler.telegram.meta.types.payments;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderInfo {
  @JsonProperty(value = "name")
  private String name;
  @JsonProperty(value = "phone_number")
  private String phoneNumber;
  @JsonProperty(value = "email")
  private String email;
  @JsonProperty(value = "shipping_address")
  private ShippingAddress shippingAddress;

  private OrderInfo() {
    // Jackson
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public ShippingAddress getShippingAddress() {
    return shippingAddress;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((email == null) ? 0 : email.hashCode());
    result = (prime * result) + ((name == null) ? 0 : name.hashCode());
    result = (prime * result) + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = (prime * result) + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
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
    OrderInfo other = (OrderInfo) obj;
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      return false;
    }
    if (shippingAddress == null) {
      if (other.shippingAddress != null) {
        return false;
      }
    } else if (!shippingAddress.equals(other.shippingAddress)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "OrderInfo [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
        + ", shippingAddress=" + shippingAddress + "]";
  }
}
