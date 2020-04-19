package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Coordinates {
  double getLatitude();

  double getLongitude();
}
