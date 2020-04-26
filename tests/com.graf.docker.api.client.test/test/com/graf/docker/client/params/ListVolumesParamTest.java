package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListVolumesParamTest {

	@Test
	public void testDangling() {
		ListVolumesParam param = ListVolumesParam.dangling();
		assertEquals("dangling", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testDanglingBoolean() {
		ListVolumesParam param = ListVolumesParam.dangling(false);
		assertEquals("dangling", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testDriver() {
		ListVolumesParam param = ListVolumesParam.driver("test");
		assertEquals("driver", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testNameString() {
		ListVolumesParam param = ListVolumesParam.name("test");
		assertEquals("name", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelStringString() {
		ListVolumesParam param = ListVolumesParam.label("test", "test");
		assertEquals("label", param.name());
		assertEquals("test:test", param.value());

		param = ListVolumesParam.label("test", "");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelString() {
		ListVolumesParam param = ListVolumesParam.label("test");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}
}
