package org.tyslan.butler.telegram.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface TelegramService {
  void sendMessage(long chatId, String message);
}
