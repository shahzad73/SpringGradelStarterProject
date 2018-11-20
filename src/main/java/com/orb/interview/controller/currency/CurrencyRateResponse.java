package com.orb.interview.controller.currency;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Json format for a currency rate response
 */
public class CurrencyRateResponse {
  /**
   * Rate of conversion
   */
  @JsonProperty("rate")
  public double rate;

  public CurrencyRateResponse(double _rate) {
    this.rate = _rate;
  }
}
