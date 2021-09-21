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
import com.lucamusic.order.utils.Utils;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService serv;


	@PostMapping
	public ResponseEntity<Order> createOrder( @Valid @RequestBody Order order, BindingResult result) {

		log.info("Creating Order: {}", order);
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Order  orderdb = serv.createOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderdb);

	}

	//Tipo get
	//le pasamos el usuario, evento, y tarjeta de credito
	//pasa a la capa de servicio

	/*@GetMapping
	public ResponseEntity<Order> validateOrder(@RequestBody O, BindingResult result){

		log.info("Validating oder: {}", user,event);
		
		Order orderDB=serv.validateOrder(user,event);



		return ResponseEntity.ok(orderDB);
		
		//Llamada a guardar 

	}*/

}
