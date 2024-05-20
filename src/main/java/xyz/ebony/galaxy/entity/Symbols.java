package xyz.ebony.galaxy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Symbols {

  @JsonProperty("symbol")
  private String symbol;

  @JsonProperty("status")
  private String status;

  @JsonProperty("baseAsset")
  private String baseAsset;

  @JsonProperty("baseAssetPrecision")
  private Integer baseAssetPrecision;

  @JsonProperty("quoteAsset")
  private String quoteAsset;

  @JsonProperty("quotePrecision")
  private Integer quotePrecision;

  @JsonProperty("quoteAssetPrecision")
  private Integer quoteAssetPrecision;

  @JsonProperty("orderTypes")
  private List<String> orderTypes;

  @JsonProperty("icebergAllowed")
  private Boolean icebergAllowed;

  @JsonProperty("ocoAllowed")
  private Boolean ocoAllowed;

  @JsonProperty("quoteOrderQtyMarketAllowed")
  private Boolean quoteOrderQtyMarketAllowed;

  @JsonProperty("allowTrailingStop")
  private Boolean allowTrailingStop;

  @JsonProperty("isSpotTradingAllowed")
  private Boolean isSpotTradingAllowed;

  @JsonProperty("isMarginTradingAllowed")
  private Boolean isMarginTradingAllowed;

  @JsonProperty("cancelReplaceAllowed")
  private Boolean cancelReplaceAllowed;

  @JsonProperty("filters")
  private List<?> filters;

  @JsonProperty("permissions")
  private List<?> permissions;

  @JsonProperty("permissionSets")
  private List<List<String>> permissionSets;

  @JsonProperty("defaultSelfTradePreventionMode")
  private String defaultSelfTradePreventionMode;

  @JsonProperty("allowedSelfTradePreventionModes")
  private List<String> allowedSelfTradePreventionModes;
}
