package org.tyslan.butler.weather.openweathermap;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.weather.api.Coordinates;
import org.tyslan.butler.weather.api.Location;
import org.tyslan.butler.weather.api.PressureInfo;
import org.tyslan.butler.weather.api.TemperatureInfo;
import org.tyslan.butler.weather.api.WeatherCondition;
import org.tyslan.butler.weather.api.WeatherInfo;
import org.tyslan.butler.weather.api.WeatherService;
import org.tyslan.butler.weather.api.WindInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

@Component(immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = WeatherServiceConfig.class)
public class WeatherServiceImpl implements WeatherService {
  private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

  private static final String END_POINT_URL = "api.openweathermap.org/data/2.5";
  private static final String DEFAULT_LANGUAGE = "nl";

  private CloseableHttpClient httpclient;
  private ResponseHandler<String> responseHandler;
  private String apiKey;

  @Activate
  public WeatherServiceImpl(WeatherServiceConfig config) {
    httpclient = HttpClients.createDefault();
    responseHandler = new BasicResponseHandler();
    apiKey = config.getApiKey();
  }

  @Deactivate
  protected void deactivate() {
    try {
      httpclient.close();
    } catch (IOException e) {
      logger.error("Something went wrong while closing the client.", e);
    }
  }

  @Override
  public WeatherInfo getCurrentWeather(String location) {
    return getCurrentWeather(location, DEFAULT_LANGUAGE);
  }

  @Override
  public WeatherInfo getCurrentWeather(String location, String languageCode) {
    logger.debug("Get current weather info for {}.", location);

    try {
      /* Make url */
      URI uri = new URIBuilder().setScheme("https").setHost(END_POINT_URL).setPath("/weather/")
          .setParameter("q", location.trim()).setParameter("appid", apiKey)
          .setParameter("lang", languageCode).build();

      String response = getJson(uri);
      logger.trace(response);
      logger.debug("Received response from weather service.");
      return parseToWeatherInfo(response);
    } catch (URISyntaxException e) {
      logger.error("Malformed URL", e);
      return null;
    } catch (ClientProtocolException e) {
      logger.error("Protocol Error", e);
      return null;
    } catch (IOException e) {
      logger.error("IO Exception", e);
      return null;
    } catch (Exception e) {
      logger.error("Unknown error", e);
      throw e;
    }
  }

  private WeatherInfo parseToWeatherInfo(String response) {
    JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();

    Location location = getLocationInfo(jsonObject);
    WeatherCondition weatherCondition = getWeatherCondition(jsonObject);
    TemperatureInfo temperatureInfo = getTemperatureInfo(jsonObject);
    PressureInfo pressureInfo = getPressureInfo(jsonObject);
    WindInfo windInfo = getWindInfo(jsonObject);
    int humidity = getHumidity(jsonObject);
    int cloudiness = getCloudiness(jsonObject);
    LocalDateTime observationTime = getObservationTime(jsonObject);

    return new WeatherInfoImpl(location, weatherCondition, temperatureInfo, pressureInfo, windInfo,
        humidity, cloudiness, observationTime);
  }

  private LocalDateTime getObservationTime(JsonObject jsonObject) {
    JsonPrimitive dt = jsonObject.getAsJsonPrimitive("dt");
    long ts = dt.getAsLong();
    Instant instant = Instant.ofEpochSecond(ts);
    ZoneId zone = ZoneId.from(ZoneOffset.UTC);
    return LocalDateTime.ofInstant(instant, zone);
  }

  private Location getLocationInfo(JsonObject jsonObject) {
    JsonObject jsonCoordinates = jsonObject.getAsJsonObject("coord");
    JsonPrimitive longitude = jsonCoordinates.getAsJsonPrimitive("lon");
    JsonPrimitive latitude = jsonCoordinates.getAsJsonPrimitive("lat");
    Coordinates coordinates = new CoordinatesImpl(latitude.getAsDouble(), longitude.getAsDouble());

    JsonPrimitive locationName = jsonObject.getAsJsonPrimitive("name");
    JsonPrimitive utcOffset = jsonObject.getAsJsonPrimitive("timezone");
    return new LocationImpl(coordinates, locationName.getAsString(), utcOffset.getAsLong());
  }

  private WeatherCondition getWeatherCondition(JsonObject jsonObject) {
    JsonObject weather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject();
    JsonPrimitive code = weather.getAsJsonPrimitive("id");
    JsonPrimitive shortDescription = weather.getAsJsonPrimitive("main");
    JsonPrimitive description = weather.getAsJsonPrimitive("description");
    JsonPrimitive icon = weather.getAsJsonPrimitive("icon");
    return new WeatherConditionImpl(code.getAsInt(), shortDescription.getAsString(),
        description.getAsString(), icon.getAsString());
  }

  private TemperatureInfo getTemperatureInfo(JsonObject jsonObject) {
    JsonObject mainInfo = jsonObject.getAsJsonObject("main");
    JsonPrimitive temperature = mainInfo.getAsJsonPrimitive("temp");
    JsonPrimitive windChill = mainInfo.getAsJsonPrimitive("feels_like");
    JsonPrimitive minimum = mainInfo.getAsJsonPrimitive("temp_min");
    JsonPrimitive maximum = mainInfo.getAsJsonPrimitive("temp_max");
    return new TemperatureInfoImpl(temperature.getAsDouble(), windChill.getAsDouble(),
        minimum.getAsDouble(), maximum.getAsDouble());
  }

  private PressureInfo getPressureInfo(JsonObject jsonObject) {
    JsonObject mainInfo = jsonObject.getAsJsonObject("main");
    JsonPrimitive seaLevel = mainInfo.getAsJsonPrimitive("sea_level");
    if (seaLevel == null) {
      seaLevel = mainInfo.getAsJsonPrimitive("pressure");
      return new PressureInfoImpl(seaLevel.getAsInt(), -1);
    } else {
      JsonPrimitive groundLevel = mainInfo.getAsJsonPrimitive("grnd_level");
      return new PressureInfoImpl(seaLevel.getAsInt(), groundLevel.getAsInt());
    }
  }

  private WindInfo getWindInfo(JsonObject jsonObject) {
    JsonObject wind = jsonObject.getAsJsonObject("wind");
    JsonPrimitive speed = wind.getAsJsonPrimitive("speed");
    JsonPrimitive direction = wind.getAsJsonPrimitive("deg");
    return new WindInfoImpl(speed.getAsDouble(), direction.getAsDouble());
  }

  private int getHumidity(JsonObject jsonObject) {
    JsonObject mainInfo = jsonObject.getAsJsonObject("main");
    JsonPrimitive humidity = mainInfo.getAsJsonPrimitive("humidity");
    return humidity.getAsInt();
  }

  private int getCloudiness(JsonObject jsonObject) {
    JsonObject clouds = jsonObject.getAsJsonObject("clouds");
    return clouds.getAsJsonPrimitive("all").getAsInt();
  }

  private String getJson(URI uri) throws IOException {
    /* Prepare GET */
    HttpGet httpget = new HttpGet(uri);
    httpget.addHeader("Content-Type", "application/json");
    logger.trace("Calling: {}", httpget.getURI());

    /* Get response */
    CloseableHttpResponse response = httpclient.execute(httpget);
    return responseHandler.handleResponse(response);
  }
}
