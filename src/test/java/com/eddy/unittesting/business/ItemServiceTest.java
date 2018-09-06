package com.eddy.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.eddy.unittesting.models.Item;
import com.eddy.unittesting.repos.ItemRepository;
import com.eddy.unittesting.services.ItemService;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@Mock
	private ItemRepository repository;
	
	@InjectMocks
	private ItemService itemService;
	
	@Test
	public void getItems_basicTest() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(1,"Laptop",10,6)));
		
		List<Item> allItems = itemService.getAllItems();
		
		
		assertEquals(60,allItems.get(0).getValue());
		
	}
}
