package com.lucamusic.order.controller;

import com.lucamusic.order.model.OrderInfo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lucamusic.order.model.Order;
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

	private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
                return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
	
	@Secured({"ROLE_USER", 	"ROLE_ADMIN"})
	@GetMapping
	public ResponseEntity<Order> createOrder(@RequestBody OrderInfo info, HttpServletRequest request, BindingResult result) {
	
	
		String extractToken=extractJwtFromRequest(request);
		
		
		//		log.info("Creating Order with User {} and Event {}", info.getUser(),info.getEvent());
		if(result.hasErrors()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Order  order = serv.createOrder(info,extractToken);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}
}
