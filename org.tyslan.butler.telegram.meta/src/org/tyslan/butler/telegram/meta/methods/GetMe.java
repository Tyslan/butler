package org.tyslan.butler.telegram.meta.methods;

import java.util.Collections;
import java.util.Map;
import org.tyslan.butler.rest.client.api.exceptions.ValidationException;
import org.tyslan.butler.telegram.meta.types.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetMe extends DefaultGetMethod<User> {
  private static final String PATH = "getMe";

  public GetMe() {
    super(User.class);
  }

  @Override
  @JsonIgnore
  public String getMethod() {
    return PATH;
  }

  @Override
  public void validate() throws ValidationException {
    // Do nothing
  }

  @Override
  @JsonIgnore
  public Map<String, String> getParameters() {
    return Collections.unmodifiableMap(Collections.emptyMap());
  }

  @Override
  public String toString() {
    return "GetMe";
  }
}
