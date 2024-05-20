package xyz.ebony.galaxy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Status {

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("error_code")
  private Integer errorCode;

  @JsonProperty("error_message")
  private Object errorMessage;

  @JsonProperty("elapsed")
  private Integer elapsed;

  @JsonProperty("credit_count")
  private Integer creditCount;

  @JsonProperty("notice")
  private Object notice;
}
