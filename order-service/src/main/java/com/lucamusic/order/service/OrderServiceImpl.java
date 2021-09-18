package com.lucamusic.order.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.order.entity.Order;
import com.lucamusic.order.repository.OrderRepository;

@Service
public class OrderServiceImpl {


	@Autowired 
	OrderRepository repo;

	public Order createOrder(Order order) {
		Order orders;
		if(order.getId()!=null) {
			orders=repo.getById(order.getId());
			if(orders!=null) {
				return orders;
			}
		}
		
		order.setStatus("CREATED");
		return repo.save(order);
	}

	
	
}
