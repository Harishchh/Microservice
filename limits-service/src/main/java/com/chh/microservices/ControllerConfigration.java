package com.chh.microservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

@Controller
@ConfigurationProperties("limit-service")
public class ControllerConfigration {

	private int maximum;
	
	private int minimum;

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	
	
}
