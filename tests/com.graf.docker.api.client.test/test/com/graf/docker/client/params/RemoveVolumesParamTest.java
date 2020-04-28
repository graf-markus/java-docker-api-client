package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveVolumesParamTest {

	@Test
	public void testLabelStringString() {
		RemoveVolumesParam param = RemoveVolumesParam.label("test", "test");
		assertEquals("label", param.name());
		assertEquals("test=test", param.value());

		param = RemoveVolumesParam.label("test", "");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelString() {
		RemoveVolumesParam param = RemoveVolumesParam.label("test");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testNotLabel() {
		RemoveVolumesParam param = RemoveVolumesParam.notLabel("test", "test");
		assertEquals("label", param.name());
		assertEquals("test!=test", param.value());
	}
}
