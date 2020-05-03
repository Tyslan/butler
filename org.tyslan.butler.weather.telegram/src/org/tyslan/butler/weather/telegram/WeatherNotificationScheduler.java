package org.tyslan.butler.weather.telegram;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.rest.client.api.exceptions.RestCallException;
import org.tyslan.butler.telegram.api.TelegramService;
import org.tyslan.butler.telegram.api.exceptions.TelegramCallException;
import org.tyslan.butler.telegram.api.exceptions.TelegramException;
import org.tyslan.butler.telegram.meta.methods.SendMessage;
import org.tyslan.butler.telegram.meta.types.message.ParseMode;
import org.tyslan.butler.weather.api.TemperatureUnit;
import org.tyslan.butler.weather.api.WeatherException;
import org.tyslan.butler.weather.api.WeatherInfo;
import org.tyslan.butler.weather.api.WeatherService;
import org.tyslan.butler.weather.telegram.jpa.CurrentWeatherNotificationRepo;

@Component(service = WeatherNotificationScheduler.class)
public class WeatherNotificationScheduler {
  private static final Logger logger = LoggerFactory.getLogger(WeatherNotificationScheduler.class);

  private static final String CURRENT_WEATHER_PREFIX = "current.weather";

  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private WeatherService weatherService;
  private TelegramService telegram;
  private Scheduler scheduler;
  private CurrentWeatherNotificationRepo mapper;

  @Activate
  public WeatherNotificationScheduler(@Reference WeatherService weatherService,
      @Reference TelegramService telegram, @Reference Scheduler scheduler,
      @Reference CurrentWeatherNotificationRepo mapper) {
    this.weatherService = weatherService;
    this.telegram = telegram;
    this.scheduler = scheduler;
    this.mapper = mapper;
    List<CurrentWeatherTelegramJob> list = mapper.getAll();
    for (CurrentWeatherTelegramJob job : list) {
      scheduleCurrentWeatherJob(job);
    }
  }


  public void scheduleCurrentWeather(String jobName, String expression, long telegramChatId,
      String location) {
    CurrentWeatherTelegramJob job =
        new CurrentWeatherTelegramJob(jobName, expression, location, telegramChatId);
    mapper.save(job);
    scheduleCurrentWeatherJob(job);
    logger.debug("Scheduled job {} with expression {} for {} for chat {}", jobName, expression,
        location, telegramChatId);
  }

  private void scheduleCurrentWeatherJob(CurrentWeatherTelegramJob telegramJob) {
    ScheduleOptions options =
        getScheduleOptions(telegramJob.getJobName(), telegramJob.getExpression());
    Runnable job = getCurrentWeatherJob(telegramJob.getChatId(), telegramJob.getLocation());
    schedule(options, job);
  }

  private ScheduleOptions getScheduleOptions(String jobName, String expression) {
    ScheduleOptions options = scheduler.EXPR(expression);
    options.name(String.join(".", CURRENT_WEATHER_PREFIX, jobName));
    return options;
  }

  private Runnable getCurrentWeatherJob(long telegramChatId, String location) {
    return () -> {
      try {
        WeatherInfo info = weatherService.getCurrentWeather(location);
        String message = buildWeatherMessage(info);
        sendTelegramMessage(telegramChatId, message);
      } catch (WeatherException e) {
        logger.error("Error during getting current weather: {}", e.getMessage(), e);
      } catch (TelegramException | RestCallException e) {
        logger.error("Error during sending current weather: {}", e.getMessage(), e);
      }
    };
  }

  private String buildWeatherMessage(WeatherInfo info) {
    String location = info.getLocation().getName();
    String temp =
        String.format("%.2f", info.getTemperatureInfo().getTemperature(TemperatureUnit.CELSIUS));
    String descr = capitalize(info.getWeatherCondition().getDescription());
    LocalDateTime local =
        info.getObservationTime().plus(info.getLocation().getUtcOffset(), ChronoUnit.SECONDS);
    String time = local.format(formatter);

    StringBuilder b = new StringBuilder();
    b.append("*").append(location).append("*").append("\n");
    b.append("_").append(time).append("_").append("\n");
    b.append("   ").append(temp).append("°C").append("\n");
    b.append("   ").append(descr);
    return b.toString();
  }

  private String capitalize(String input) {
    if ((input == null) || input.isEmpty()) {
      return "";
    }
    if (input.length() == 1) {
      return input.toUpperCase();
    }
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }

  private void sendTelegramMessage(long chatId, String message)
      throws TelegramCallException, RestCallException {
    SendMessage sendMessage = new SendMessage(chatId, message);
    sendMessage.setParseMode(ParseMode.MARKDOWN);
    sendMessage.setDisableNotification(true);
    telegram.execute(sendMessage);
  }

  private void schedule(ScheduleOptions options, Runnable runnable) {
    scheduler.schedule(runnable, options);
  }

  public List<CurrentWeatherTelegramJob> getAllCurrentWeatherJobs() {
    return mapper.getAll();
  }


  public void deleteCurrentWeatherJob(long id) {
    mapper.delete(id);
  }
}
