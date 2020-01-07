package com.chh.mircroservice.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chh.mircroservice.dao.ICurrenyExchangeRepository;
import com.chh.mircroservice.entity.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private ICurrenyExchangeRepository currenyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue	 = this.currenyExchangeRepository.findByFromAndTo(from,to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}


}
