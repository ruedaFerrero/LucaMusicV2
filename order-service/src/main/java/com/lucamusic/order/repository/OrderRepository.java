package com.lucamusic.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucamusic.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
