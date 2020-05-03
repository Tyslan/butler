package org.tyslan.butler.weather.openweathermap.meta.objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Main {
  @JsonProperty("temp")
  private double temp;
  @JsonProperty("feels_like")
  private double windChill;
  @JsonProperty("temp_min")
  private double tempMin;
  @JsonProperty("temp_max")
  private double tempMax;
  @JsonProperty("pressure")
  private int pressure;
  @JsonProperty("humidity")
  private int humidity;
  @JsonProperty("sea_level")
  private int seaLevelPressure;
  @JsonProperty("grnd_level")
  private int groundLevelPressure;

  private Main() {
    // Jackson
  }


  public double getTemp() {
    return temp;
  }

  public double getWindChill() {
    return windChill;
  }

  public double getTempMin() {
    return tempMin;
  }

  public double getTempMax() {
    return tempMax;
  }

  public int getPressure() {
    return pressure;
  }

  public int getHumidity() {
    return humidity;
  }

  public Integer getSeaLevelPressure() {
    return seaLevelPressure;
  }

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
