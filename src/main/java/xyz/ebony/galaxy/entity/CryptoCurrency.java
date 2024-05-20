package xyz.ebony.galaxy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@lombok.Data
public class CryptoCurrency {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("rank")
  private Integer rank;

  @JsonProperty("name")
  private String name;

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("slug")
  private String slug;

  @JsonProperty("is_active")
  private Integer isActive;

  @JsonProperty("first_historical_data")
  private String firstHistoricalData;

  @JsonProperty("last_historical_data")
  private String lastHistoricalData;

  @JsonProperty("platform")
  private Object platform;
}
