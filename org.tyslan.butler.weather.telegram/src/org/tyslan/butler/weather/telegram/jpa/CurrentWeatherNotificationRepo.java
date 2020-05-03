package org.tyslan.butler.weather.telegram.jpa;

import java.util.List;
import org.tyslan.butler.weather.telegram.CurrentWeatherTelegramJob;

public interface CurrentWeatherNotificationRepo {
  void save(CurrentWeatherTelegramJob job);

  void delete(long id);

  List<CurrentWeatherTelegramJob> getAll();
}
