package com.eddy.unittesting.controllers;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc; // we use mockMvc to execute request
	
	/**
	 * call: /hello-world : GET Request
	 * verify response is Hello World
	 * @throws Exception 
	 */
	@Test
	public void helloWorld_basicTest() throws Exception {
		
		//Build a request
		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		//run the request
		MvcResult result = mockMvc.perform(request)
					.andExpect(status().isOk())
					.andExpect(content().string("Hello World")) // another way to verify response
					.andReturn();
		//verify the result
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}
}
