package org.tyslan.butler.weather.openweathermap;

import java.time.LocalDateTime;
import org.tyslan.butler.weather.api.Location;
import org.tyslan.butler.weather.api.PressureInfo;
import org.tyslan.butler.weather.api.TemperatureInfo;
import org.tyslan.butler.weather.api.WeatherCondition;
import org.tyslan.butler.weather.api.WeatherInfo;
import org.tyslan.butler.weather.api.WindInfo;

public class WeatherInfoImpl implements WeatherInfo {
  private Location location;
  private WeatherCondition weatherCondition;
  private TemperatureInfo temperatureInfo;
  private PressureInfo pressureInfo;
  private WindInfo windInfo;
  private int humidity;
  private int cloudiness;
  private LocalDateTime observationTime;

  public WeatherInfoImpl(Location location, WeatherCondition weatherCondition,
      TemperatureInfo temperatureInfo, PressureInfo pressureInfo, WindInfo windInfo, int humidity,
      int cloudiness, LocalDateTime observationTime) {
    this.location = location;
    this.weatherCondition = weatherCondition;
    this.temperatureInfo = temperatureInfo;
    this.pressureInfo = pressureInfo;
    this.windInfo = windInfo;
    this.humidity = humidity;
    this.cloudiness = cloudiness;
    this.observationTime = observationTime;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public WeatherCondition getWeatherCondition() {
    return weatherCondition;
  }

  @Override
  public TemperatureInfo getTemperatureInfo() {
    return temperatureInfo;
  }

  @Override
  public PressureInfo getPressureInfo() {
    return pressureInfo;
  }

  @Override
  public WindInfo getWindInfo() {
    return windInfo;
  }

  @Override
  public int getHumidity() {
    return humidity;
  }

  @Override
  public int getCloudiness() {
    return cloudiness;
  }

  @Override
  public LocalDateTime getObservationTime() {
    return observationTime;
  }

}
