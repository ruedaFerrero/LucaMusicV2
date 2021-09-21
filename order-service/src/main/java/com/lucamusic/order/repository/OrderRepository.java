package com.lucamusic.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.lucamusic.order.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	//User getUserById(User userId);
	//Event getEventById(Event  eventId);

	

	



}
