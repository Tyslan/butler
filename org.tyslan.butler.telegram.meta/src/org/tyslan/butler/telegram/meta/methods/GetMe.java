package org.tyslan.butler.telegram.meta.methods;

import java.util.Collections;
import java.util.Map;
import org.tyslan.butler.telegram.meta.api.methods.BotGetMethod;
import org.tyslan.butler.telegram.meta.exceptions.TelegramValidationExeception;
import org.tyslan.butler.telegram.meta.types.User;

public class GetMe extends BotGetMethod<User> {
  private static final String PATH = "getMe";

  public GetMe() {
    super(User.class);
  }

  @Override
  public String getMethod() {
    return PATH;
  }

  @Override
  public void validate() throws TelegramValidationExeception {
    // Do nothing
  }

  @Override
  public Map<String, String> getParameters() {
    return Collections.unmodifiableMap(Collections.emptyMap());
  }

  @Override
  public String toString() {
    return "GetMe";
  }
}
