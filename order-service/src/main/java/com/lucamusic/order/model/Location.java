package com.lucamusic.order.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class Location {

	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull @PositiveOrZero
	private Integer capacity;
}
