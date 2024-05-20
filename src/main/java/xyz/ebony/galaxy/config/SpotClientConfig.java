package xyz.ebony.galaxy.config;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotClientConfig {

  @Autowired
  private BinanceConfig binanceConfig;

  @Bean
  public SpotClient spotClient() {
    return new SpotClientImpl(binanceConfig.getKey(), binanceConfig.getSecret());
  }
}
