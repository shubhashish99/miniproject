package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int customerId;

	private String customerName;

	private String customerEmail;

	private String customerMobile;

	@ManyToOne
	@JsonBackReference(value = "restaurantcustomers")
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false)
	private Restaurant restaurant;

	@JsonManagedReference(value = "customerorders")
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private List<Orders> orders;

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(int customerId, String customerName, String customerEmail, String customerMobile,
			Restaurant restaurant, List<Orders> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerMobile = customerMobile;
		this.restaurant = restaurant;
		this.orders = orders;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
