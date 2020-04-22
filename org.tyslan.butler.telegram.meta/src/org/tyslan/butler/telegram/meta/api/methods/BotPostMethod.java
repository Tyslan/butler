package org.tyslan.butler.telegram.meta.api.methods;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.exceptions.TelegramException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BotPostMethod<T extends ApiObject> implements BotMethod<T> {
  protected Gson gson;
  protected Class<T> methodResultType;

  protected BotPostMethod(Class<T> methodResultType) {
    gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    this.methodResultType = methodResultType;
  }

  @Override
  public MethodType getType() {
    return MethodType.POST;
  }

  @Override
  public T fromJson(String json) throws TelegramException {
    return gson.fromJson(json, methodResultType);
  }

  public String toJson() {
    return gson.toJson(this);
  }
}
