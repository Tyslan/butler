package org.tyslan.butler.weather.openweathermap.meta.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds {
  @JsonProperty("all")
  private int cloudiness;

  private Clouds() {
    // Jackson
  }

  public int getCloudiness() {
    return cloudiness;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + cloudiness;
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
    Clouds other = (Clouds) obj;
    if (cloudiness != other.cloudiness) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Clouds [cloudiness=" + cloudiness + "]";
  }
}