package org.tyslan.butler.weather.openweathermap.meta.objects;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentWeather {
  @JsonProperty("coord")
  private Coordinates coordinates;
  @JsonProperty("weather")
  private Weather[] weather;
  @JsonProperty("main")
  private Main main;
  @JsonProperty("wind")
  private Wind wind;
  @JsonProperty("clouds")
  private Clouds clouds;
  @JsonProperty("dt")
  private long unixTimestamp;
  @JsonProperty("sys")
  private Sys sys;
  @JsonProperty("timezone")
  private int unixTimeshift;
  @JsonProperty("id")
  private long cityId;
  @JsonProperty("name")
  private String cityName;

  private CurrentWeather() {
    // Jackson;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Weather[] getWeather() {
    return weather;
  }

  public Main getMain() {
    return main;
  }

  public Wind getWind() {
    return wind;
  }

  public Clouds getClouds() {
    return clouds;
  }

  public long getUnixTimestamp() {
    return unixTimestamp;
  }

  public Sys getSys() {
    return sys;
  }

  public int getUnixTimeshift() {
    return unixTimeshift;
  }

  public long getCityId() {
    return cityId;
  }

  public String getCityName() {
    return cityName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (int) (cityId ^ (cityId >>> 32));
    result = (prime * result) + ((cityName == null) ? 0 : cityName.hashCode());
    result = (prime * result) + ((clouds == null) ? 0 : clouds.hashCode());
    result = (prime * result) + ((coordinates == null) ? 0 : coordinates.hashCode());
    result = (prime * result) + ((main == null) ? 0 : main.hashCode());
    result = (prime * result) + ((sys == null) ? 0 : sys.hashCode());
    result = (prime * result) + unixTimeshift;
    result = (prime * result) + (int) (unixTimestamp ^ (unixTimestamp >>> 32));
    result = (prime * result) + Arrays.hashCode(weather);
    result = (prime * result) + ((wind == null) ? 0 : wind.hashCode());
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
    CurrentWeather other = (CurrentWeather) obj;
    if (cityId != other.cityId) {
      return false;
    }
    if (cityName == null) {
      if (other.cityName != null) {
        return false;
      }
    } else if (!cityName.equals(other.cityName)) {
      return false;
    }
    if (clouds == null) {
      if (other.clouds != null) {
        return false;
      }
    } else if (!clouds.equals(other.clouds)) {
      return false;
    }
    if (coordinates == null) {
      if (other.coordinates != null) {
        return false;
      }
    } else if (!coordinates.equals(other.coordinates)) {
      return false;
    }
    if (main == null) {
      if (other.main != null) {
        return false;
      }
    } else if (!main.equals(other.main)) {
      return false;
    }
    if (sys == null) {
      if (other.sys != null) {
        return false;
      }
    } else if (!sys.equals(other.sys)) {
      return false;
    }
    if (unixTimeshift != other.unixTimeshift) {
      return false;
    }
    if (unixTimestamp != other.unixTimestamp) {
      return false;
    }
    if (!Arrays.equals(weather, other.weather)) {
      return false;
    }
    if (wind == null) {
      if (other.wind != null) {
        return false;
      }
    } else if (!wind.equals(other.wind)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CurrentWeather [coordinates=" + coordinates + ", weather=" + Arrays.toString(weather)
        + ", main=" + main + ", wind=" + wind + ", clouds=" + clouds + ", unixTimestamp="
        + unixTimestamp + ", sys=" + sys + ", unixTimeshift=" + unixTimeshift + ", cityId=" + cityId
        + ", cityName=" + cityName + "]";
  }
}
