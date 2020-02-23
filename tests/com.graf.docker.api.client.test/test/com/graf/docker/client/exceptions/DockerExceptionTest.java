package com.graf.docker.client.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class DockerExceptionTest {

	@Test
	public void testDockerExceptionString() {
		DockerException e = new DockerException("test message");
		assertEquals("test message", e.getMessage());
	}

	@Test
	public void testDockerExceptionStringInt() {
		DockerException e = new DockerException("test message", 500);
		assertEquals("test message", e.getMessage());
		assertEquals(500, e.getErrorStatusCode());
	}
}
