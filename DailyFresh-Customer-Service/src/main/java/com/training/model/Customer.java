package com.training.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.EmbeddableInstantiator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private long id;
	@Column
	@NotEmpty(message="Customer name is mandatory...Cannot be left blank")
	@Size(min=4,max=20,message="Length of Name should be between 3 to 20 ")
	private String custName;
	
	@Embedded
	private Address address;
		
	@Column
	@Email(message="Please enter valid email")
	private String custEmail;
	
	@Column
	@Pattern(regexp="^[0-9]{10}$",message="Phone number must be exactly 10 digits")
	private String custPhoneNumber;
	@Column
	private int rewardPoints;
	
	public Customer(long id,
			@NotEmpty(message = "Customer name is mandatory...Cannot be left blank") @Size(min = 4, max = 20, message = "Length of Name should be between 3 to 20 ") String custName,
			Address address, @Email(message = "Please enter valid email") String custEmail,
			@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits") String custPhoneNumber,
			int rewardPoints) {
		super();
		this.id = id;
		this.custName = custName;
		this.address = address;
		this.custEmail = custEmail;
		this.custPhoneNumber = custPhoneNumber;
		this.rewardPoints = rewardPoints;
	}
	public Customer() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPhoneNumber() {
		return custPhoneNumber;
	}
	public void setCustPhoneNumber(String custPhoneNumber) {
		this.custPhoneNumber = custPhoneNumber;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return id == other.id;
	}
	
	
	
	
		
	
	

}
