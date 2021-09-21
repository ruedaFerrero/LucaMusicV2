package com.lucamusic.order.model;

import lombok.Data;

/**
 * PaymentInfo
 * Información que recibe la pasarela de pago
 * @author Julio
 * @version v1 Septiembre-2021
 */
@Data
public class PaymentInfo {
    private String creditCard;
    private String cvv;
    private String creditCardOwner;
}
