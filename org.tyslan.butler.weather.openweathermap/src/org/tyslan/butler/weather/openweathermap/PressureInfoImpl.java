package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.PressureInfo;

public class PressureInfoImpl implements PressureInfo {
  private int seaLevel;
  private int groundLevel;

  public PressureInfoImpl(int seaLevel, int groundLevel) {
    this.seaLevel = seaLevel;
    this.groundLevel = groundLevel;
  }

  @Override
  public int getSeaLevelPressure() {
    return seaLevel;
  }

  @Override
  public int getGroundLevelPressure() {
    return groundLevel;
  }

}
