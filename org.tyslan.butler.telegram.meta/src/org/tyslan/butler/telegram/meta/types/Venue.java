package org.tyslan.butler.telegram.meta.types;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Venue implements ApiObject {
  @Expose
  @SerializedName(value = "location")
  private Location location;
  @Expose
  @SerializedName(value = "title")
  private String title;
  @Expose
  @SerializedName(value = "address")
  private String address;
  @Expose
  @SerializedName("foursquare_id")
  private String foursquareId;
  @Expose
  @SerializedName(value = "foursquare_type")
  private String foursquareType;

  public Location getLocation() {
    return location;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getFoursquareId() {
    return foursquareId;
  }

  public String getFoursquareType() {
    return foursquareType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((address == null) ? 0 : address.hashCode());
    result = (prime * result) + ((foursquareId == null) ? 0 : foursquareId.hashCode());
    result = (prime * result) + ((foursquareType == null) ? 0 : foursquareType.hashCode());
    result = (prime * result) + ((location == null) ? 0 : location.hashCode());
    result = (prime * result) + ((title == null) ? 0 : title.hashCode());
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
    Venue other = (Venue) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (foursquareId == null) {
      if (other.foursquareId != null) {
        return false;
      }
    } else if (!foursquareId.equals(other.foursquareId)) {
      return false;
    }
    if (foursquareType == null) {
      if (other.foursquareType != null) {
        return false;
      }
    } else if (!foursquareType.equals(other.foursquareType)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Venue [location=" + location + ", title=" + title + ", address=" + address
        + ", foursquareId=" + foursquareId + ", foursquareType=" + foursquareType + "]";
  }
}
