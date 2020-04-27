package org.tyslan.butler.telegram.impl.abs;

import java.util.List;
import org.tyslan.butler.telegram.api.exceptions.TelegramException;
import org.tyslan.butler.telegram.meta.types.Update;

public interface UpdateSupplier {
  List<Update> getUpdates() throws TelegramException;

  List<Update> getUpdates(long offset) throws TelegramException;
}
