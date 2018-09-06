package com.eddy.unittesting.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddy.unittesting.models.Item;
import com.eddy.unittesting.repos.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;

	public List<Item>getAllItems() {
		 List<Item> items = repository.findAll();
		/* for(Item item:items) {
			 item.setValue(item.getPrice()* item.getQuantity());
		 }*/
		  items.stream().forEach(item->item.setValue(item.getPrice()* item.getQuantity()));
		  return items;
	}
	public Item getItem() {
		return new Item(1,"Shoe",100,50);
	}
}
