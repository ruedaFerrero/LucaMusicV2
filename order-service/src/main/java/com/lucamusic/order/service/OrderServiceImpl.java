package com.lucamusic.order.service;

import com.lucamusic.order.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.User;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Order createOrder(OrderInfo info) {
		User user = info.getUser();
		Event event = info.getEvent();
		Order order = Order.builder()
				.eventName(event.getName())
				.musicStyle(event.getMusicStyle())
				.userName(user.getFullName())
				.numTickets(info.getNumTickets())
				.build();

		return order;
	}
}
