package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.Tables;

public interface TablesRepository extends JpaRepository<Tables, Integer> {

	public Tables findByTableNo(int tableNo);
}
