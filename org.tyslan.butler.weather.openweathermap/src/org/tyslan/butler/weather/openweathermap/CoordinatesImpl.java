package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.Coordinates;

public class CoordinatesImpl implements Coordinates {
  private double latitude;
  private double longitude;

  public CoordinatesImpl(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  @Override
  public double getLatitude() {
    return latitude;
  }

  @Override
  public double getLongitude() {
    return longitude;
  }

}
