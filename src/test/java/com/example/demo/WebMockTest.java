package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import services.UserServiceImpl;

public class WebMockTest {

	@MockBean
	private UserServiceImpl service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.greet()).thenReturn("Hello, world");
	}
}