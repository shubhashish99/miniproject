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
	public Orders findOrders(int orderId) {

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
	public String updateOrders(int orderId, String orderType, String orderDescription) {

		Orders orders = ordersRepository.findByOrderId(orderId);
		if (orders != null) {

			orders.setOrderType(orderType);
			orders.setOrderDescription(orderDescription);
			return "Order details are updated!";

		} else {
			throw new CustomException("Order not found!");
		}
	}

	@Override
	public String deleteByOrderId(int orderId) {
		Orders orders = ordersRepository.findByOrderId(orderId);
		if (orders != null) {
			ordersRepository.delete(orders);
			return "order is deleted!";
		} else {
			throw new CustomException("Order not found!");
		}

	}

}
