package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageSearchParamTest {

	@Test
	public void testLimit() {
		ImageSearchParam param = ImageSearchParam.limit(5);
		assertEquals("limit", param.name());
		assertEquals("5", param.value());
	}

	@Test
	public void testIsAutomated() {
		ImageSearchParam param = ImageSearchParam.isAutomated();
		assertEquals("is-automated", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testIsAutomatedBoolean() {
		ImageSearchParam param = ImageSearchParam.isAutomated(false);
		assertEquals("is-automated", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testIsOfficial() {
		ImageSearchParam param = ImageSearchParam.isOfficial();
		assertEquals("is-official", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testIsOfficialBoolean() {
		ImageSearchParam param = ImageSearchParam.isOfficial(false);
		assertEquals("is-official", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testStars() {
		ImageSearchParam param = ImageSearchParam.stars(5);
		assertEquals("stars", param.name());
		assertEquals("5", param.value());
	}
}
