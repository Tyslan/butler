package org.tyslan.butler.weather.openweathermap.meta.methods;

import java.util.HashMap;
import java.util.Map;
import org.tyslan.butler.rest.client.api.exceptions.ValidationException;
import org.tyslan.butler.weather.openweathermap.meta.Constants;
import org.tyslan.butler.weather.openweathermap.meta.objects.CurrentWeather;


public class GetCurrentWeatherByName extends DefaultGetMethod<CurrentWeather> {
  private static final String PATH = "weather";

  private String city;
  private String state;
  private String country;
  private String apiKey;
  private String language;

  public GetCurrentWeatherByName(String city, String apiKey) {
    super(CurrentWeather.class);
    this.city = city;
    this.apiKey = apiKey;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  @Override
  public Map<String, String> getParameters() {
    Map<String, String> parameters = new HashMap<>();
    parameters.put(Constants.API_KEY_PARAMETER, apiKey);
    StringBuilder b = new StringBuilder(city);
    if (state != null) {
      b.append(",").append(state);
    }
    if (country != null) {
      b.append(",").append(country);
    }
    parameters.put(Constants.CITY_KEY_PARAMETER, b.toString());
    if (language != null) {
      parameters.put(Constants.LANGUAGE_PARAMETER, language);
    }
    return parameters;
  }

  @Override
  public String getMethod() {
    return PATH;
  }

  @Override
  public void validate() throws ValidationException {
    if ((country != null) && (state == null)) {
      throw new ValidationException("State needs to be filled in when providing a country.");
    }
    // TODO check language;
  }
}
