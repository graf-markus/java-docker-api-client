package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListImageParamTest {

	@Test
	public void testAll() {
		ListImagesParam param = ListImagesParam.all();
		assertEquals("all", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testAllBoolean() {
		ListImagesParam param = ListImagesParam.all(false);
		assertEquals("all", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testShowDigests() {
		ListImagesParam param = ListImagesParam.showDigests();
		assertEquals("digests", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testShowDigestsBoolean() {
		ListImagesParam param = ListImagesParam.showDigests(false);
		assertEquals("digests", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testImageCreatedBefore() {
		ListImagesParam param = ListImagesParam.imageCreatedBefore("test");
		assertEquals("before", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testDangling() {
		ListImagesParam param = ListImagesParam.dangling();
		assertEquals("dangling", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testDanglingBoolean() {
		ListImagesParam param = ListImagesParam.dangling(false);
		assertEquals("dangling", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testLabelStringString() {
		ListImagesParam param = ListImagesParam.label("test", "test");
		assertEquals("label", param.name());
		assertEquals("test=test", param.value());
		
		param = ListImagesParam.label("test", "");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelString() {
		ListImagesParam param = ListImagesParam.label("test");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testReference() {
		ListImagesParam param = ListImagesParam.reference("test");
		assertEquals("reference", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testImageCreatedSince() {
		ListImagesParam param = ListImagesParam.imageCreatedSince("test");
		assertEquals("since", param.name());
		assertEquals("test", param.value());
	}

}
