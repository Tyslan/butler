package org.tyslan.butler.telegram.meta.types.payments;

import org.tyslan.butler.telegram.meta.types.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingQuery {
  @JsonProperty(value = "id")
  private String id;
  @JsonProperty(value = "from")
  private User from;
  @JsonProperty(value = "invoice_payload")
  private String invoicePayLoad;
  @JsonProperty(value = "shipping_address")
  private ShippingAddress shippingAddress;

  private ShippingQuery() {
    // Jackson
  }

  public String getId() {
    return id;
  }

  public User getFrom() {
    return from;
  }

  public String getInvoicePayLoad() {
    return invoicePayLoad;
  }

  public ShippingAddress getShippingAddress() {
    return shippingAddress;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((from == null) ? 0 : from.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + ((invoicePayLoad == null) ? 0 : invoicePayLoad.hashCode());
    result = (prime * result) + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
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
    ShippingQuery other = (ShippingQuery) obj;
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
    if (invoicePayLoad == null) {
      if (other.invoicePayLoad != null) {
        return false;
      }
    } else if (!invoicePayLoad.equals(other.invoicePayLoad)) {
      return false;
    }
    if (shippingAddress == null) {
      if (other.shippingAddress != null) {
        return false;
      }
    } else if (!shippingAddress.equals(other.shippingAddress)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ShippingQuery [id=" + id + ", from=" + from + ", invoicePayLoad=" + invoicePayLoad
        + ", shippingAddress=" + shippingAddress + "]";
  }
}
