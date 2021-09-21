package com.lucamusic.order.service;

import com.lucamusic.order.entity.Order;



public interface OrderService {

	public Order findById(Long id);
	public Order createOrder(Order order);
	//public Order validateOrder(User userId, Event eventId);
	//Objecto de order con id user, id evento,num entradas...
	
	//Servicios para verificar el evento y el usuario
}
