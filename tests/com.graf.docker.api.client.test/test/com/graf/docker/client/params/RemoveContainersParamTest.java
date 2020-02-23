package com.graf.docker.client.params;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RemoveContainersParamTest {

	@Test
	public void testRemoveVolumes() {
		RemoveContainersParam param = RemoveContainersParam.removeVolumes();
		assertEquals("v", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testRemoveVolumesBoolean() {
		RemoveContainersParam param = RemoveContainersParam.removeVolumes(false);
		assertEquals("v", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testForce() {
		RemoveContainersParam param = RemoveContainersParam.force();
		assertEquals("force", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testForceBoolean() {
		RemoveContainersParam param = RemoveContainersParam.force(false);
		assertEquals("force", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testRemoveLink() {
		RemoveContainersParam param = RemoveContainersParam.removeLink();
		assertEquals("link", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testRemoveLinkBoolean() {
		RemoveContainersParam param = RemoveContainersParam.removeLink(false);
		assertEquals("link", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}
}
