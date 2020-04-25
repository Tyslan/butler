package org.tyslan.butler.weather.openweathermap.meta.objects;

import org.tyslan.butler.rest.client.api.object.RestObject;
import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public class Wind implements RestObject {
  @JsonProperty("speed")
  private double speed;
  @JsonProperty("deg")
  private int degree;

  private Wind() {
    // Jackson
  }


  public double getSpeed() {
    return speed;
  }


  public int getDegree() {
    return degree;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + degree;
    long temp;
    temp = Double.doubleToLongBits(speed);
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
    Wind other = (Wind) obj;
    if (degree != other.degree) {
      return false;
    }
    if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Wind [speed=" + speed + ", degree=" + degree + "]";
  }
}
