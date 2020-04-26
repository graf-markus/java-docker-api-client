package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageTagParamTest {

	@Test
	public void testRepo() {
		ImageTagParam param = ImageTagParam.repo("test");
		assertEquals("repo", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testNewTag() {
		ImageTagParam param = ImageTagParam.newTag("test");
		assertEquals("tag", param.name());
		assertEquals("test", param.value());
	}
}
