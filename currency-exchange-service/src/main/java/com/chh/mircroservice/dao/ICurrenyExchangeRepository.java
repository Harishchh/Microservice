package com.chh.mircroservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chh.mircroservice.entity.ExchangeValue;

public interface ICurrenyExchangeRepository extends JpaRepository<ExchangeValue, Long > {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
