package org.tyslan.butler.telegram.meta.types;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Location implements ApiObject {
  @Expose
  @SerializedName(value = "longitude")
  private double longitude;
  @Expose
  @SerializedName(value = "latitude")
  private double latitude;

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(latitude);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(longitude);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
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
    Location other = (Location) obj;
    if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude)) {
      return false;
    }
    if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Location [longitude=" + longitude + ", latitude=" + latitude + "]";
  }
}
