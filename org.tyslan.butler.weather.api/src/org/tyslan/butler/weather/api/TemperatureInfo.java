package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface TemperatureInfo {
  double getTemperature(TemperatureUnit unit);

  double getWindChill(TemperatureUnit unit);

  double getMaximum(TemperatureUnit unit);

  double getMinimum(TemperatureUnit unit);
}
