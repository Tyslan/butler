package org.tyslan.butler.telegram.meta.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dice {
  @JsonProperty(value = "value")
  private String value;

  public String getValue() {
    return value;
  }

  private Dice() {
    // Jackson
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Dice other = (Dice) obj;
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Dice [value=" + value + "]";
  }
}
