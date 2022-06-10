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

import com.stg.Services.CustomerService;
import com.stg.entity.Customers;

@RestController
@RequestMapping(value = "customer")
@CrossOrigin("http://localhost:4200/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/findCustomer/{customerId}/{customerName}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> findCustomer(@PathVariable int customerId, @PathVariable String customerName) {

		Customers customers = customerService.findCustomer(customerId, customerName);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@GetMapping(value = "/fetchCustomerList", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> fetchCustomerList() {
		List<Customers> customers = customerService.fetchCustomerList();

		return new ResponseEntity<Customers>((Customers) customers, HttpStatus.OK);
	}

	@PostMapping(value = "/addCustomer", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer) {

		Customers customers = customerService.addCustomer(customer);

		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@PutMapping(value = "/updateCustomer/{customerId}/{customerName}/{customerEmail}/{customerMobile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCustomer(@PathVariable int customerId, @PathVariable String customerName,
			@PathVariable String customerEmail, @PathVariable String customerMobile) {

		String customers = customerService.updateCustomer(customerId, customerName, customerEmail, customerMobile);

		return new ResponseEntity<String>(customers, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteByCustomerId", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteByCustomerId(@PathVariable int customerId) {

		String customer = customerService.deleteByCustomerId(customerId);

		return new ResponseEntity<String>(customer, HttpStatus.OK);
	}
}