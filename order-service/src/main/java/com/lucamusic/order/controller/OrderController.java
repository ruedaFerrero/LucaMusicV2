package com.lucamusic.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucamusic.order.entity.Order;
import com.lucamusic.order.service.OrderService;
import com.lucamusic.order.service.OrderServiceImpl;
import com.lucamusic.order.utils.Utils;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderServiceImpl serv;
	
	
	@PostMapping
	public ResponseEntity<Order> createOrder( Order order, BindingResult result) {
		
		log.info("Creating Order: {}", order);
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Order  orders = serv.createOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(orders);
		
	}
}
