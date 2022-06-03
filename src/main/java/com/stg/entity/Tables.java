package com.stg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tables")
public class Tables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableNo;

	@JsonBackReference(value = "restauranttables")
	@ManyToOne
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false)
	private Restaurant restaurant;

	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tables(int tableNo, Restaurant restaurant) {
		super();
		this.tableNo = tableNo;
		this.restaurant = restaurant;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
