package org.tyslan.butler.weather.telegram.jpa;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Telegram Weather Notification Config")
public @interface RepoConfig {
  @AttributeDefinition
  String getUrl();

  @AttributeDefinition
  String getUsername();

  @AttributeDefinition
  String getPassword();
}
