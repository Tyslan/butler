package org.tyslan.butler.weather.openweathermap.meta.objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Weather {
  @JsonProperty("id")
  private long id;
  @JsonProperty("main")
  private String main;
  @JsonProperty("description")
  private String description;
  @JsonProperty("icon")
  private String weatherIconId;

  private Weather() {
    // Jackson
  }

  /**
   *
   * @return Weather condition id;
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @return Group of weather parameters
   */
  public String getMain() {
    return main;
  }

  public String getDescription() {
    return description;
  }

  public String getWeatherIconId() {
    return weatherIconId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((description == null) ? 0 : description.hashCode());
    result = (prime * result) + (int) (id ^ (id >>> 32));
    result = (prime * result) + ((main == null) ? 0 : main.hashCode());
    result = (prime * result) + ((weatherIconId == null) ? 0 : weatherIconId.hashCode());
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
    Weather other = (Weather) obj;
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    if (id != other.id) {
      return false;
    }
    if (main == null) {
      if (other.main != null) {
        return false;
      }
    } else if (!main.equals(other.main)) {
      return false;
    }
    if (weatherIconId == null) {
      if (other.weatherIconId != null) {
        return false;
      }
    } else if (!weatherIconId.equals(other.weatherIconId)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Weather [id=" + id + ", main=" + main + ", description=" + description
        + ", weatherIconId=" + weatherIconId + "]";
  }
}
