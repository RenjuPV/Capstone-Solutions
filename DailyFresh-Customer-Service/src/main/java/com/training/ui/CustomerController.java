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
import com.training.dto.request.CustomerAddRequest;
import com.training.dto.request.CustomerUpdateRequest;
import com.training.dto.response.CustomerAddResponse;
import com.training.dto.response.CustomerModifyResponse;
import com.training.dto.response.CustomerSearchResponse;
import com.training.dto.response.CustomerShowAllByCityResponse;
import com.training.dto.response.CustomerShowAllByLocationResponse;
import com.training.dto.response.CustomerShowAllResponse;
import com.training.exception.CustomerNotFoundException;
import com.training.model.Customer;
import com.training.service.CustomerService;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping(value = "/add")
	public ResponseEntity<CustomerAddResponse> f1(@RequestBody CustomerAddRequest request) {
		Customer customer1 = this.service.addNewCustomer(request.getCustomer());
		CustomerAddResponse response = new CustomerAddResponse();
		response.setStatusCode(200);
		response.setDescription("Customer Added successfully");
		response.setCustomer(customer1);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/modify")
	public ResponseEntity<CustomerModifyResponse> f2(@RequestBody CustomerUpdateRequest request) {

		CustomerModifyResponse response = new CustomerModifyResponse();

		Customer customer1 = this.service.searchCustomer(request.getCustomer());
		if (customer1 != null) {
			Customer customer2 = this.service.updateCustomer(request.getCustomer());
			response.setStatusCode(200);
			response.setDescription("Customer Modified successfully");
			response.setCustomer(customer2);
			return ResponseEntity.ok(response);
		} else {
			response.setStatusCode(404);
			response.setDescription("Customer Not found for Modification");
			response.setCustomer(null);
			return new ResponseEntity<CustomerModifyResponse>(response, HttpStatus.NOT_FOUND);
		}
	}

	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<CustomerAddResponse> addOrUpdateCustomer(@RequestBody Customer customer) {
	    Customer savedCustomer = service.addOrUpdateCustomer(customer);
	    CustomerAddResponse response = new CustomerAddResponse();
	    response.setStatusCode(200);
	    response.setDescription("Customer added or updated successfully");
	    response.setCustomer(savedCustomer);
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{vid}")
	public ResponseEntity f3(@PathVariable(name = "vid") int vid) throws Exception {
		CustomerSearchResponse response = new CustomerSearchResponse();
		Customer customer = this.service.searchCustomer(vid);

		if (customer != null) {
			response.setStatusCode(200);
			response.setDescription("Customer fetched successfully");
			response.setCustomer(customer);
			return new ResponseEntity<CustomerSearchResponse>(response, HttpStatus.OK);
		} else {
			Exception exception = new CustomerNotFoundException("Customer not found");
			throw exception;
		}

	}

	@GetMapping(value = "/showAll", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CustomerShowAllResponse> f4() {
		List<Customer> customers = this.service.getAllCustomers();
		CustomerShowAllResponse response = new CustomerShowAllResponse();
		response.setStatusCode(200);
		response.setDescription("All customers Fetched");
		response.setCustomers(customers);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/showAllByLocation/{name}")
	public ResponseEntity<CustomerShowAllByLocationResponse> f6(@PathVariable(name = "name") String name) {
		CustomerShowAllByLocationResponse response = new CustomerShowAllByLocationResponse();
		List<Customer> customerByLocation = this.service.getAllCustomersByLocation(name);
		if (customerByLocation.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There are no customers by same name " + name);
			response.setCustomers(customerByLocation);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customerByLocation.size() + " with same name " + name);
			response.setCustomers(customerByLocation);
		}
		return ResponseEntity.ok(response);

	}

	@GetMapping("/showAllByCity")
	public ResponseEntity<CustomerShowAllByCityResponse> f7(@RequestParam(name = "txt_city") String city) {
		CustomerShowAllByCityResponse response = new CustomerShowAllByCityResponse();
		List<Customer> customersByCity = this.service.getAllCustomersByCity(city);
		if (customersByCity.isEmpty()) {
			response.setStatusCode(200);
			response.setDescription("There are no customers from city " + city);
			response.setCustomers(customersByCity);
		} else {
			response.setStatusCode(200);
			response.setDescription("There are " + customersByCity.size() + " customers with same city " + city);
			response.setCustomers(customersByCity);
		}
		return ResponseEntity.ok(response);

	}
}
