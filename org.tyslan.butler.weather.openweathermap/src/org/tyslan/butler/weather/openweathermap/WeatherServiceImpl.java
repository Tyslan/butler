package org.tyslan.butler.weather.openweathermap;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.rest.client.impl.DefaultMethodExecutor;
import org.tyslan.butler.weather.api.Coordinates;
import org.tyslan.butler.weather.api.Location;
import org.tyslan.butler.weather.api.PressureInfo;
import org.tyslan.butler.weather.api.TemperatureInfo;
import org.tyslan.butler.weather.api.WeatherCondition;
import org.tyslan.butler.weather.api.WeatherException;
import org.tyslan.butler.weather.api.WeatherInfo;
import org.tyslan.butler.weather.api.WeatherService;
import org.tyslan.butler.weather.api.WindInfo;
import org.tyslan.butler.weather.openweathermap.meta.methods.GetCurrentWeatherByName;
import org.tyslan.butler.weather.openweathermap.meta.objects.CurrentWeather;

@Component(immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = WeatherServiceConfig.class)
public class WeatherServiceImpl implements WeatherService {
  private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

  private static final String END_POINT_URL = "api.openweathermap.org/data/2.5";
  private static final String DEFAULT_LANGUAGE = "nl";

  private DefaultMethodExecutor methodExecutor = new DefaultMethodExecutor(END_POINT_URL);

  private String apiKey;
  private String languageCode;

  @Activate
  public WeatherServiceImpl(WeatherServiceConfig config) {
    apiKey = config.getApiKey();
    languageCode = config.getLanguage();
  }

  @Deactivate
  protected void deactivate() {
    methodExecutor.close();
  }

  @Override
  public WeatherInfo getCurrentWeather(String location) throws WeatherException {
    GetCurrentWeatherByName method = new GetCurrentWeatherByName(location, apiKey);
    if (languageCode != null) {
      method.setLanguage(languageCode);
    } else {
      method.setLanguage(DEFAULT_LANGUAGE);
    }
    try {
      CurrentWeather weather = methodExecutor.execute(method);
      logger.debug("{}", weather);
      return parseCurrentWeatherToWeatherInfo(weather);
    } catch (RestCallException e) {
      logger.error(e.getMessage(), e);
      throw new WeatherException(e.getMessage());
    }
  }


  private WeatherInfo parseCurrentWeatherToWeatherInfo(CurrentWeather weather) {
    Location location = getLocationInfo(weather);
    WeatherCondition weatherCondition = getWeatherCondition(weather);

    TemperatureInfo temperatureInfo = getTemperatureInfo(weather);
    PressureInfo pressureInfo = getPressureInfo(weather);
    WindInfo windInfo = getWindInfo(weather);
    int humidity = getHumidity(weather);
    int cloudiness = getCloudiness(weather);
    LocalDateTime observationTime = getObservationTime(weather);
    return new WeatherInfoImpl(location, weatherCondition, temperatureInfo, pressureInfo, windInfo,
        humidity, cloudiness, observationTime);
  }



  private Location getLocationInfo(CurrentWeather weather) {
    Coordinates coordinates = new CoordinatesImpl(weather.getCoordinates().getLatitude(),
        weather.getCoordinates().getLongitude());
    return new LocationImpl(coordinates, weather.getCityName(), weather.getUnixTimeshift());
  }

  private WeatherCondition getWeatherCondition(CurrentWeather weather) {
    return new WeatherConditionImpl(weather.getWeather()[0].getId(),
        weather.getWeather()[0].getMain(), weather.getWeather()[0].getDescription(),
        weather.getWeather()[0].getWeatherIconId());
  }

  private TemperatureInfo getTemperatureInfo(CurrentWeather weather) {
    return new TemperatureInfoImpl(weather.getMain().getTemp(), weather.getMain().getWindChill(),
        weather.getMain().getTempMin(), weather.getMain().getTempMax());
  }

  private PressureInfo getPressureInfo(CurrentWeather weather) {
    if (weather.getMain().getSeaLevelPressure() == null) {
      return new PressureInfoImpl(weather.getMain().getPressure(), -1);
    } else {
      return new PressureInfoImpl(weather.getMain().getSeaLevelPressure(),
          weather.getMain().getGroundLevelPressure());
    }
  }

  private WindInfo getWindInfo(CurrentWeather weather) {
    return new WindInfoImpl(weather.getWind().getSpeed(), weather.getWind().getDegree());
  }

  private int getHumidity(CurrentWeather weather) {
    return weather.getMain().getHumidity();
  }

  private int getCloudiness(CurrentWeather weather) {
    return weather.getClouds().getCloudiness();
  }

  private LocalDateTime getObservationTime(CurrentWeather weather) {
    long ts = weather.getUnixTimestamp();
    Instant instant = Instant.ofEpochSecond(ts);
    ZoneId zone = ZoneId.from(ZoneOffset.UTC);
    return LocalDateTime.ofInstant(instant, zone);
  }
}
