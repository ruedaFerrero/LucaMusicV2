package com.lucamusic.event;



import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import com.lucamusic.event.controller.EventController;
import com.lucamusic.event.entity.Event;
import com.lucamusic.event.entity.Location;
import com.lucamusic.event.service.EventServiceImpl;



@WebMvcTest(EventController.class)
public class TestGetEventFiltered {

	@MockBean
	private EventServiceImpl serv;

	@Test
	void assertThatEventIsFound() throws Exception{

		String generoInserted = "Music Style";

		Location location = Location.builder()
				.address("a")
				.capacity(5000)
				.name("b")
				.build();
		Event eventCreated = Event.builder()
				.location(location)
				.longDescription("long")
				.shortDescription("short")
				.musicStyle(generoInserted)
				.name("Test01")
				.photoUrl("photoUrl")
				.status("status")
				.ticketsSold(7)
				.build();

		serv.createEvent(eventCreated);
		assertThat(eventCreated.getMusicStyle()).contains(generoInserted);

	}
}