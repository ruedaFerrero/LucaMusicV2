package com.lucamusic.order.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucamusic.order.entity.Order;
import com.lucamusic.order.repository.OrderRepository;

public class OrderServiceImpl {


	@Autowired 
	OrderRepository repo;

	public Order createOrder(Order order) {
		Order orders=repo.getById(order.getId());
		if(order!=null) {
			return orders;
		}
		order.setStatus("CREATED");
		return repo.save(order);
	}

	
	public Order validateOrder(Order order) {
		return order;
		
	}
}
