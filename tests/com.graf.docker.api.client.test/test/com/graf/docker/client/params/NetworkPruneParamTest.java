package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkPruneParamTest {

	@Test
	public void testUntil() {
		NetworkPruneParam param = NetworkPruneParam.until("test");
		assertEquals("until", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelStringString() {
		NetworkPruneParam param = NetworkPruneParam.label("test", "test");
		assertEquals("label", param.name());
		assertEquals("test=test", param.value());
		
		param = NetworkPruneParam.label("test", "");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testLabelString() {
		NetworkPruneParam param = NetworkPruneParam.label("test");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testNotLabelStringString() {
		NetworkPruneParam param = NetworkPruneParam.notLabel("test", "test");
		assertEquals("label", param.name());
		assertEquals("test!=test", param.value());
	}
}
