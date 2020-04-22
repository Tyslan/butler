package org.tyslan.butler.telegram.meta.types.payments;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class SuccessfulPayment implements ApiObject {
  @Expose
  @SerializedName(value = "currency")
  private String currency;
  @Expose
  @SerializedName(value = "total_amount")
  private int totalAmount;
  @Expose
  @SerializedName(value = "invoice_payload")
  private String invoicePayload;
  @Expose
  @SerializedName(value = "shipping_option_id")
  private String shippingOptionId;
  @Expose
  @SerializedName(value = "order_info")
  private OrderInfo orderInfo;
  @Expose
  @SerializedName(value = "telegram_payment_charge_id")
  private String telegramPaymentChargeId;
  @Expose
  @SerializedName(value = "provider_payment_charge_id")
  private String providerPaymentChargeId;

  public String getCurrency() {
    return currency;
  }

  public int getTotalAmount() {
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

  public String getTelegramPaymentChargeId() {
    return telegramPaymentChargeId;
  }

  public String getProviderPaymentChargeId() {
    return providerPaymentChargeId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((currency == null) ? 0 : currency.hashCode());
    result = (prime * result) + ((invoicePayload == null) ? 0 : invoicePayload.hashCode());
    result = (prime * result) + ((orderInfo == null) ? 0 : orderInfo.hashCode());
    result = (prime * result)
        + ((providerPaymentChargeId == null) ? 0 : providerPaymentChargeId.hashCode());
    result = (prime * result) + ((shippingOptionId == null) ? 0 : shippingOptionId.hashCode());
    result = (prime * result)
        + ((telegramPaymentChargeId == null) ? 0 : telegramPaymentChargeId.hashCode());
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
    SuccessfulPayment other = (SuccessfulPayment) obj;
    if (currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!currency.equals(other.currency)) {
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
    if (providerPaymentChargeId == null) {
      if (other.providerPaymentChargeId != null) {
        return false;
      }
    } else if (!providerPaymentChargeId.equals(other.providerPaymentChargeId)) {
      return false;
    }
    if (shippingOptionId == null) {
      if (other.shippingOptionId != null) {
        return false;
      }
    } else if (!shippingOptionId.equals(other.shippingOptionId)) {
      return false;
    }
    if (telegramPaymentChargeId == null) {
      if (other.telegramPaymentChargeId != null) {
        return false;
      }
    } else if (!telegramPaymentChargeId.equals(other.telegramPaymentChargeId)) {
      return false;
    }
    if (totalAmount != other.totalAmount) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "SuccessfulPayment [currency=" + currency + ", totalAmount=" + totalAmount
        + ", invoicePayload=" + invoicePayload + ", shippingOptionId=" + shippingOptionId
        + ", orderInfo=" + orderInfo + ", telegramPaymentChargeId=" + telegramPaymentChargeId
        + ", providerPaymentChargeId=" + providerPaymentChargeId + "]";
  }
}
