package com.training.dto.response;

import java.util.List;
import com.training.model.Store;

public class StoreShowAllResponse {
	
	int statusCode;
	String description;
	List<Store>stores;
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
	public List<Store> getStores() {
		return stores;
	}
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	@Override
	public String toString() {
		return "StoreShowAllResponse [statusCode=" + statusCode + ", description=" + description + ", stores=" + stores
				+ "]";
	}
	
	

}
