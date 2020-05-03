package org.tyslan.butler.telegram.meta.types.poll;

import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {
  @JsonProperty(value = "id")
  private String id;
  @JsonProperty(value = "question")
  private String question;
  @JsonProperty(value = "options")
  private PollOption[] options;
  @JsonProperty(value = "total_voter_count")
  private int totalVoterCount;
  @JsonProperty(value = "is_closed")
  private boolean isClosed;
  @JsonProperty(value = "is_anonymous")
  private boolean isAnonymous;
  @JsonProperty(value = "type")
  private String type;
  @JsonProperty(value = "allows_multiple_answers")
  private Boolean allowsMultipleAnswers;
  @JsonProperty(value = "correct_option_id")
  private Integer correctOptionId;

  private Poll() {
    // Jackson
  }

  public String getId() {
    return id;
  }

  public String getQuestion() {
    return question;
  }

  public PollOption[] getOptions() {
    return options;
  }

  public int getTotalVoterCount() {
    return totalVoterCount;
  }

  public boolean isClosed() {
    return isClosed;
  }

  public boolean isAnonymous() {
    return isAnonymous;
  }

  public String getType() {
    return type;
  }

  public Boolean getAllowsMultipleAnswers() {
    return allowsMultipleAnswers;
  }

  public Integer getCorrectOptionId() {
    return correctOptionId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        (prime * result) + ((allowsMultipleAnswers == null) ? 0 : allowsMultipleAnswers.hashCode());
    result = (prime * result) + ((correctOptionId == null) ? 0 : correctOptionId.hashCode());
    result = (prime * result) + ((id == null) ? 0 : id.hashCode());
    result = (prime * result) + (isAnonymous ? 1231 : 1237);
    result = (prime * result) + (isClosed ? 1231 : 1237);
    result = (prime * result) + Arrays.hashCode(options);
    result = (prime * result) + ((question == null) ? 0 : question.hashCode());
    result = (prime * result) + totalVoterCount;
    result = (prime * result) + ((type == null) ? 0 : type.hashCode());
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
    Poll other = (Poll) obj;
    if (allowsMultipleAnswers == null) {
      if (other.allowsMultipleAnswers != null) {
        return false;
      }
    } else if (!allowsMultipleAnswers.equals(other.allowsMultipleAnswers)) {
      return false;
    }
    if (correctOptionId == null) {
      if (other.correctOptionId != null) {
        return false;
      }
    } else if (!correctOptionId.equals(other.correctOptionId)) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (isAnonymous != other.isAnonymous) {
      return false;
    }
    if (isClosed != other.isClosed) {
      return false;
    }
    if (!Arrays.equals(options, other.options)) {
      return false;
    }
    if (question == null) {
      if (other.question != null) {
        return false;
      }
    } else if (!question.equals(other.question)) {
      return false;
    }
    if (totalVoterCount != other.totalVoterCount) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Poll [id=" + id + ", question=" + question + ", options=" + Arrays.toString(options)
        + ", totalVoterCount=" + totalVoterCount + ", isClosed=" + isClosed + ", isAnonymous="
        + isAnonymous + ", type=" + type + ", allowsMultipleAnswers=" + allowsMultipleAnswers
        + ", correctOptionId=" + correctOptionId + "]";
  }
}
