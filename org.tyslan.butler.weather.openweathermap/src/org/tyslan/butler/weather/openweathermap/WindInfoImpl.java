package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.WindInfo;

public class WindInfoImpl implements WindInfo {
  private double speed;
  private double direction;

  public WindInfoImpl(double speed, double direction) {
    this.speed = speed;
    this.direction = direction;
  }

  @Override
  public double getSpeed() {
    return speed;
  }

  @Override
  public double getDirection() {
    return direction;
  }

}
