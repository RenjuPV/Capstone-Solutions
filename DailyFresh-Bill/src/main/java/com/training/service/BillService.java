package com.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.BillRepository;
import com.training.model.Bill;

@Service
public class BillService {

	@Autowired
	BillRepository repo;

	public Bill addNewBill(Bill bill) {
		return repo.save(bill);
	}
	public List<Bill> getAllBills() {
		return repo.findAll();
	}

}
