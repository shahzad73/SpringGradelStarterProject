package com.orb.interview.model.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.orb.interview.model.currency.InvalidCurrencyException;
import com.orb.interview.model.currency.CurrencyRequestFailureException;
import com.orb.interview.model.currency.CurrencyService;
import com.orb.interview.model.currency.CurrencyServiceImpl;

import java.util.concurrent.CompletableFuture;



@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CurrencyServiceImpl.class)
public class CurrencyRateImplTest {

  @SpyBean
  private CurrencyServiceImpl currencyService;  

  
  @Test 
  public void checkCurrency_Rate_Conversion_Service_IsWorking() throws Exception, CurrencyRequestFailureException {
	  
	  String from = "GBP";
	  String to = "USD";
	  
	  try
	  {
		  CompletableFuture<Double> result = currencyService.currencyConversion(from, to);
		  assertThat(result.get()).isNotNull(); 
      } catch (Exception e) {
          throw new CurrencyRequestFailureException(e);
      }		  
  }
  

  
  
  
  
}