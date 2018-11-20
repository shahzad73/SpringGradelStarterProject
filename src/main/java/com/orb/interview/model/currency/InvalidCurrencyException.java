package com.orb.interview.model.currency;

import org.springframework.http.HttpStatus;

public class InvalidCurrencyException extends Exception {
  public static final String INVALID_CURRENCY_EXCEPTION = "com.orb.interview.currency.invalid.currency.exception";

  public InvalidCurrencyException() {
	super(INVALID_CURRENCY_EXCEPTION);
  }
}
