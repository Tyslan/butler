package org.tyslan.butler.weather.openweathermap;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "OpenWeatherMap Service Config")
public @interface WeatherServiceConfig {
  @AttributeDefinition
  String getApiKey();
}
