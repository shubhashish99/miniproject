package com.stg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Customers;
import com.stg.repository.CustomersRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomersRepository customersRepository;

	@Override
	public Customers findCustomer(int customerId, String customerName) {

		Customers customers = customersRepository.findByCustomerIdAndCustomerName(customerId, customerName);

		if (customers == null) {

			throw new CustomException("Customer Not Found !");

		} else {

			return customers;
		}
	}

	@Override
	public List<Customers> fetchCustomerList() {

		return customersRepository.findAll();

	}

	@Override
	public Customers addCustomer(Customers customers) {
		return customersRepository.save(customers);
	}

	@Override
	public String updateCustomer(int customerId, String customerName, String customerEmail, String customerMobile) {

		Customers customers = customersRepository.findByCustomerId(customerId);
		if (customers != null) {
			customers.setCustomerName(customerName);
			customers.setCustomerEmail(customerEmail);
			customers.setCustomerMobile(customerMobile);
			customersRepository.save(customers);
			return "Customer details updated!";
		} else {

			throw new CustomException("customer not found!");
		}

	}

	@Override
	public String deleteByCustomerId(int customerId) {
		Customers customers = customersRepository.findByCustomerId(customerId);
		if (customers != null) {
			customersRepository.delete(customers);
			return "customer is deleted!";
		} else {
			throw new CustomException("customer is not found!");
		}

	}
}