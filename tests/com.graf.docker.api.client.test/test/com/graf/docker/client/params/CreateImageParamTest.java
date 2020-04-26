package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateImageParamTest {

	@Test
	public void testFromImage() {
		CreateImageParam param = CreateImageParam.fromImage("test");
		assertEquals("fromImage", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testFromSrc() {
		CreateImageParam param = CreateImageParam.fromSrc("test");
		assertEquals("fromSrc", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithRepo() {
		CreateImageParam param = CreateImageParam.repo("test");
		assertEquals("repo", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithTag() {
		CreateImageParam param = CreateImageParam.tag("test");
		assertEquals("tag", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithMessage() {
		CreateImageParam param = CreateImageParam.message("test");
		assertEquals("message", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithPlatform() {
		CreateImageParam param = CreateImageParam.platform("test");
		assertEquals("platform", param.name());
		assertEquals("test", param.value());
	}
}
