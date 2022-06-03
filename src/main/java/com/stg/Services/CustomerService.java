package com.stg.Services;

import java.util.List;

import com.stg.entity.Customers;

public interface CustomerService {

	public abstract Customers checkCustomer(int customerId, String customerName); // validation

	public abstract List<Customers> fetchCustomerList(); // read

	public abstract Customers addCustomer(Customers customer); // add

	public abstract List<Customers> searchByIdAndCustName(int customerId, String customerName); // search

	public abstract Customers updateCustomer(Customers customer); // update

	public abstract void deleteByCustId(int customerId); // delete
}
