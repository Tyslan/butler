package org.tyslan.butler.weather.openweathermap.meta.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {
  @JsonProperty("lon")
  double longitude;
  @JsonProperty("lat")
  double latitude;

  private Coordinates() {
    // Jackson;
  }

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
    Coordinates other = (Coordinates) obj;
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
    return "Coordinates [longitude=" + longitude + ", latitude=" + latitude + "]";
  }
}
