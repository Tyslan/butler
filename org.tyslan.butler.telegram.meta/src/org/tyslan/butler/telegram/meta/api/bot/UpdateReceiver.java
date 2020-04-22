package org.tyslan.butler.telegram.meta.api.bot;

import org.tyslan.butler.telegram.meta.types.Update;

public interface UpdateReceiver extends Bot {
  void onUpdateReceived(Update update);
}
