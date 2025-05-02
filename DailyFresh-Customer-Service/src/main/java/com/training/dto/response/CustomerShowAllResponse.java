package com.training.dto.response;

import java.util.List;

import com.training.model.Customer;


public class CustomerShowAllResponse {
	
	int statusCode;
	String description;
	List<Customer>customers;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "CustomerShowAllResponse [statusCode=" + statusCode + ", description=" + description + ", customers="
				+ customers + "]";
	}
	
	

}
