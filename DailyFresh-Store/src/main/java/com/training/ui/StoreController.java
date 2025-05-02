package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.training.dto.request.StoreAddRequest;
import com.training.dto.response.StoreAddResponse;
import com.training.dto.response.StoreShowAllResponse;
import com.training.exception.StoreNotFoundException;
import com.training.model.Store;
import com.training.service.StoreService;
@RestController
@RequestMapping(value = "/api")
public class StoreController {

	@Autowired
	StoreService service;

	@PostMapping(value = "/add")
	public ResponseEntity<StoreAddResponse> f1(@RequestBody StoreAddRequest request) {
		Store store1 = this.service.addNewStore(request.getStore());
		StoreAddResponse response = new StoreAddResponse();
		response.setStatusCode(200);
		response.setDescription("Store Added successfully");
		response.setStore(store1);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	
	@GetMapping(value = "/showAll", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StoreShowAllResponse> f4() {
		List<Store> stores = this.service.getAllStores();
		StoreShowAllResponse response = new StoreShowAllResponse();
		response.setStatusCode(200);
		response.setDescription("All stores Fetched");
		response.setStores(stores);
		return ResponseEntity.ok(response);
	}

	
	
}
