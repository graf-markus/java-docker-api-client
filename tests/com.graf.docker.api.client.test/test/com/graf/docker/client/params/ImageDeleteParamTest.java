package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageDeleteParamTest {

	@Test
	public void testForce() {
		ImageDeleteParam param = ImageDeleteParam.force();
		assertEquals("force", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testForceBoolean() {
		ImageDeleteParam param = ImageDeleteParam.force(false);
		assertEquals("force", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testNoprune() {
		ImageDeleteParam param = ImageDeleteParam.noprune();
		assertEquals("noprune", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testNopruneBoolean() {
		ImageDeleteParam param = ImageDeleteParam.noprune(false);
		assertEquals("noprune", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}
}
