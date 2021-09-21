package com.lucamusic.order.model;

import lombok.Data;

@Data
public class PaymentInfo {
    private String creditCard;
    private String cvv;
    private String fullName;
}
