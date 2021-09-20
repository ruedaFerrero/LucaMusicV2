package com.lucamusic.user.controller.error;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Bad Request Exception (404)";
	
	public BadRequestException() {
		super(DESCRIPTION + ": El servidor no pudo identificar la petición");
	}
	
	public BadRequestException(Long id) {
		super(DESCRIPTION + ": El servidor no pudo identificar la petición");
	}
}