package com.lucamusic.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.User;
import com.lucamusic.order.repository.OrderRepository;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


	@Autowired 
	OrderRepository repo;



	@Override
	public Order createOrder(User user, Event event) {
		Order order = new Order();
		order.setUserId(user.getId());
		order.setEventId(event.getId());
		order.setStatus("CREATED");
		return order;
	}


	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
