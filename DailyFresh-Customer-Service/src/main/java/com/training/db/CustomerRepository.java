package com.training.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
	List<Customer>findAll();
	List<Customer>findByAddress_City(String  city);
	List<Customer>findByAddress_Location(String  location);
	
	
	

}