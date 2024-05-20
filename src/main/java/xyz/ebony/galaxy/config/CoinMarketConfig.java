package xyz.ebony.galaxy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "coinmarketcap")
public class CoinMarketConfig {
  private String key;
  private String url;
  private String headerApiKey;

  public String getKey() {
    return key;
  }

  public String getUrl() {
    return url;
  }

  public String getHeaderApiKey() {
    return headerApiKey;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setHeaderApiKey(String headerApiKey) {
    this.headerApiKey = headerApiKey;
  }
}
