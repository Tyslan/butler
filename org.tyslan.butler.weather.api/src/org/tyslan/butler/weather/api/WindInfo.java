package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface WindInfo {
  double getSpeed();

  double getDirection();
}
