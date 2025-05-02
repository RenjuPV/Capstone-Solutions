package com.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.StoreRepository;
import com.training.model.Store;

@Service
public class StoreService {

	@Autowired
	StoreRepository repo;

	public Store addNewStore(Store store) {
		return repo.save(store);

	}

	public List<Store> getAllStores() {
		return repo.findAll();
	}

}
