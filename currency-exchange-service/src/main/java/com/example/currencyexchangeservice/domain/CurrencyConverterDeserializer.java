package com.example.currencyexchangeservice.domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class CurrencyConverterDeserializer extends StdDeserializer<Map<String, Object>> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2085029932965391961L;

	public CurrencyConverterDeserializer() {
		this(null);
	}

	protected CurrencyConverterDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public Map<String, Object> deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		String jsonData = p.readValueAsTree().toString();
		System.out.println(jsonData);
		//System.out.println(p.readValueAsTree().toString());
		
		
		ObjectMapper mapper = new ObjectMapper();
		TypeFactory typeFactory = mapper.getTypeFactory();
		MapType mapType =typeFactory.constructMapType(HashMap.class, String.class, Object.class);
		HashMap<String,Object> map = mapper.readValue(jsonData, mapType);
		
		replaceValue(map);
		return map;
	}

	private void replaceValue(HashMap<String, Object> map) {

		Set<Entry<String, Object>> entrySet = map.entrySet();

		String key;
		int index = 1;
		for (Entry<String, Object> entry : entrySet) {

			key = entry.getKey() + index;
			index++;
			entry.setValue(index);
		}
	}

}
