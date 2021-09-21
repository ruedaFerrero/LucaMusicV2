package com.lucamusic.order.service;

import com.lucamusic.order.model.Event;
import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.OrderInfo;
import com.lucamusic.order.model.User;
import com.lucamusic.order.model.PaymentResponse;
import com.lucamusic.order.model.PaymentInfo;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	/**
	 * Creates an order
	 * @param info
	 * @return
	 */
	@SneakyThrows
	@Override
	public Order createOrder(OrderInfo info) {
		User user = info.getUser();
		Event event = info.getEvent();
		Order order = Order.builder()
				.eventName(event.getName())
				.musicStyle(event.getMusicStyle())
				.userName(user.getFullName())
				.numTickets(info.getNumTickets())
				.build();

		String operationStatus = validateOrder(info.getPaymentInfo()).getStatus();
		if(operationStatus.equals("Valid account")){
			order.setStatus("Pago aceptado");
		} else
			order.setStatus(operationStatus);
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
		return restTemplate.postForObject("http://localhost:8050/", paymentInfo, PaymentResponse.class);
	}
}
