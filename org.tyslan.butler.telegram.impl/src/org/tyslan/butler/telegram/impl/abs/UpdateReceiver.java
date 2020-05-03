package org.tyslan.butler.telegram.impl.abs;

import org.tyslan.butler.telegram.api.bot.Bot;
import org.tyslan.butler.telegram.meta.types.Update;

public interface UpdateReceiver extends Bot {
  void onUpdateReceived(Update update);
}
