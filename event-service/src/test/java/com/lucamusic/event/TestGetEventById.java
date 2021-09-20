package com.lucamusic.event;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.lucamusic.event.controller.EventController;
import com.lucamusic.event.entity.Event;
import com.lucamusic.event.entity.Location;
import com.lucamusic.event.repository.EventRepository;
import com.lucamusic.event.service.EventService;
import com.lucamusic.event.service.EventServiceImpl;


@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class TestGetEventById {

	@Autowired
	private EventService serv;
	
	@TestConfiguration
    static class configuration{
		@Bean
	    public EventService eventService() {
	        return new EventServiceImpl();
	    }
	}
	
	@MockBean
    private EventRepository repository;
	
	@BeforeEach
	public void setUp() {
		
	String idInserted = "001";
	Optional<Event> eventOptional ;
	
		Location location = Location.builder()
				.address("a")
				.capacity(5000)
				.name("b")
				.build();
		Event eventCreated = Event.builder()
				.id(idInserted)
				.location(location)
				.shortDescription("shordfdf")
				.musicStyle("genre")
				.name("Test01")
				.photoUrl("photoUrl")
				.build();
		
		eventOptional = Optional.of(eventCreated);
	   
		Mockito.when(repository.findById(idInserted)).thenReturn(eventOptional); 
	}

	@Test
	void assertThatEventIsFound() throws Exception{

		String idInserted = "001";
			
	Event  eventOut = serv.getEventById(idInserted);
		
			assertThat(eventOut.getId()).contains(idInserted);

	}
}