package org.tyslan.butler.weather.openweathermap;

import org.tyslan.butler.weather.api.TemperatureInfo;
import org.tyslan.butler.weather.api.TemperatureUnit;

public class TemperatureInfoImpl implements TemperatureInfo {
  private double temperature;
  private double windChill;
  private double minimum;
  private double maximum;

  public TemperatureInfoImpl(double temperature, double windChill, double minimum, double maximum) {
    this.temperature = temperature;
    this.windChill = windChill;
    this.minimum = minimum;
    this.maximum = maximum;
  }

  @Override
  public double getTemperature(TemperatureUnit unit) {
    switch (unit) {
      case KELVIN:
        return temperature;
      case CELSIUS:
        return toCelcius(temperature);
      case FAHRENHEIT:
        return toFahrenheit(temperature);
      default:
        throw new IllegalArgumentException(unit.toString() + "is unknown unit");
    }
  }

  @Override
  public double getWindChill(TemperatureUnit unit) {
    switch (unit) {
      case KELVIN:
        return windChill;
      case CELSIUS:
        return toCelcius(windChill);
      case FAHRENHEIT:
        return toFahrenheit(windChill);
      default:
        throw new IllegalArgumentException(unit.toString() + "is unknown unit");
    }
  }

  @Override
  public double getMaximum(TemperatureUnit unit) {
    switch (unit) {
      case KELVIN:
        return maximum;
      case CELSIUS:
        return toCelcius(maximum);
      case FAHRENHEIT:
        return toFahrenheit(maximum);
      default:
        throw new IllegalArgumentException(unit.toString() + "is unknown unit");
    }
  }

  @Override
  public double getMinimum(TemperatureUnit unit) {
    switch (unit) {
      case KELVIN:
        return minimum;
      case CELSIUS:
        return toCelcius(minimum);
      case FAHRENHEIT:
        return toFahrenheit(minimum);
      default:
        throw new IllegalArgumentException(unit.toString() + "is unknown unit");
    }
  }

  private double toCelcius(double kelvin) {
    return kelvin - 273.15;
  }

  private double toFahrenheit(double kelvin) {
    return ((toCelcius(kelvin) * 9) / 5) + 32;
  }

}
