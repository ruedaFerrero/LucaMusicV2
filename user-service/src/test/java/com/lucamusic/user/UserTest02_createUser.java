//package com.lucamusic.user;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.lucamusic.user.controller.UserController;
//import com.lucamusic.user.entity.User;
//import com.lucamusic.user.service.UserServiceImpl;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(UserController.class)
//public class UserTest02_createUser {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private UserServiceImpl serv;
//
//	@Test
//	void assertUserIsCreated() throws Exception {
//		User user = new User(1L, "Pepe", "pepe@gmail.com", "qqq", LocalDate.of(2020, 10, 10), "CREATED");
//
//		when(serv.createUser(user)).thenReturn(user);
//
//		mockMvc
//		.perform(post("/users"))
//		.andDo(print())
//		.andExpect(status().isOk());
//	}
//}
//