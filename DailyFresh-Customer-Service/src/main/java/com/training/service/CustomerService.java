package com.training.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.db.CustomerRepository;
import com.training.model.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	public Customer addNewCustomer(Customer customer) {
		return repo.save(customer);

	}
	public Customer updateCustomer(Customer customer) {
		return repo.save(customer);

	}
	
    public Customer addOrUpdateCustomer(Customer customer) {
        Optional<Customer> existingCustomerOpt = repo.findById(customer.getId());

        if (existingCustomerOpt.isPresent()) {
            Customer existingCustomer = existingCustomerOpt.get();
            existingCustomer.setRewardPoints(customer.getRewardPoints());
            return repo.save(existingCustomer);
        } else {
            
            return repo.save(customer);
        }
    }


	public Customer searchCustomer(Customer customer) {
		Optional<Customer> optional=repo.findById(customer.getId());
		if(optional.isPresent())
		return optional.get();
		else
		return null;
		
	}
	public Customer searchCustomer(long id) {
		Optional<Customer> optional=repo.findById(id);
		if(optional.isPresent())
		return optional.get();
		else
		return null;
		
	}
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	public List<Customer> getAllCustomersByLocation(String location) {
        return repo.findByAddress_Location(location)
        		.stream()
                .filter(customer -> location.equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public List<Customer> getAllCustomersByCity(String city) {
        return repo.findByAddress_City(city)
        		.stream()
                .filter(customer -> city.equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
    public boolean deleteCustomer(Customer customer) {
		repo.delete(customer);
		return true;
	}

}
