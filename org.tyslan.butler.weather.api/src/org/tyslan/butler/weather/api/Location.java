package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Location {
  Coordinates getCoordinatates();

  String getName();

  long getUtcOffset();
}
