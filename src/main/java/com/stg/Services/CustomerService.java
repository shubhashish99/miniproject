package com.stg.Services;

import java.util.List;

import com.stg.entity.Customers;

public interface CustomerService {

	public abstract Customers findCustomer(int customerId, String customerName); // validation

	public abstract List<Customers> fetchCustomerList(); // read

	public abstract Customers addCustomer(Customers customer); // add

	public abstract String updateCustomer(int customerId, String customerName, String customerEmail,
			String customerMobile); // update

	public abstract String deleteByCustomerId(int customerId); // delete
}
