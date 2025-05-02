package com.training.db;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.model.City;
import com.training.model.Item;
import com.training.model.Location;
import com.training.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
	 Optional<Stock> findByItemAndLocationAndCity(Item item, Location location, City city);
	 Optional<Stock> findByItem(Item item);
	 Optional<Stock> findByLocation(Location location);
	 Optional<Stock> findByCity(City city);
	 

}
