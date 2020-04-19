package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface PressureInfo {
  int getSeaLevelPressure();

  int getGroundLevelPressure();
}
