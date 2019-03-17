package com.example.currencyexchangeservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyexchangeservice.domain.CurrencyConverterDto;

@RestController
public class CurrencyExchangeController {

	
	@RequestMapping("/test/deserialize/json")
	public ResponseEntity<Object> deserialize(@RequestBody CurrencyConverterDto dto)	 {
		System.out.println("On Remote Server Side : ");
		System.out.println(dto);
		return ResponseEntity.ok().build();
	}
}
