package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.WeatherCondition;

public class WeatherConditionImpl implements WeatherCondition {
  private int code;
  private String shortDescription;
  private String description;
  private String icon;

  public WeatherConditionImpl(int code, String shortDescription, String description, String icon) {
    super();
    this.code = code;
    this.shortDescription = shortDescription;
    this.description = description;
    this.icon = icon;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getShortDescription() {
    return shortDescription;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getIcon() {
    return icon;
  }

}
