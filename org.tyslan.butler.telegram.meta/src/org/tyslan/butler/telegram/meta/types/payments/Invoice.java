package org.tyslan.butler.telegram.meta.types.payments;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class Invoice implements ApiObject {
  @Expose
  @SerializedName(value = "title")
  private String title;
  @Expose
  @SerializedName(value = "description")
  private String description;
  @Expose
  @SerializedName(value = "start_parameter")
  private String startParameter;
  @Expose
  @SerializedName(value = "currency")
  private String currency;
  @Expose
  @SerializedName(value = "total_amount")
  private int totalAmount;

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getStartParameter() {
    return startParameter;
  }

  public String getCurrency() {
    return currency;
  }

  public int getTotalAmount() {
    return totalAmount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((currency == null) ? 0 : currency.hashCode());
    result = (prime * result) + ((description == null) ? 0 : description.hashCode());
    result = (prime * result) + ((startParameter == null) ? 0 : startParameter.hashCode());
    result = (prime * result) + ((title == null) ? 0 : title.hashCode());
    result = (prime * result) + totalAmount;
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
    Invoice other = (Invoice) obj;
    if (currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!currency.equals(other.currency)) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!description.equals(other.description)) {
      return false;
    }
    if (startParameter == null) {
      if (other.startParameter != null) {
        return false;
      }
    } else if (!startParameter.equals(other.startParameter)) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!title.equals(other.title)) {
      return false;
    }
    if (totalAmount != other.totalAmount) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Invoice [title=" + title + ", description=" + description + ", startParameter="
        + startParameter + ", currency=" + currency + ", totalAmount=" + totalAmount + "]";
  }
}
