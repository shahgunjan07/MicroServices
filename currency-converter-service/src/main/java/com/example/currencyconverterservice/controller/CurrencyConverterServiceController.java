package com.example.currencyconverterservice.controller;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconverterservice.domain.CurrencyConverterDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CurrencyConverterServiceController {

	
	@GetMapping("/test/json")
	public ResponseEntity<Object> test( ) throws UnsupportedCharsetException, ClientProtocolException, IOException {
		System.out.println("Inside :");
		CloseableHttpClient clients = HttpClients.createDefault();
		StringEntity entity = new StringEntity(generateJsonString(), ContentType.APPLICATION_JSON);
		HttpPost postMethod = new HttpPost("http://localhost:9090/test/deserialize/json");
		postMethod.setEntity(entity);
		CloseableHttpResponse response = clients.execute(postMethod);
		System.out.println("Response  :"+response.getStatusLine().getStatusCode());
		return  ResponseEntity.ok().build();
	}
	
	private  String generateJsonString() throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		map.put("a", "a");
		map.put("b", "b");
		
		CurrencyConverterDto dto = new CurrencyConverterDto();
		dto.setId(1);
		dto.setKeyVal(map);
		
		ObjectMapper mapper = new  ObjectMapper();
		
		return mapper.writeValueAsString(dto);
	}
}
