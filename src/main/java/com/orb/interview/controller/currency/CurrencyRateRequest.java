package com.orb.interview.controller.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

/**
 * Json format for a Currency Rate request
 */
public class CurrencyRateRequest {
  /**
   * From Currency Symbile 
   */
  @NotBlank(message = "{com.orb.interview.currency.CurrencyFromNotBlank}")
  @JsonProperty("from")
  public String currencyFrom;

  /**
   * TO Currency Symbil 
   */
  @NotBlank(message = "{com.orb.interview.currency.CurrencyToNotBlank}")
  @JsonProperty("to")
  public String currencyTo;
}
