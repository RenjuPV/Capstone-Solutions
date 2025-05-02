package com.training.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Integer quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public OrderItem() {
		super();
	}

	public OrderItem(Long id, String itemName, Integer quantity, Double price, Stock stock, Order order) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.stock = stock;
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
				+ ", stock=" + stock + ", order=" + order + "]";
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	

    
}

