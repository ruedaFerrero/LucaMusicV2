package com.lucamusic.user.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Nombre de la clase: User
 Esta clase es la entidad (Objeto Usuario)
 * @author:Emanuel
 * @version: 14/09/2021/v1
 */

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "El campo fullName no debe ser vacío") @NotEmpty
	private String fullName;
	@Email(message = "El email debe tener un buen formato") @NotNull(message = "El campo email no debe ser vacío") @NotEmpty
	private String email;
	@NotNull(message = "El campo password no debe ser vacío") @NotEmpty
	private String password;
	private LocalDate registerDate;
	private String status;
	private String role;
}
