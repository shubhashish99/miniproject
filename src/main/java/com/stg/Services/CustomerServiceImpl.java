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
	public Customers checkCustomer(int customerId, String customerName) {

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
	public List<Customers> searchByIdAndCustName(int customerId, String customerName) {

		return (List<Customers>) customersRepository.findByCustomerIdAndCustomerName(customerId, customerName);
	}

	@Override
	public Customers updateCustomer(Customers customers) {

		return customersRepository.save(customers);
	}

	@Override
	public void deleteByCustId(int customerId) {

		customersRepository.deleteByCustomerId(customerId);

	}
}