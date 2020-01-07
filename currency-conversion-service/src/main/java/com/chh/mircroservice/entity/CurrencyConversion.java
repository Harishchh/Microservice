package com.chh.mircroservice.entity;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quality;
	private BigDecimal totalCalculationAmount;
	private int port;
	
	public CurrencyConversion () { 
		
	}
	public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quality,
			BigDecimal totalCalculationAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quality = quality;
		this.totalCalculationAmount = totalCalculationAmount;
		this.port = port;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuality() {
		return quality;
	}
	public void setQuality(BigDecimal quality) {
		this.quality = quality;
	}
	public BigDecimal getTotalCalculationAmount() {
		return totalCalculationAmount;
	}
	public void setTotalCalculationAmount(BigDecimal totalCalculationAmount) {
		this.totalCalculationAmount = totalCalculationAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
