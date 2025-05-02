package com.training.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table (name="bills")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_id")
	private int billId;
	
	@Override
	public int hashCode() {
		return Objects.hash(billId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return billId == other.billId;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", customer=" + customer + ", billItems="
				+ billItems + ", billAmount=" + billAmount + ", rewardPoints=" + rewardPoints + "]";
	}

	public Bill() {
		super();
	}

	public Bill(int billId, LocalDate billDate, Customer customer, List<BillItem> billItems, double billAmount,
			int rewardPoints) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.customer = customer;
		this.billItems = billItems;
		this.billAmount = billAmount;
		this.rewardPoints = rewardPoints;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	private LocalDate billDate; 
	
	@ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillItem> billItems;

    private double billAmount;

    private int rewardPoints;
	
	
	
	

}
