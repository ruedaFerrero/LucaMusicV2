package com.lucamusic.order.model;

import lombok.Data;


/**
 * OrderInfo
 * Información que recibe el microservicio para poder efectuar una compra
 * @author Julio
 * @version v1 Septiembre-2021
 */
@Data
public class OrderInfo {
    private PaymentInfo paymentInfo;
    private int numTickets;
    private String eventId;
    private String userId;
}
