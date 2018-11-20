package com.orb.interview.model.currency;

import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.scheduling.annotation.Async;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.*;  

@Service
public class CurrencyServiceImpl implements CurrencyService {


  @Async
  @Transactional
  @Override
  public CompletableFuture<Double> currencyConversion(String fromCurrency, String toCurrency) throws CurrencyRequestFailureException, InvalidCurrencyException 
  {
    try {
		
		List<String> listOfCurrencies = Arrays.asList("GBP", "USD", "EUR", "JPY");	
		
		if( !( listOfCurrencies.contains(fromCurrency) && listOfCurrencies.contains(toCurrency) ) )
			throw new InvalidCurrencyException();
		
        /*RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("http://free.currencyconverterapi.com/api/v5/convert?q=" + fromCurrency + "_" + toCurrency + "&compact=y", String.class);			

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(json);
		
		String rateValue = rootNode.get(fromCurrency + "_" + toCurrency).get("val").asText();
		
		String rateValue = rootNode.get("price").asText();
		
		return Double.valueOf(rateValue);		
		*/

		
		RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("https://forex.1forge.com/1.0.3/quotes?pairs=" + fromCurrency + toCurrency + "&api_key=xdhXVIfGz7I6xVbI5f3bsWOu2lz2YNaI", String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(json);
		
		String rateValue = rootNode.get(0).get("price").asText();
		
		return CompletableFuture.completedFuture(  Double.valueOf(rateValue)  );		

    } catch (Exception e) {
      throw new CurrencyRequestFailureException(e);
    }
  }


}
