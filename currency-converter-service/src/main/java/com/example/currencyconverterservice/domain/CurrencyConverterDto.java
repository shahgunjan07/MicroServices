package com.example.currencyconverterservice.domain;

import java.util.Map;

public class CurrencyConverterDto {

	private Integer id;
	
	private Map<String, Object> keyVal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Map<String, Object> getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(Map<String, Object> keyVal) {
		this.keyVal = keyVal;
	}

	@Override
	public String toString() {
		return "CurrentConverterDto [id=" + id + ", keyVal=" + keyVal + "]";
	}
	
	
	
}
