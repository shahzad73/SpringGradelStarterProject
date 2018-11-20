package com.orb.interview.controller.currency;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orb.interview.controller.currency.CurrencyRateRequest;
import com.orb.interview.controller.currency.CurrencyRateResponse;
import com.orb.interview.model.currency.CurrencyService;
import com.orb.interview.model.currency.InvalidCurrencyException;
import com.orb.interview.model.currency.CurrencyRequestFailureException;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/currency")
public class CurrencyRateController {

  @Autowired
  private CurrencyService currencyService;

  @RequestMapping(path = "rate", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CurrencyRateResponse rate(@Validated @RequestBody CurrencyRateRequest request) throws InvalidCurrencyException, CurrencyRequestFailureException, InterruptedException  {
	try
	{
		CompletableFuture<Double> result = currencyService.currencyConversion(request.currencyFrom, request.currencyTo);
		return new CurrencyRateResponse(result.get());
    } catch (Exception e) {
      throw new CurrencyRequestFailureException(e);
    }	
	
  }
}
