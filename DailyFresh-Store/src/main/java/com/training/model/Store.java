package com.training.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



@Entity
@Table (name="stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Id == other.Id;
	}

	private String storeAddress;
	
	@Column
	@NotEmpty(message="Store In Charge name is mandatory...Cannot be left blank")
	@Size(min=4,max=20,message="Length of Name should be between 3 to 20 ")
	private String storeInChargeName;
	
	@Column
	@Pattern(regexp="^[0-9]{10}$",message="Phone number must be exactly 10 digits")
	private String storeInChargePhoneNum;
	
	private int cityId;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreInChargeName() {
		return storeInChargeName;
	}

	public void setStoreInChargeName(String storeInChargeName) {
		this.storeInChargeName = storeInChargeName;
	}

	public String getStoreInChargePhoneNum() {
		return storeInChargePhoneNum;
	}

	public void setStoreInChargePhoneNum(String storeInChargePhoneNum) {
		this.storeInChargePhoneNum = storeInChargePhoneNum;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	@Override
	public String toString() {
		return "Store [Id=" + Id + ", storeAddress=" + storeAddress + ", storeInChargeName=" + storeInChargeName
				+ ", storeInChargePhoneNum=" + storeInChargePhoneNum + ", cityId=" + cityId + "]";
	}

	public Store(int id, String storeAddress,
			@NotEmpty(message = "Store In Charge name is mandatory...Cannot be left blank") @Size(min = 4, max = 20, message = "Length of Name should be between 3 to 20 ") String storeInChargeName,
			@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be exactly 10 digits") String storeInChargePhoneNum,
			int cityId) {
		super();
		Id = id;
		this.storeAddress = storeAddress;
		this.storeInChargeName = storeInChargeName;
		this.storeInChargePhoneNum = storeInChargePhoneNum;
		this.cityId = cityId;
	}

	public Store() {
		super();
	}
	
	
	
	

}
