package com.graf.docker.client.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

public class ExceptionMessageTest {

	@Test
	public void testGetMessage() {
		ExceptionMessage message = new Gson().fromJson("{message: test}", ExceptionMessage.class);
		assertEquals("test", message.getMessage());
	}
}
