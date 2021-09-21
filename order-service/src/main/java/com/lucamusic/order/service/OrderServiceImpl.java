package com.lucamusic.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.order.entity.Order;
import com.lucamusic.order.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


	@Autowired 
	OrderRepository repo;


	public Order createOrder(Order order) {
	
		order.setStatus("CREATED");
		return repo.save(order);

	}


	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public Order validateOrder(User userId, Event eventId) {

		User userDB=repo.getUserById(userId.getUserId());

		Event eventDB=repo.getEventById(eventId.getEventId());)


		return null;
	}*/

}
