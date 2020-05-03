package org.tyslan.butler.telegram.impl.receiver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.telegram.impl.Constants;
import org.tyslan.butler.telegram.impl.abs.UpdateReceiver;
import org.tyslan.butler.telegram.impl.abs.UpdateSupplier;
import org.tyslan.butler.telegram.impl.utils.BackOff;
import org.tyslan.butler.telegram.impl.utils.ExponentialBackOff;
import org.tyslan.butler.telegram.meta.types.Update;
import org.tyslan.butler.util.threads.CustomExecutors;

// https://github.com/rubenlagus/TelegramBots/blob/a7aec1e581efcf6fd10777eacbcf311807477f10/telegrambots/src/main/java/org/telegram/telegrambots/updatesreceivers/DefaultBotSession.java
public class LongPollingSession {
  private static final Logger logger = LoggerFactory.getLogger(LongPollingSession.class);

  private AtomicBoolean running = new AtomicBoolean(false);

  private final ConcurrentLinkedDeque<Update> receivedUpdates;

  private ExecutorService sessionExecutor;
  private ExecutorService updateHandlerExecutor;

  private UpdateReceiver updateReceiver;
  private UpdateSupplier updatesSupplier;
  private BackOff backoff;
  private long lastReceivedUpdate;

  public LongPollingSession(String token, UpdateReceiver updateReceiver) {
    running = new AtomicBoolean(false);
    receivedUpdates = new ConcurrentLinkedDeque<>();

    sessionExecutor = CustomExecutors.newFixedThreadPool(2, "telegram-long-polling");
    updateHandlerExecutor = CustomExecutors.newSingleThreadScheduledExecutor("telegram-update");
    this.updateReceiver = updateReceiver;
    updatesSupplier = new LongPollingUpdateSupplier(token);
    backoff = new ExponentialBackOff();
    lastReceivedUpdate = 0;
  }


  public synchronized void start() {
    if (running.get()) {
      throw new IllegalStateException("Cannot start already started receiver.");
    }
    running.set(true);
    lastReceivedUpdate = 0;
    receivedUpdates.clear();
    sessionExecutor.execute(createReader());
    logger.debug("Started update supplier.");
    sessionExecutor.execute(createUpdateHandler());
    logger.debug("Started update handler.");
  }

  public synchronized void stop() {
    if (!running.get()) {
      throw new IllegalStateException("Cannot stop already stopped receiver.");
    }
    running.set(false);

    CustomExecutors.shutdownAndAwaitTermination(sessionExecutor, Constants.GETUPDATES_TIMEOUT,
        TimeUnit.SECONDS);
    CustomExecutors.shutdownAndAwaitTermination(updateHandlerExecutor, 5, TimeUnit.SECONDS);
  }

  private Runnable createReader() {
    return () -> {
      while (running.get()) {
        poll();
      }
      logger.info("Reader thread is closed.");
    };
  }

  private void poll() {
    try {
      List<Update> updates = updatesSupplier.getUpdates(lastReceivedUpdate + 1);
      if (updates.isEmpty()) {
        Thread.sleep(500);
      } else {
        handleReceivedUpdates(updates);
      }
    } catch (InterruptedException e) {
      logger.error("Forcibly stopping reader thread.", e);
      Thread.currentThread().interrupt();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      try {
        Thread.sleep(backoff.nextBackOffMillis());
      } catch (InterruptedException e1) {
        logger.error(e.getMessage(), e);
        Thread.currentThread().interrupt();
      } catch (IOException e1) {
        logger.error(e.getMessage(), e);
      }
    }
  }

  private void handleReceivedUpdates(List<Update> updates) {
    updates.removeIf(x -> x.getId() < lastReceivedUpdate);
    lastReceivedUpdate =
        updates.parallelStream().map(Update::getId).max(Long::compareTo).orElse(0l);
    receivedUpdates.addAll(updates);
  }

  private Runnable createUpdateHandler() {
    return () -> {
      while (running.get()) {
        try {
          while (!receivedUpdates.isEmpty()) {
            Update update = receivedUpdates.poll();
            updateHandlerExecutor.execute(() -> {
              updateReceiver.onUpdateReceived(update);
              logger.debug("Processed update {}", update.getId());
            });
          }
        } catch (Exception e) {
          logger.error(e.getMessage(), e);
        }
      }
      logger.info("Update handler thread is closed.");
    };
  }
}
