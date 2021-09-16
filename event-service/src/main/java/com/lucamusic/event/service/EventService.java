package com.lucamusic.event.service;

import java.util.List;
import com.lucamusic.event.entity.Event;

public interface EventService {
	public Event createEvent(Event event);
	public Event getEventById(String id);
	public Event deleteEvent(Event event);
	public Event modifyEvent(Event event);
	public List<Event> eventsByStatus(String status);
	public List<Event> findByMusicStyle(String musicStyle);
	public List<Event> findByNameList(String name);
}
