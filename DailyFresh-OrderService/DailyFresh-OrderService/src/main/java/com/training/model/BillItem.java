package com.training.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="billItems")
public class BillItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private int quantity;
    private double price;  

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public BillItem(Long id, String itemName, int quantity, double price, Bill bill) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.bill = bill;
	}

	public BillItem() {
		super();
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
		BillItem other = (BillItem) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BillItem [id=" + id + ", itemName=" + itemName + ", quantity=" + quantity + ", price=" + price
				+ ", bill=" + bill + "]";
	}
    
    

}
