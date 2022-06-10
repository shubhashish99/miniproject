package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customers;

@Repository
@EnableJpaRepositories
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	public Customers findByCustomerId(int customerId);

	public Customers findByCustomerIdAndCustomerName(int customerId, String customerName);

}
