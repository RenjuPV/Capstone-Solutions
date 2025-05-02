package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Stock;
import com.training.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

	@Autowired
	private StockService stockService;

	// Add or Update Stock
	@PostMapping("/addOrUpdate")
	public Stock addOrUpdateStock(@RequestBody Stock stock) {
		return stockService.addOrUpdateStock(stock);
	}

	// Get Stock by Location
	@GetMapping("/getStockByLocation")
	public Stock getStockByLocation(@RequestParam Long locationId) {
		return stockService.getStockByLocation(locationId);
	}

	// Get Stock by City
	@GetMapping("/getStockByCity")
	public Stock getStockByCity(@RequestParam Long cityId) {
		return stockService.getStockByCity(cityId);
	}

    // Get Stock by Item
	@GetMapping("/getStockByItemId")
	public Stock getStock(@RequestParam Long itemId) {
		return stockService.getStockByItem(itemId);
	}

	// Get All Stock
	@GetMapping("/getByAll")
	public List<Stock> getAllStock() {
		return stockService.getAllStock();
	}

	// Reduce Stock Quantity
	@PutMapping("/reduce")
	public String reduceStock(@RequestParam Long itemId, @RequestParam Long locationId, @RequestParam Long cityId,
			@RequestParam int quantity) {
		stockService.reduceStock(itemId, locationId, cityId, quantity);
		return "Stock reduced successfully.";
	}

}