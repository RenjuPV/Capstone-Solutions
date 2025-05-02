package com.training.dto.request;

import java.util.List;

import com.training.model.Bill;
import com.training.model.Customer;
import com.training.model.Order;
import com.training.model.OrderItem;

public class AddOrderDTO {
	
	 Order order;
	 Bill bill;
	 List<OrderItem> orderItems;
	 
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	 
	

}
