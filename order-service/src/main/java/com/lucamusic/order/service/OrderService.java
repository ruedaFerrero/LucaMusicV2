package com.lucamusic.order.service;

import com.lucamusic.order.model.Order;
import com.lucamusic.order.model.OrderInfo;
import com.lucamusic.order.model.PaymentInfo;
import com.lucamusic.order.model.PaymentResponse;

public interface OrderService {
	public Order createOrder(String eventId, String userId, OrderInfo info);
	public PaymentResponse validateOrder(PaymentInfo paymentInfo);
}
