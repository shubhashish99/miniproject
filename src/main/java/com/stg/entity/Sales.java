package com.stg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sales")
public class Sales {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@Id
	private int saleId;

	@Column(updatable = false, nullable = false)
	private float saleAmount;

	@Column(updatable = false, nullable = false)
	private Date saleDate;

	@ManyToOne
	@JsonBackReference(value = "restaurantsales")
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId", nullable = false)
	private Restaurant restaurant;

	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sales(int saleId, float saleAmount, Date saleDate, Restaurant restaurant) {
		super();
		this.saleId = saleId;
		this.saleAmount = saleAmount;
		this.saleDate = saleDate;
		this.restaurant = restaurant;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public float getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(float saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
