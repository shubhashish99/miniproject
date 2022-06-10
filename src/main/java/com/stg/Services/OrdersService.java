package com.stg.Services;

import java.util.List;

import com.stg.entity.Orders;

public interface OrdersService {
	public abstract Orders findOrders(int orderId);

	public abstract List<Orders> fetchOrdersList();

	public abstract Orders addOders(Orders orders);

	public abstract String updateOrders(int orderId, String orderType, String orderDescription);

	public abstract String deleteByOrderId(int orderId);

}