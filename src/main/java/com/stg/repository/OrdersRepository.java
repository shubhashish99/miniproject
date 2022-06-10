package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	public Orders findByOrderId(int orderId);

	public Orders deleteByOrderId(int orderId);

}
