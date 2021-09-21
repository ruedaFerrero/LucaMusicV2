package com.lucamusic.order.model;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Event
 * Clase entidad del Objeto Event
 * @author Julio
 * @version 1.0 Septiembre 2021
 *
 */
@Data
public class Event {
	@NotNull(message = "El campo nombre debe existir y no ser vacío") @NotBlank
	private String name;
	@NotNull (message = "El campo musicStyle debe existir")
	private String musicStyle;
}
