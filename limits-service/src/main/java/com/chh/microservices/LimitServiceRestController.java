package com.chh.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chh.microservices.bean.LimitService;

@RestController
public class LimitServiceRestController {
	@Autowired
	private ControllerConfigration controllerConfiguration;
	
	@GetMapping("/limit")
	public LimitService getLimitService() {
		return new LimitService(this.controllerConfiguration.getMaximum(),this.controllerConfiguration.getMinimum());
	}
}
