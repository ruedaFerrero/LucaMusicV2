package com.lucamusic.user.controller.error;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("Error: No existe el usuario");
	}
	
	public UserNotFoundException(Long id) {
		super("Error: No existe el usuario " + id);
	}

}
