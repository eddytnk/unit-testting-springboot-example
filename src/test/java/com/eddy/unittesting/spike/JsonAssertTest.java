package com.eddy.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonAssertTest {
	
	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\":1001,\"name\":\"Book\",\"quantity\":10}," + 
				"{\"id\":1002,\"name\":\"Pen\",\"quantity\":13}," + 
				"{\"id\":1003,\"name\":\"Pencil\",\"quantity\":15}" + 
				"]";
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		System.out.println(context.read("$..id").toString());
		
	}
}
