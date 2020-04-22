package org.tyslan.butler.telegram.api;

import org.tyslan.butler.telegram.meta.methods.SendMessage;

public interface Sender {
  void sendMessage(SendMessage sendMessage);
}
