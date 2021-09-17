package com.lucamusic.event.controller.error;

public class EventNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Not Found Exception (404)";
	
	public EventNotFoundException() {
		super(DESCRIPTION + ": No se encontró el evento");
	}
	
	public EventNotFoundException(Long id) {
		super(DESCRIPTION + ": No se encontró el evento " + id);
	}
}
