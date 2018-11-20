package com.orb.interview.model.currency;
import java.util.concurrent.CompletableFuture;

/**
 * Service for currency rate related operations
 */
public interface CurrencyService {
  /**
   * Get Currency Rate from online service.
   * @param fromCurrency.
   * @param toCurrency.
   */
  CompletableFuture<Double> currencyConversion(String fromCurrency, String toCurrency) throws InvalidCurrencyException, CurrencyRequestFailureException;
}
