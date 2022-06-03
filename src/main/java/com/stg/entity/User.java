package com.stg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int userId;

	@NotEmpty(message = "please providsde a UserName")
	@Column(updatable = false, unique = true, nullable = false)
	private String userName;

	@NotEmpty(message = "please providsde a UserPassword")
	@Column(nullable = false)
	private String userPassword;

	@JsonSerialize(contentUsing = MySerializer.class)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
	private Restaurant restaurant;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, @NotEmpty(message = "please providsde a UserName") String userName,
			@NotEmpty(message = "please providsde a UserPassword") String userPassword, Restaurant restaurant) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.restaurant = restaurant;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
