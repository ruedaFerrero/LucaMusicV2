package com.lucamusic.order.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Order {


	private String userName;
	private String eventName;
	private String musicStyle;
	private int numTickets;

}
