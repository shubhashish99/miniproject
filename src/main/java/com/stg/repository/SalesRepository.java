package com.stg.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

	public Sales findBySaleDate(Date saleDate);

	public Sales findBySaleId(int saleId);

}
