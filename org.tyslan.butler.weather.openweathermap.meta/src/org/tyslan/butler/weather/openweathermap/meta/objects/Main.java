package org.tyslan.butler.weather.openweathermap.meta.objects;

import org.tyslan.butler.rest.client.api.object.RestObject;
import com.fasterxml.jackson.annotation.JsonGetter;

@SuppressWarnings("serial")
public class Main implements RestObject {
  private double temp;
  private double windChill;
  private double tempMin;
  private double tempMax;
  private int pressure;
  private int humidity;
  private int seaLevelPressure;
  private int groundLevelPressure;

  private Main() {
    // Jackson
  }

  @JsonGetter("temp")
  public double getTemp() {
    return temp;
  }

  @JsonGetter("feels_like")
  public double getWindChill() {
    return windChill;
  }

  @JsonGetter("temp_min")
  public double getTempMin() {
    return tempMin;
  }

  @JsonGetter("temp_max")
  public double getTempMax() {
    return tempMax;
  }

  @JsonGetter("pressure")
  public int getPressure() {
    return pressure;
  }

  @JsonGetter("humidity")
  public int getHumidity() {
    return humidity;
  }

  @JsonGetter("sea_level")
  public Integer getSeaLevelPressure() {
    return seaLevelPressure;
  }

  @JsonGetter("grnd_level")
  public Integer getGroundLevelPressure() {
    return groundLevelPressure;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + groundLevelPressure;
    result = (prime * result) + humidity;
    result = (prime * result) + pressure;
    result = (prime * result) + seaLevelPressure;
    long temp;
    temp = Double.doubleToLongBits(this.temp);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(tempMax);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(tempMin);
    result = (prime * result) + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(windChill);
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
    Main other = (Main) obj;
    if (groundLevelPressure != other.groundLevelPressure) {
      return false;
    }
    if (humidity != other.humidity) {
      return false;
    }
    if (pressure != other.pressure) {
      return false;
    }
    if (seaLevelPressure != other.seaLevelPressure) {
      return false;
    }
    if (Double.doubleToLongBits(temp) != Double.doubleToLongBits(other.temp)) {
      return false;
    }
    if (Double.doubleToLongBits(tempMax) != Double.doubleToLongBits(other.tempMax)) {
      return false;
    }
    if (Double.doubleToLongBits(tempMin) != Double.doubleToLongBits(other.tempMin)) {
      return false;
    }
    if (Double.doubleToLongBits(windChill) != Double.doubleToLongBits(other.windChill)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Main [temp=" + temp + ", windChill=" + windChill + ", tempMin=" + tempMin + ", tempMax="
        + tempMax + ", pressure=" + pressure + ", humidity=" + humidity + ", seaLevelPressure="
        + seaLevelPressure + ", groundLevelPressure=" + groundLevelPressure + "]";
  }
}
