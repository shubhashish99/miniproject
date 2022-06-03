package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	public List<Orders> findByOrderId(int orderId);

	public void deleteByOrderId(int orderId);

}
