package xyz.ebony.galaxy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "binance")
public class BinanceConfig {
  private String key;

  private String secret;

  public String getKey() {
    return key;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
