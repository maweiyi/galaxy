package xyz.ebony.galaxy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinMarketResponse {
  private Status status;
  private List<CryptoCurrency> data;
}
