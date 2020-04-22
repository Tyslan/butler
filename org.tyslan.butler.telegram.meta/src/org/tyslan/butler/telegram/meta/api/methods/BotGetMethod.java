package org.tyslan.butler.telegram.meta.api.methods;

import java.util.Map;
import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BotGetMethod<T extends ApiObject> implements BotMethod<T> {
  protected Gson gson;
  protected Class<T> methodResultType;

  protected BotGetMethod(Class<T> methodResultType) {
    gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    this.methodResultType = methodResultType;
  }

  @Override
  public MethodType getType() {
    return MethodType.GET;
  }

  @Override
  public T fromJson(String json) throws TelegramException {
    return gson.fromJson(json, methodResultType);
  }

  /**
   *
   * @return the parameters of the GetMetod as Immutable map
   */
  public abstract Map<String, String> getParameters();
}
