package org.tyslan.butler.telegram.meta.api.bot;

import java.util.List;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;
import org.tyslan.butler.telegram.meta.types.Update;

public interface UpdateSupplier {
  List<Update> getUpdates() throws TelegramException;

  List<Update> getUpdates(long offset) throws TelegramException;
}
