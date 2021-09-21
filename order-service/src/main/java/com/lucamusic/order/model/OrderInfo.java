package com.lucamusic.order.model;

import lombok.Data;

@Data
public class OrderInfo {
    private User user;
    private Event event;
    private PaymentInfo paymentInfo;
    private int numTickets;
}
