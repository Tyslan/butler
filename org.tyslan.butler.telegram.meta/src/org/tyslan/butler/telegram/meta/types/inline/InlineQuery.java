package org.tyslan.butler.telegram.meta.types.inline;

import org.tyslan.butler.telegram.meta.api.types.ApiObject;
import org.tyslan.butler.telegram.meta.types.Location;
import org.tyslan.butler.telegram.meta.types.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
public class InlineQuery implements ApiObject {
  @Expose
  @SerializedName(value = "id")
  private String id;
  @Expose
  @SerializedName(value = "from")
  private User from;
  @Expose
  @SerializedName(value = "location")
  private Location location;
  @Expose
  @SerializedName(value = "query")
  private String query;
  @Expose
  @SerializedName(value = "offset")
  private String offset;

  public String getId() {
    return id;
  }

  public User getFrom() {
    return from;
  }

  public Location getLocation() {
    return location;
  }

  public String getQuery() {
    return query;
  }

  public String getOffset() {
    return offset;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((from == null) ? 0 : from.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + ((location == null) ? 0 : location.hashCode());
    result = (prime * result) + ((offset == null) ? 0 : offset.hashCode());
    result = (prime * result) + ((query == null) ? 0 : query.hashCode());
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
    InlineQuery other = (InlineQuery) obj;
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
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (offset == null) {
      if (other.offset != null) {
        return false;
      }
    } else if (!offset.equals(other.offset)) {
      return false;
    }
    if (query == null) {
      if (other.query != null) {
        return false;
      }
    } else if (!query.equals(other.query)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "InlineQuery [id=" + id + ", from=" + from + ", location=" + location + ", query="
        + query + ", offset=" + offset + "]";
  }

}
