package org.tyslan.butler.weather.openweathermap.meta.objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Sys {
  @JsonProperty("country")
  private String countryCode;
  @JsonProperty("sunrise")
  private long sunriseUnixTimestamp;
  @JsonProperty("sunset")
  private long sunsetUnixTimestamp;

  private Sys() {
    // Jackson;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public long getSunriseUnixTimestamp() {
    return sunriseUnixTimestamp;
  }

  public long getSunsetUnixTimestamp() {
    return sunsetUnixTimestamp;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((countryCode == null) ? 0 : countryCode.hashCode());
    result = (prime * result) + (int) (sunriseUnixTimestamp ^ (sunriseUnixTimestamp >>> 32));
    result = (prime * result) + (int) (sunsetUnixTimestamp ^ (sunsetUnixTimestamp >>> 32));
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
    Sys other = (Sys) obj;
    if (countryCode == null) {
      if (other.countryCode != null) {
        return false;
      }
    } else if (!countryCode.equals(other.countryCode)) {
      return false;
    }
    if (sunriseUnixTimestamp != other.sunriseUnixTimestamp) {
      return false;
    }
    if (sunsetUnixTimestamp != other.sunsetUnixTimestamp) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Sys [countryCode=" + countryCode + ", sunriseUnixTimestamp=" + sunriseUnixTimestamp
        + ", sunsetUnixTimestamp=" + sunsetUnixTimestamp + "]";
  }
}

