package com.lucamusic.event.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
/**
 * Location
 * Clase entidad del Objeto Location
 * @author Julio
 * @version 1.0 Septiembre 2021
 * 
 */
@Data @Builder
public class Location implements Serializable {
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull @PositiveOrZero
	private Integer capacity;
}
