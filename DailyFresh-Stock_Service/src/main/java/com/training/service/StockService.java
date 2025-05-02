package com.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.CityRepository;
import com.training.db.ItemRepository;
import com.training.db.LocationRepository;
import com.training.db.StockRepository;
import com.training.model.City;
import com.training.model.Item;
import com.training.model.Location;
import com.training.model.Stock;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Adds new stock or updates existing stock if the combination of item,
	 * location, and city already exists.
	 */
	public Stock addOrUpdateStock(Stock stock) {
		Item item = itemRepository.findById(stock.getItem().getId())
				.orElseThrow(() -> new RuntimeException("Item not found"));

		Location location = locationRepository.findById(stock.getLocation().getId())
				.orElseThrow(() -> new RuntimeException("Location not found"));

		City city = cityRepository.findById(stock.getCity().getId())
				.orElseThrow(() -> new RuntimeException("City not found"));

		Optional<Stock> existingStock = stockRepository.findByItemAndLocationAndCity(item, location, city);

		if (existingStock.isPresent()) {
			Stock existing = existingStock.get();
			existing.setAvailableQuantity(existing.getAvailableQuantity() + stock.getAvailableQuantity());
			return stockRepository.save(existing);
		}

		stock.setItem(item);
		stock.setLocation(location);
		stock.setCity(city);
		stock.setAvailableQuantity(stock.getAvailableQuantity());

		return stockRepository.save(stock);
	}

	public List<Stock> getAllStock() {
		return stockRepository.findAll();
	}

	public Stock getStockByItem(Long itemId) {
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

		return stockRepository.findByItem(item)
				.orElseThrow(() -> new RuntimeException("Stock not found for item ID: " + itemId));
	}

	public Stock getStockByLocation(Long locationId) {
		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new RuntimeException("Location not found"));

		return stockRepository.findByLocation(location)
				.orElseThrow(() -> new RuntimeException("Stock not found for location ID: " + locationId));
	}

	public Stock getStockByCity(Long cityId) {
		City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));

		return stockRepository.findByCity(city)
				.orElseThrow(() -> new RuntimeException("Stock not found for city ID: " + cityId));
	}

	public Stock getStock(Long itemId, Long locationId, Long cityId) {
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));

		Location location = locationRepository.findById(locationId)
				.orElseThrow(() -> new RuntimeException("Location not found"));

		City city = cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("City not found"));

		return stockRepository.findByItemAndLocationAndCity(item, location, city)
				.orElseThrow(() -> new RuntimeException("Stock not found for given item, location, and city"));
	}

	public void reduceStock(Long itemId, Long locationId, Long cityId, int quantity) {
		Stock stock = getStock(itemId, locationId, cityId);

		if (stock.getAvailableQuantity() < quantity) {
			throw new RuntimeException("Insufficient stock");
		}

		stock.setAvailableQuantity(stock.getAvailableQuantity() - quantity);
		stockRepository.save(stock);
	}
}