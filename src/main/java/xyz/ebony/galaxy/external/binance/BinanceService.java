package xyz.ebony.galaxy.external.binance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ebony.galaxy.config.SpotClientConfig;
import xyz.ebony.galaxy.entity.BinanceCryptocurrencyResponse;

@Service
public class BinanceService {

  @Autowired
  private SpotClientConfig spotClientConfig;

  public BinanceCryptocurrencyResponse exchangeInfo() throws JsonProcessingException {
    String crypto =  spotClientConfig.spotClient().createMarket().exchangeInfo(new HashMap<>());
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.readValue(crypto, BinanceCryptocurrencyResponse.class);
  }
}
