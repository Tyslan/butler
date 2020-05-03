package org.tyslan.butler.weather.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface WeatherService {
  WeatherInfo getCurrentWeather(String location) throws WeatherException;
}
