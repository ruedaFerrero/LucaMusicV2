package com.lucamusic.order.service;

import com.lucamusic.order.entity.Order;


public interface OrderService {

	public Order findById(Long id);
	public Order createOrder(Order order);
	public Order validateOrder(Order order);
}
