package xyz.ebony.galaxy.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ebony.galaxy.dto.ResultDto;
import xyz.ebony.galaxy.entity.BinanceCryptocurrencyResponse;
import xyz.ebony.galaxy.entity.CoinMarketResponse;
import xyz.ebony.galaxy.entity.CryptoCurrency;
import xyz.ebony.galaxy.entity.Symbols;
import xyz.ebony.galaxy.external.binance.BinanceService;
import xyz.ebony.galaxy.external.coinmarketcap.CoinMarketService;

@NoArgsConstructor
@Data
@RestController()
@RequestMapping("crypto")
public class CryptoCurrencyController {

  @Autowired private CoinMarketService coinMarketService;

  @Autowired private BinanceService binanceService;

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @GetMapping("/binance/list")
  public ResultDto<String> CryptoCurrencyList() throws IOException {

    String fileName = "cryptos_" + LocalDate.now().format(DATE_FORMATTER) + ".txt";
    Path filePath = Paths.get(fileName);
    if (Files.exists(filePath)) {
      // 文件存在，读取内容并返回
      String content = new String(Files.readAllBytes(filePath));
      return ResultDto.success(content);
    }

    CoinMarketResponse coinMarketResponse = coinMarketService.coinMarketCrypto().block();
    List<String> coinMarketList = new ArrayList<>();
    for (CryptoCurrency cryptoCurrency : coinMarketResponse.getData()) {
      coinMarketList.add("BINANCE:" + cryptoCurrency.getSymbol() + "USDT");
    }
    BinanceCryptocurrencyResponse binanceCryptocurrencyResponse = binanceService.exchangeInfo();
    List<String> cryptoCurrencyList = new ArrayList<>();
    for (Symbols symbol : binanceCryptocurrencyResponse.getSymbols()) {
      if ("USDT".equals(symbol.getQuoteAsset()) && "TRADING".equals(symbol.getStatus())) {
        cryptoCurrencyList.add("BINANCE:" + symbol.getSymbol());
      }
    }
    List<String> matchedCryptos = new ArrayList<>();
    for (String coinMarket : coinMarketList) {
      for (String cryptoCurrency : cryptoCurrencyList) {
        if (coinMarket.equals(cryptoCurrency)) {
          matchedCryptos.add(coinMarket);
        }
      }
    }
    StringBuilder matched = new StringBuilder();
    for (String matchedCrypto : matchedCryptos) {
      matched.append(matchedCrypto).append(",");
    }
    if (!matched.isEmpty()) {
      matched = new StringBuilder(matched.substring(0, matched.length() - 1));
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(matched.toString());
    }
    return ResultDto.success(matched.toString());
  }
}
