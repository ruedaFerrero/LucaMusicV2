package com.lucamusic.order.service;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.OrderInfo;
import com.lucamusic.order.model.User;



public interface OrderService {
	public Order createOrder(OrderInfo info);
	
	
	//public Order validateOrder(User userId, Event eventId);
	//Objecto de order con id user, id evento,num entradas...
	
	//Servicios para verificar el evento y el usuario
}
