package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface WeatherCondition {
  int getCode();

  String getShortDescription();

  String getDescription();

  String getIcon();
}
