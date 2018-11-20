package com.orb.interview.model.currency;

import org.springframework.http.HttpStatus;

import com.orb.interview.model.SystemException;

public class CurrencyRequestFailureException extends Exception {
  public static final String CURRENCY_REQUEST_FAILURE_KEY = "com.orb.interview.currency.Request.Failure";

  public CurrencyRequestFailureException(Throwable cause) {
    super(CURRENCY_REQUEST_FAILURE_KEY, cause);
  }
}
