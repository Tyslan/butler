package org.tyslan.butler.telegram.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "OpenWeatherMap Service Config")
public @interface TelegramServiceConfig {
  @AttributeDefinition
  String getBotToken();
}
