package com.lucamusic.event.controller;

import java.util.List;

import com.lucamusic.event.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.event.controller.error.EventNotFoundException;
import com.lucamusic.event.entity.Event;
import com.lucamusic.event.service.EventService;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

/**
 * EventController Clase Controller del microservicio, redirecciona según las
 * peticiones realizadas por el cliente.
 * 
 * @version 1.0 Septiembre 2021
 * @author Jose Antonio, Edgar
 */

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService serv;

	/**
	 * Metodo para recuperar un listado de eventos fintrando por parámetros o el listado completo
	 * 
	 * @param musicStyle 
	 * @param name
	 * @return List<Event>
	 * @author Jose Antonio
	 */

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@GetMapping
	public ResponseEntity<List<Event>> getEvents(@RequestParam (required = false, name = "musicStyle")String musicStyle, @RequestParam (required = false, name = "name")String name ) {
		log.info("Fetching all Events");
		List<Event> events;
		if(musicStyle != null && name != null) {
			events = serv.findAllFiltered(name, musicStyle);
		}else if (name != null){
			events = serv.eventsFilteredByName(name);
		}else if (musicStyle != null) {
			events = serv.findByMusicStyle(musicStyle);
		}else {
			events = serv.eventsByStatus("CREATED");
		}

		if (events.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(events);
	}

	/**
	 * Metodo para recuperar un evento por id
	 * 
	 * @param String id
	 * @return Event
	 * @author Jose Antonio
	 */
	@Secured({"ROLE_USER", 	"ROLE_ADMIN"})
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable("id") String id) {
		log.info("Fetching Event with id {}", id);
		Event event = serv.getEventById(id);
		if (event == null) {
			log.error("Event with id {} not found", id);
//			return ResponseEntity.notFound().build();
			throw new EventNotFoundException();
		}
		return ResponseEntity.ok(event);
	}

	/**
	 * Metodo para crear un nuevo evento
	 * 
	 * @param event Event
	 * @return respuesta 201, CREATED
	 * @author Jose Antonio
	 */
	@Secured("ROLE_ADMIN")
	@PostMapping
	public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event, BindingResult result) {
		log.info("Creating Event: {}", event);
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		Event eventDB = serv.createEvent(event);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventDB);
	}

	/**
	 * Metodo para modificar un evento
	 * 
	 * @param event Event
	 * @return ResponseEntity 200, OK
	 * @author Edgar
	 */
	@Secured("ROLE_ADMIN")
	@PutMapping("/{id}")
	public ResponseEntity<Event> modifyEvent(@PathVariable("id") String id, @Valid @RequestBody Event event, BindingResult result) {
		log.info("Updating with id {}", id);
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Utils.formatBindingResult(result));
		}
		event.setId(id);
		Event eventUpdated = serv.modifyEvent(event);
		if (eventUpdated == null) {
			log.error("Unable to update. No Event with id {}", id);
			throw new EventNotFoundException();
		}
		return ResponseEntity.ok(eventUpdated);
	}

	/**
	 * Metodo para eliminar un evento
	 * 
	 * @param String Event
	 * @return ResponseEntity 200, OK
	 * @author Edgar
	 */
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") String id) {
		log.info("Fetching and deleting Event with id {}", id);
		Event eventDeleted = serv.getEventById(id);
		if (eventDeleted == null) {
			log.error("Unable to delete. No Event with id {}", id);
			throw new EventNotFoundException();
		}
		eventDeleted = serv.deleteEvent(eventDeleted);
		return ResponseEntity.ok(eventDeleted);
	}
}
