package com.lucamusic.order.controller;

import com.lucamusic.order.model.OrderInfo;
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
/**
 * OrderController
 * Clase Controller del microservicio que redirecciona según las
 * peticiones realizadas
 * 
 * @author Emanuel
 * @version 1.0 Septiembre 2021
 *
 */
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService serv;

	/**
	 * Método para crear un objeto Order nuevo
	 * @param info información del Order
	 * @return respuesta 201, CREATED
	 * @author Emanuel
	 */
	@GetMapping
	public ResponseEntity<Order> createOrder(@RequestBody String eventId, String userId, OrderInfo info, BindingResult result) {
//		log.info("Creating Order with User {} and Event {}", info.getUser(),info.getEvent());
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Order  order = serv.createOrder(eventId, userId, info);
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
}
