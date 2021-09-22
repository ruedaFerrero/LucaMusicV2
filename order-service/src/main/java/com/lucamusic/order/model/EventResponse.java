package com.lucamusic.order.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class EventResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String musicStyle;
	
	public static EventResponse of(Event event) {
		EventResponse eventResponse = new EventResponse();
		eventResponse.setName(event.getName());
		eventResponse.setMusicStyle(event.getMusicStyle());
		return eventResponse;
	}

}
