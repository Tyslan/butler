package org.tyslan.butler.weather.telegram.jpa;

import java.util.List;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.tyslan.butler.weather.telegram.Constants;
import org.tyslan.butler.weather.telegram.CurrentWeatherTelegramJob;
import org.tyslan.butler.weather.telegram.WeatherNotificationScheduler;

@Component(immediate = true, //
    property = {//
        Constants.SCOPE + "=weather", //
        Constants.FUNCTIONS + "=scheduleCurrentWeather", //
        Constants.FUNCTIONS + "=listCurrentWeatherJobs", //
        Constants.FUNCTIONS + "=deleteCurrentWeatherJob"//
    }, //
    service = TelegramWeatherServiceCommander.class)
public class TelegramWeatherServiceCommander {
  @Reference
  WeatherNotificationScheduler scheduler;

  public void scheduleCurrentWeather(String jobName, String expression, long telegramChatId,
      String location) {
    scheduler.scheduleCurrentWeather(jobName, expression, telegramChatId, location);
  }

  public void listCurrentWeatherJobs() {
    List<CurrentWeatherTelegramJob> jobs = scheduler.getAllCurrentWeatherJobs();
    StringBuilder b = new StringBuilder();
    for (CurrentWeatherTelegramJob job : jobs) {
      b.append(job).append("\n");
    }
    System.out.println(b.toString());
  }

  public void deleteCurrentWeatherJob(long id) {
    scheduler.deleteCurrentWeatherJob(id);
  }
}
