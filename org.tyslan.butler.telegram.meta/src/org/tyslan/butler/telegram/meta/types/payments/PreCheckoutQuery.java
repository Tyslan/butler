package org.tyslan.butler.telegram.meta.types.payments;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.types.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class PreCheckoutQuery implements ApiObject {
  @Expose
  @SerializedName(value = "id")
  private String id;
  @Expose
  @SerializedName(value = "from")
  private User from;
  @Expose
  @SerializedName(value = "currency")
  private String currency;
  @Expose
  @SerializedName(value = "total_amount")
  private String totalAmount;
  @Expose
  @SerializedName(value = "invoice_payload")
  private String invoicePayload;
  @Expose
  @SerializedName(value = "shipping_option_id")
  private String shippingOptionId;
  @Expose
  @SerializedName(value = "order_info")
  private OrderInfo orderInfo;

  public String getId() {
    return id;
  }

  public User getFrom() {
    return from;
  }

  public String getCurrency() {
    return currency;
  }

  public String getTotalAmount() {
    return totalAmount;
  }

  public String getInvoicePayload() {
    return invoicePayload;
  }

  public String getShippingOptionId() {
    return shippingOptionId;
  }

  public OrderInfo getOrderInfo() {
    return orderInfo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((currency == null) ? 0 : currency.hashCode());
    result = (prime * result) + ((from == null) ? 0 : from.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + ((invoicePayload == null) ? 0 : invoicePayload.hashCode());
    result = (prime * result) + ((orderInfo == null) ? 0 : orderInfo.hashCode());
    result = (prime * result) + ((shippingOptionId == null) ? 0 : shippingOptionId.hashCode());
    result = (prime * result) + ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
    PreCheckoutQuery other = (PreCheckoutQuery) obj;
    if (currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!currency.equals(other.currency)) {
      return false;
    }
    if (from == null) {
      if (other.from != null) {
        return false;
      }
    } else if (!from.equals(other.from)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (invoicePayload == null) {
      if (other.invoicePayload != null) {
        return false;
      }
    } else if (!invoicePayload.equals(other.invoicePayload)) {
      return false;
    }
    if (orderInfo == null) {
      if (other.orderInfo != null) {
        return false;
      }
    } else if (!orderInfo.equals(other.orderInfo)) {
      return false;
    }
    if (shippingOptionId == null) {
      if (other.shippingOptionId != null) {
        return false;
      }
    } else if (!shippingOptionId.equals(other.shippingOptionId)) {
      return false;
    }
    if (totalAmount == null) {
      if (other.totalAmount != null) {
        return false;
      }
    } else if (!totalAmount.equals(other.totalAmount)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PreCheckoutQuery [id=" + id + ", from=" + from + ", currency=" + currency
        + ", totalAmount=" + totalAmount + ", invoicePayload=" + invoicePayload
        + ", shippingOptionId=" + shippingOptionId + ", orderInfo=" + orderInfo + "]";
  }
}
