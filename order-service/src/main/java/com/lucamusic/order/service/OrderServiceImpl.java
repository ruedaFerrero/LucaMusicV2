package com.lucamusic.order.service;

import com.lucamusic.order.controller.error.EventNotFoundException;
import com.lucamusic.order.controller.error.UserNotFoundException;
import com.lucamusic.order.model.*;
import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * Creates an order
	 * @param info
	 * @return
	 */
	@SneakyThrows
	@Override
	public Order createOrder(OrderInfo info, String extractToken) {
		HttpHeaders headers= new HttpHeaders();
		headers.add("Authorization", "Bearer " + extractToken);
		HttpEntity<?> request = new HttpEntity<String>(headers);

		final ResponseEntity<User> userResponse = restTemplate.exchange("http://user-service/users/" + info.getUserId(), HttpMethod.GET, request, User.class);
		final ResponseEntity<Event> eventResponse = restTemplate.exchange("http://event-service/events/" + info.getEventId(), HttpMethod.GET, request, Event.class);

		if(!userResponse.hasBody()){
			throw new UserNotFoundException();
		}

		if(!eventResponse.hasBody()){
			throw new EventNotFoundException();
		}

		Event event = eventResponse.getBody();
		User user = userResponse.getBody();
		String operationStatus;

		Order order = Order.builder()
				.eventName(event.getName())
				.musicStyle(event.getMusicStyle())
				.userName(user.getFullName())
				.numTickets(info.getNumTickets())
				.build();

		if(event.getTicketsSold() + info.getNumTickets() <= (event.getLocation().getCapacity())){
			operationStatus = validateOrder(info.getPaymentInfo()).getStatus();
			if(operationStatus.equals("Valid account")){
				order.setStatus("Pago aceptado");
				event.setTicketsSold(event.getTicketsSold() +info.getNumTickets());
				request = new HttpEntity<Event>(event, headers);
				ResponseEntity<Event> response2 = restTemplate.exchange("http://event-service/events/" + info.getEventId(), HttpMethod.PUT, request, Event.class);
				System.out.println(response2.toString());
			} else
				order.setStatus(operationStatus);
		}
		else {
			order.setStatus("No hay entradas suficientes para realizar su compra");
		}

		return order;
	}

	/**
	 * Request a validation to an external payment service
	 * @param paymentInfo Payment information
	 * @return Response
	 */
	@Override
	public PaymentResponse validateOrder(PaymentInfo paymentInfo) {
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://localhost:8050/" , paymentInfo,PaymentResponse.class);
	}
}
