package com.lucamusic.order.model;

import java.io.Serializable;
import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Nombre de la clase: User
 * Esta clase es la entidad (Objeto Usuario)
 * @author:Emanuel
 * @version: 14/09/2021/v1
 */


@Data
public class User {

	Long id;
	@NotNull(message = "El campo fullName no debe ser vacío")
	String fullName;

}
