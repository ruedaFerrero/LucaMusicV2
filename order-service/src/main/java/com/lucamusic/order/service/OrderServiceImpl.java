package com.lucamusic.order.service;

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
	public Order createOrder(User user, Event event) {
		Order order = new Order();
		order.setUserName(user.getFullName());
		order.setEventName(event.getName());
		order.setMusicStyle(event.getMusicStyle());
		order.setNumTickets(event.getTicketsSold());
		System.out.println(order);
		return order;
	}


	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
