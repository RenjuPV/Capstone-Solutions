package com.training.dto.response;
import com.training.model.Store;


public class StoreAddResponse {
	int statusCode;
	String description;
	Store store;
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
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "StoreAddResponse [statusCode=" + statusCode + ", description=" + description + ", store=" + store + "]";
	}
	
	

}
