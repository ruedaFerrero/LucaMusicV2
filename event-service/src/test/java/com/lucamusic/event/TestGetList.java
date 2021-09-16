//package com.lucamusic.event;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.lucamusic.event.controller.EventController;
//import com.lucamusic.event.entity.Event;
//import com.lucamusic.event.repository.EventRepository;
//import com.lucamusic.event.service.EventService;
//import com.lucamusic.event.service.EventServiceImpl;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(EventController.class)
//public class TestGetList {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@TestConfiguration
//	static class TestGetListConfiguration {
//		@Bean
//		public EventService eventService() {
//			return new EventServiceImpl();
//		}
//	}
//
//	@Autowired
//	private EventService eventService;
//
//	@MockBean
//	private EventRepository eventRepository;
//
//
//	@Test
//	void assertThatListWhenDBIsEmptyWeGetNoResults() throws Exception{
//		List<Event> events = new ArrayList<Event>();
//
//		when(eventService.eventsByStatus("CREATED")).thenReturn(events);
//
//		mockMvc
//			.perform(get("/events"))
//			.andDo(print())
//			.andExpect(status().isNoContent());
//	}
//
//	@Test
//	void assertThatListWhenDBHasItemsWeGeSomeResults() throws Exception{
//		List<Event> events = List.of(new Event(), new Event());
//
//		when(eventService.eventsByStatus("CREATED")).thenReturn(events);
//
//		mockMvc
//				.perform(get("/events"))
//				.andDo(print())
//				.andExpect(status().isOk());
//	}
//}
