package com.lucamusic.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order findByUserId(Long id);

	public Order findByEventId(String id);


}
