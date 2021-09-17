package com.lucamusic.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForceErrorRestController {

	//Error no mapeado
	@GetMapping(value = "/users/throwException")
	public void throwException() {
		throw new IllegalArgumentException("\"mensaje de error del Rest Controller\"");
	}
}
