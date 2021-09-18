package com.lucamusic.user.controller.error;

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
