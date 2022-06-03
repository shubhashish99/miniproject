package com.stg.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.Exception.CustomException;
import com.stg.entity.Orders;
import com.stg.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders checkOrders(int orderId) {

		Orders orders = (Orders) ordersRepository.findByOrderId(orderId);
		if (orders == null) {

			throw new CustomException("Order not found!");
		} else {
			return orders;
		}
	}

	@Override
	public List<Orders> fetchOrdersList() {

		return ordersRepository.findAll();
	}

	@Override
	public Orders addOders(Orders orders) {

		return ordersRepository.save(orders);
	}

	@Override
	public List<Orders> searchByOrderId(int orderId) {

		return ordersRepository.findByOrderId(orderId);
	}

	@Override
	public Orders updateOrders(Orders orders) {

		return ordersRepository.save(orders);
	}

	@Override
	public void deleteByOrderId(int orderId) {
		ordersRepository.deleteByOrderId(orderId);

	}

}
