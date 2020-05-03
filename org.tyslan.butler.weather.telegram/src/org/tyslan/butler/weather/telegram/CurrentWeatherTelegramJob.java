package org.tyslan.butler.weather.telegram;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CurrentWeatherTelegramJob")
public class CurrentWeatherTelegramJob {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String jobName;
  private String expression;
  private String location;
  private Long chatId;

  public CurrentWeatherTelegramJob() {
    // JPA
  }

  public CurrentWeatherTelegramJob(String jobName, String expression, String location,
      Long chatId) {
    this.jobName = jobName;
    this.expression = expression;
    this.location = location;
    this.chatId = chatId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Long getChatId() {
    return chatId;
  }

  public void setChatId(Long chatId) {
    this.chatId = chatId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((chatId == null) ? 0 : chatId.hashCode());
    result = (prime * result) + ((expression == null) ? 0 : expression.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + ((jobName == null) ? 0 : jobName.hashCode());
    result = (prime * result) + ((location == null) ? 0 : location.hashCode());
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
    CurrentWeatherTelegramJob other = (CurrentWeatherTelegramJob) obj;
    if (chatId == null) {
      if (other.chatId != null) {
        return false;
      }
    } else if (!chatId.equals(other.chatId)) {
      return false;
    }
    if (expression == null) {
      if (other.expression != null) {
        return false;
      }
    } else if (!expression.equals(other.expression)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (jobName == null) {
      if (other.jobName != null) {
        return false;
      }
    } else if (!jobName.equals(other.jobName)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CurrentWeatherTelegramJob [id=" + id + ", jobName=" + jobName + ", expression="
        + expression + ", location=" + location + ", chatId=" + chatId + "]";
  }
}
