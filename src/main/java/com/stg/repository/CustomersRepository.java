package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customers;

@Repository
@EnableJpaRepositories
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

	public List<Customers> findByCustomerName(String customerName);

	public Customers findByCustomerIdAndCustomerName(int customerId, String customerName);

	public void deleteByCustomerId(int customerId);

}
