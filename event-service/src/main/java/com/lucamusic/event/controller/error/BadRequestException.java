package com.lucamusic.event.controller.error;

/**
 * BadRequestException
 * Clase que personaliza el mensaje de error para BAD_REQUEST
 * 
 * @author Jose Antonio
 * @version 1.0 Septiembre 2021
 *
 */
public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Bad Request Exception (400)";
	
	public BadRequestException() {
		super(DESCRIPTION + ": El servidor no pudo identificar la petición");
	}
}
