package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@NotEmpty(message = "customer order id is required !")
	private int orderId;

	private String orderType;

	private int orderNumber;

	private String orderDescription;

	@ManyToOne
	@JsonBackReference(value = "restaurantorders")
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false)
	private Restaurant restaurant;

	@ManyToOne
	@JsonBackReference("customerorders")
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customers customers;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(@NotEmpty(message = "customer order id is required !") int orderId, String orderType, int orderNumber,
			String orderDescription, Restaurant restaurant, Customers customers) {
		super();
		this.orderId = orderId;
		this.orderType = orderType;
		this.orderNumber = orderNumber;
		this.orderDescription = orderDescription;
		this.restaurant = restaurant;
		this.customers = customers;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

}
