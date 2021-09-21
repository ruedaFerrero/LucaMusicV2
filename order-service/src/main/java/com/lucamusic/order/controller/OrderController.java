package com.lucamusic.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.User;
import com.lucamusic.order.service.OrderService;
import com.lucamusic.order.utils.Utils;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService serv;

	@GetMapping
	public ResponseEntity<Order> createOrder(@RequestBody User user,@RequestBody Event event, BindingResult result) {
		log.info("Creating Order with User {} and Event {}", user,event);
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Order  order = serv.createOrder(user,event);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
	
	



}
