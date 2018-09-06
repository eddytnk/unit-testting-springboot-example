package com.eddy.unittesting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eddy.unittesting.models.Item;
import com.eddy.unittesting.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("item")
	public Item getItem() {
		return new Item(1,"Shoe",100,50);
	}
	
	@GetMapping("item-from-service")
	public Item getItemFromService() {
		return itemService.getItem();
	}
	
	@GetMapping("/items")
	public List<Item> getItems() {
		return itemService.getAllItems();
	}
}
