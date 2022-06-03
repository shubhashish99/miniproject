package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@Id
	private int restaurantId;

	@NotEmpty(message = "Restaurant name is required !")
	private String restaurantName;

	private String restaurantType;

	@OneToOne(mappedBy = "restaurant")
	private User user;

	@JsonManagedReference(value = "restaurantcustomers")
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Customers> customers;

	@JsonManagedReference(value = "restaurantorders")
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Orders> orders;

	@JsonManagedReference(value = "restaurantemployees")
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Employees> employees;

	@JsonManagedReference(value = "restauranttables")
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private List<Tables> tables;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int restaurantId, @NotEmpty(message = "Restaurant name is required !") String restaurantName,
			String restaurantType, User user, List<Customers> customers, List<Orders> orders, List<Employees> employees,
			List<Tables> tables) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantType = restaurantType;
		this.user = user;
		this.customers = customers;
		this.orders = orders;
		this.employees = employees;
		this.tables = tables;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantType() {
		return restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public List<Tables> getTables() {
		return tables;
	}

	public void setTables(List<Tables> tables) {
		this.tables = tables;
	}

}
