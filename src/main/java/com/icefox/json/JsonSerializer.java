
package com.icefox.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {
	
	public static String serializer(Object obj)
	{
		ObjectMapper objectMapper = new  ObjectMapper(); 
		String resultStr = "";
		try {
			resultStr = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return resultStr;
	}
		
	public static Object deserializer(String jsonStr,TypeReference<?> typeReference)
	{
		ObjectMapper objectMapper = new  ObjectMapper(); 
		Object resultPerson = null;
		try {
			resultPerson = objectMapper.readValue(jsonStr, typeReference);
		} catch (JsonParseException e) {
			e.printStackTrace();
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return resultPerson;
	}
}

