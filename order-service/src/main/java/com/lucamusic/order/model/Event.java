package com.lucamusic.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.Map;
/**
 * Event
 * Clase entidad del Objeto Event
 * @author Julio
 * @version 1.0 Septiembre 2021
 *
 */
@Data
public class Event {
	
	private String id;
	@NotNull(message = "El campo nombre debe existir y no ser vacío") @NotBlank
	private String name;

	@NotNull (message = "El campo musicStyle debe existir")
	private String musicStyle;
	@PositiveOrZero(message = "El valor debe ser mayor o igual de 0")
	private Integer ticketsSold = 0;

}
