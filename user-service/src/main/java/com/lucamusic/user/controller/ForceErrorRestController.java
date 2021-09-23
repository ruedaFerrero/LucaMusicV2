package com.lucamusic.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ForceErrorRestController
 * Controlador de errores del microservicio
 * @author Jose
 * @version 1.0, Septiembre 2021
 *
 */
@RestController
public class ForceErrorRestController {

	//Error no mapeado
	@GetMapping(value = "/users/throwException")
	public void throwException() {
		throw new IllegalArgumentException("\"mensaje de error del Rest Controller\"");
	}
}
