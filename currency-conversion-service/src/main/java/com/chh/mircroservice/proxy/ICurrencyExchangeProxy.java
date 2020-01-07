package com.chh.mircroservice.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chh.mircroservice.entity.CurrencyConversion;


//@FeignClient(name="currency-exchange-service",url = "localhost:8000") // when we use the Ribbon client we no need to use feign cleint
@FeignClient(name="currency-exchange-service") //here currency-exchange-service is application name of another microservice 
@RibbonClient(name="currency-exchange-service")
public interface ICurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveValue(@PathVariable String from,@PathVariable String to);

}
