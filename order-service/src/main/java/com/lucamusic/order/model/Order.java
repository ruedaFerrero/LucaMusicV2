package com.lucamusic.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order
 * Compra de entradas de un evento realizada por el usuario
 * @author Julio
 * @version v1 Septiembre-2021
 */
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Order {
	private String userName;
	private String eventName;
	private String musicStyle;
	private int numTickets;
	private String status;
}
