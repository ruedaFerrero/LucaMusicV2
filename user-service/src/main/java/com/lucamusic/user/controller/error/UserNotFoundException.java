package com.lucamusic.user.controller.error;

/**
 * UserNotFoundException
 * Clase que trata el error 404: User no encontrado
 * 
 * @author Jose Antonio
 * @version 1.0, Septiembre 1.0
 *
 */
public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found Exception (404)";
	
	public UserNotFoundException() {
		super(DESCRIPTION + ": No se encontró el usuario");
	}
	
	public UserNotFoundException(Long id) {
		super(DESCRIPTION + ": No se encontró el usuario " + id);
	}

}
