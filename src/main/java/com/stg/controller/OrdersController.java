package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.Services.OrdersService;
import com.stg.entity.Orders;

@RestController
@RequestMapping(value = "orders")
@CrossOrigin("http://localhost:4200/")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/findOrders/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> findOrders(@PathVariable int orderId) {

		Orders orders = ordersService.findOrders(orderId);

		return new ResponseEntity<Orders>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchOrdersList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> fetchOrdersList() {

		List<Orders> orders = ordersService.fetchOrdersList();

		return new ResponseEntity<Orders>((Orders) orders, HttpStatus.OK);
	}

	@PostMapping(value = "/addOrders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> addOrders(@RequestBody Orders orders) {

		Orders orders1 = ordersService.addOders(orders);

		return new ResponseEntity<Orders>(orders1, HttpStatus.OK);
	}

	@PutMapping(value = "/updateOrders/{orderId}/{orderType}/{orderDescription}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateOrders(@PathVariable int orderId, @PathVariable String orderType,
			@PathVariable String orderDescription) {

		String orders = ordersService.updateOrders(orderId, orderType, orderDescription);

		return new ResponseEntity<String>(orders, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByOrderId/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteByOrderId(@PathVariable int orderId) {

		String orders = ordersService.deleteByOrderId(orderId);

		return new ResponseEntity<String>(orders, HttpStatus.OK);
	}

}
