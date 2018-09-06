package com.eddy.unittesting;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIntergrationTest {


	@Autowired
	private TestRestTemplate restTemplate;
	
	//you can use @MockBean to mock any external dependency you need to inject in your integration test
	
	@Test
	public void contextLoads() throws JSONException {
		String response = restTemplate.getForObject("/items", String.class);
		System.out.println(response);
		JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false); //get response from in-memory db
	}
}
