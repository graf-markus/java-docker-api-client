package com.graf.docker.client.params;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LogsParamTest {

	@Test
	public void testFollow() {
		LogsParam param = LogsParam.follow();
		assertEquals("follow", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testFollowBoolean() {
		LogsParam param = LogsParam.follow(false);
		assertEquals("follow", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testStdout() {
		LogsParam param = LogsParam.stdout();
		assertEquals("stdout", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testStdoutBoolean() {
		LogsParam param = LogsParam.stdout(false);
		assertEquals("stdout", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testStderr() {
		LogsParam param = LogsParam.stderr();
		assertEquals("stderr", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testStderrBoolean() {
		LogsParam param = LogsParam.stderr(false);
		assertEquals("stderr", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testSince() {
		LogsParam param = LogsParam.since(1582477260);
		assertEquals("since", param.name());
		assertEquals("1582477260", param.value());
	}

	@Test
	public void testUntil() {
		Date d = new Date();
		LogsParam param = LogsParam.until(d);
		assertEquals("until", param.name());
		assertEquals(d.toString(), param.value());
	}

	@Test
	public void testTimestamps() {
		LogsParam param = LogsParam.timestamps();
		assertEquals("timestamps", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testTimestampsBoolean() {
		LogsParam param = LogsParam.timestamps(false);
		assertEquals("timestamps", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testTail() {
		LogsParam param = LogsParam.tail(15);
		assertEquals("tail", param.name());
		assertEquals("15", param.value());
	}
}
