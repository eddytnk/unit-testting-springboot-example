package com.eddy.unittesting.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eddy.unittesting.models.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
