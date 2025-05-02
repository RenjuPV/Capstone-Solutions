package com.training.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;




@Embeddable
public class Address {
	
	 	 
	private String houseName;
	private String city;
	private String pinCode;
	private String location;
	
	
	
	

}
