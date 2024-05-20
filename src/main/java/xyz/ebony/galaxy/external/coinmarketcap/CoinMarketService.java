package xyz.ebony.galaxy.external.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;
import xyz.ebony.galaxy.config.CoinMarketConfig;
import xyz.ebony.galaxy.entity.CoinMarketResponse;
import xyz.ebony.galaxy.entity.CryptoCurrency;
import xyz.ebony.galaxy.entity.Status;

@NoArgsConstructor
@lombok.Data
@Service
public class CoinMarketService {

  @Autowired private CoinMarketConfig coinMarketConfig;

  @Autowired private Builder webClient;
  @JsonProperty("status")
  private Status status;
  @JsonProperty("data")
  private List<CryptoCurrency> data;

  public Mono<CoinMarketResponse> coinMarketCrypto() {
    return webClient
        .baseUrl(coinMarketConfig.getUrl())
        .build()
        .get()
        .uri(
            uriBuilder ->
                uriBuilder
                    .path("/v1/cryptocurrency/map")
                    .queryParam("start", "1")
                    .queryParam("limit", "2000")
                    .queryParam("sort", "cmc_rank")
                    .build())
        .header(coinMarketConfig.getHeaderApiKey(), coinMarketConfig.getKey())
        .retrieve()
        .bodyToMono(CoinMarketResponse.class);
  }
}
