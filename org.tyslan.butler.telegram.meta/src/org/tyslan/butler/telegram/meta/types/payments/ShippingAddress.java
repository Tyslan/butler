package org.tyslan.butler.telegram.meta.types.payments;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class ShippingAddress implements ApiObject {
  @Expose
  @SerializedName(value = "shipping_address")
  private String countryCode;
  @Expose
  @SerializedName(value = "state")
  private String state;
  @Expose
  @SerializedName(value = "city")
  private String city;
  @Expose
  @SerializedName(value = "street_line1")
  private String streetLine1;
  @Expose
  @SerializedName(value = "street_line2")
  private String streetLine2;
  @Expose
  @SerializedName(value = "post_code")
  private String postCode;

  public String getCountryCode() {
    return countryCode;
  }

  public String getState() {
    return state;
  }

  public String getCity() {
    return city;
  }

  public String getStreetLine1() {
    return streetLine1;
  }

  public String getStreetLine2() {
    return streetLine2;
  }

  public String getPostCode() {
    return postCode;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((city == null) ? 0 : city.hashCode());
    result = (prime * result) + ((countryCode == null) ? 0 : countryCode.hashCode());
    result = (prime * result) + ((postCode == null) ? 0 : postCode.hashCode());
    result = (prime * result) + ((state == null) ? 0 : state.hashCode());
    result = (prime * result) + ((streetLine1 == null) ? 0 : streetLine1.hashCode());
    result = (prime * result) + ((streetLine2 == null) ? 0 : streetLine2.hashCode());
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
    ShippingAddress other = (ShippingAddress) obj;
    if (city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!city.equals(other.city)) {
      return false;
    }
    if (countryCode == null) {
      if (other.countryCode != null) {
        return false;
      }
    } else if (!countryCode.equals(other.countryCode)) {
      return false;
    }
    if (postCode == null) {
      if (other.postCode != null) {
        return false;
      }
    } else if (!postCode.equals(other.postCode)) {
      return false;
    }
    if (state == null) {
      if (other.state != null) {
        return false;
      }
    } else if (!state.equals(other.state)) {
      return false;
    }
    if (streetLine1 == null) {
      if (other.streetLine1 != null) {
        return false;
      }
    } else if (!streetLine1.equals(other.streetLine1)) {
      return false;
    }
    if (streetLine2 == null) {
      if (other.streetLine2 != null) {
        return false;
      }
    } else if (!streetLine2.equals(other.streetLine2)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ShippingAddress [countryCode=" + countryCode + ", state=" + state + ", city=" + city
        + ", streetLine1=" + streetLine1 + ", streetLine2=" + streetLine2 + ", postCode=" + postCode
        + "]";
  }
}
