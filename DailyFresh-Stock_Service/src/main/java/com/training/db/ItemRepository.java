package com.training.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByCategory(String category);
}