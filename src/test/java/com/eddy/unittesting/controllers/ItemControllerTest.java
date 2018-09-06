package com.eddy.unittesting.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eddy.unittesting.models.Item;
import com.eddy.unittesting.services.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ItemService itemService;
	
	@Test
	public void getItem_returnSuccessTest() throws Exception {
		
		RequestBuilder request  = MockMvcRequestBuilders.get("/item")
				.accept(MediaType.APPLICATION_JSON);
		
		String expectedContent = "{\"id\":1,\"name\":\"Shoe\",\"price\":100,\"quantity\":50}";	
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(expectedContent))
				.andReturn();
	}
	
	@Test
	public void getItem_UsingItemService() throws Exception {
		
		RequestBuilder request  = MockMvcRequestBuilders.get("/item-from-service")
				.accept(MediaType.APPLICATION_JSON);
		
		when(itemService.getItem()).thenReturn(new Item(1,"Shoe",100,50));
		String expectedContent = "{\"id\":1,\"name\":\"Shoe\",\"price\":100,\"quantity\":50}";
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(expectedContent))
				.andReturn();
	}
	
	@Test
	public void getAllItems_UsingItemService() throws Exception {
		
		RequestBuilder request  = MockMvcRequestBuilders.get("/items")
				.accept(MediaType.APPLICATION_JSON);
		
		when(itemService.getAllItems()).thenReturn(
				Arrays.asList(new Item(1,"Shoe",100,50))
							);
		String expectedContent = "[{\"id\":1,\"name\":\"Shoe\",\"price\":100,\"quantity\":50}]";
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json(expectedContent))
				.andReturn();
	}
	
	
}
