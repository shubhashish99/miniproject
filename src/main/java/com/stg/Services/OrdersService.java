package com.stg.Services;

import java.util.List;

import com.stg.entity.Orders;

public interface OrdersService {
	public abstract Orders checkOrders(int orderId);

	public abstract List<Orders> fetchOrdersList();

	public abstract Orders addOders(Orders orders);

	public abstract List<Orders> searchByOrderId(int orderId);

	public abstract Orders updateOrders(Orders orders);

	public abstract void deleteByOrderId(int orderId);

}