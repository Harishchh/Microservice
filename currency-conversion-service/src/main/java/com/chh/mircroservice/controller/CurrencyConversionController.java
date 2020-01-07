package com.chh.mircroservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chh.mircroservice.entity.CurrencyConversion;
import com.chh.mircroservice.proxy.ICurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private ICurrencyExchangeProxy currencyExchangeProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retriveCurreny(@PathVariable String from,
											@PathVariable String to,
											@PathVariable BigDecimal quantity) {
		Map<String,String> uriVariable = new HashMap<String,String> ();
		uriVariable.put("from", from);
		uriVariable.put("to", to);

		 ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversion.class,uriVariable);
		 
		 CurrencyConversion response = responseEntity.getBody();
		
		
		CurrencyConversion currencyConversion = new CurrencyConversion(response.getId(),from,to,
				response.getConversionMultiple(),
				quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
		
		return currencyConversion;
	}
	
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retriveCurrenyFeign(@PathVariable String from,
											@PathVariable String to,
											@PathVariable BigDecimal quantity) {
		 
		
		CurrencyConversion response = currencyExchangeProxy.retriveValue(from, to);
		
		
		CurrencyConversion currencyConversion = new CurrencyConversion(response.getId(),from,to,
				response.getConversionMultiple(),
				quantity,quantity.multiply(response.getConversionMultiple()),response.getPort());
		
		return currencyConversion;
	}


}
