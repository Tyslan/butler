package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.Coordinates;
import org.tyslan.butler.weather.api.Location;

public class LocationImpl implements Location {

  private Coordinates coordinates;
  private String name;
  private long utcOffset;

  public LocationImpl(Coordinates coordinates, String name, long utcOffset) {
    this.coordinates = coordinates;
    this.name = name;
    this.utcOffset = utcOffset;
  }

  @Override
  public Coordinates getCoordinatates() {
    return coordinates;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public long getUtcOffset() {
    return utcOffset;
  }

}
