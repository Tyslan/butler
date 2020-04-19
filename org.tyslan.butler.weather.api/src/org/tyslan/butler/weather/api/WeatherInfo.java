package org.tyslan.butler.weather.api;

import java.time.LocalDateTime;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface WeatherInfo {
  Location getLocation();

  WeatherCondition getWeatherCondition();

  TemperatureInfo getTemperatureInfo();

  PressureInfo getPressureInfo();

  WindInfo getWindInfo();

  int getHumidity();

  int getCloudiness();

  LocalDateTime getObservationTime();
}
