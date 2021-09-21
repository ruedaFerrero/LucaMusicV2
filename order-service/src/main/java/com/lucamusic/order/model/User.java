package com.lucamusic.order.model;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
* Nombre de la clase: User
 * Esta clase es la entidad (Objeto Usuario)
 * @author:Emanuel
 * @version: 14/09/2021/v1
 */

@Data
public class User {
	@NotNull(message = "El campo fullName no debe ser vacío")
	String fullName;
}
