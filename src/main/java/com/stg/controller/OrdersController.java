package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.OrdersService;
import com.stg.entity.Orders;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/checkOrders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> checkOrders(@RequestBody int orderId) {

		Orders orders = ordersService.checkOrders(orderId);

		return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchOrdersList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> fetchOrdersList() {

		List<Orders> orders = ordersService.fetchOrdersList();

		return new ResponseEntity<Orders>((Orders) orders, HttpStatus.OK);
	}

	@PostMapping(value = "/addOrders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> addOrders(@RequestBody Orders orders) {

		Orders orders1 = ordersService.addOders(orders);

		return new ResponseEntity<Orders>(orders1, HttpStatus.OK);
	}

	@GetMapping(value = "/searchByOrderCustomerId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> searchByOrderCustomerId(@RequestBody int orderId) {

		List<Orders> orders = ordersService.searchByOrderId(orderId);

		return new ResponseEntity<Orders>((Orders) orders, HttpStatus.OK);
	}

	@PutMapping(value = "/updateOrders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> updateOrders(@RequestBody Orders orders) {

		Orders orders1 = ordersService.updateOrders(orders);

		return new ResponseEntity<Orders>(orders1, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByOrderId", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> deleteByOrderId(@RequestBody int orderId) {

		ordersService.deleteByOrderId(orderId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
