package com.lucamusic.order.model;

import lombok.Data;

/**
 * Nombre de la clase: PaymentResponse
 * Status recibido de la pasarela de pago
 * @author Julio
 * @version v1 Septiembre-2021
 */
@Data
public class PaymentResponse {
    private String status;
}
