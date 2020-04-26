package com.graf.docker.client.params;

import static org.junit.Assert.*;

import org.junit.Test;

import com.graf.docker.client.params.ListContainersParam.HealthStatus;

public class ListContainersParamTest {

	@Test
	public void testAllContainers() {
		ListContainersParam param = ListContainersParam.all();
		assertEquals("all", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testAllContainersBoolean() {
		ListContainersParam param = ListContainersParam.all(false);
		assertEquals("all", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testLimitContainers() {
		ListContainersParam param = ListContainersParam.limitContainers(5);
		assertEquals("limit", param.name());
		assertEquals("5", param.value());
	}

	@Test
	public void testContainersCreatedSince() {
		ListContainersParam param = ListContainersParam.containersCreatedSince("test");
		assertEquals("since", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testContainersCreatedBefore() {
		ListContainersParam param = ListContainersParam.containersCreatedBefore("test");
		assertEquals("before", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithContainerSizes() {
		ListContainersParam param = ListContainersParam.containerSizes(false);
		assertEquals("size", param.name());
		assertFalse(Boolean.valueOf(param.value()));
	}

	@Test
	public void testWithExitStatus() {
		ListContainersParam param = ListContainersParam.exitStatus(0);
		assertEquals("exited", param.name());
		assertEquals("0", param.value());
	}

	@Test
	public void testWithStatusCreated() {
		ListContainersParam param = ListContainersParam.statusCreated();
		assertEquals("status", param.name());
		assertEquals("created", param.value());
	}

	@Test
	public void testWithStatusRestarting() {
		ListContainersParam param = ListContainersParam.statusRestarting();
		assertEquals("status", param.name());
		assertEquals("restarting", param.value());
	}

	@Test
	public void testWithStatusRunning() {
		ListContainersParam param = ListContainersParam.statusRunning();
		assertEquals("status", param.name());
		assertEquals("running", param.value());
	}

	@Test
	public void testWithStatusPaused() {
		ListContainersParam param = ListContainersParam.statusPaused();
		assertEquals("status", param.name());
		assertEquals("paused", param.value());
	}

	@Test
	public void testWithStatusExited() {
		ListContainersParam param = ListContainersParam.statusExited();
		assertEquals("status", param.name());
		assertEquals("exited", param.value());
	}

	@Test
	public void testWithLabelStringString() {
		ListContainersParam param = ListContainersParam.label("test", "test");
		assertEquals("label", param.name());
		assertEquals("test=test", param.value());
		
		param = ListContainersParam.label("test", "");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithLabelString() {
		ListContainersParam param = ListContainersParam.label("test");
		assertEquals("label", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithImage() {
		ListContainersParam param = ListContainersParam.withImage("ubuntu");
		assertEquals("ancestor", param.name());
		assertEquals("ubuntu", param.value());
	}

	@Test
	public void testWithName() {
		ListContainersParam param = ListContainersParam.withName("test");
		assertEquals("name", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testWithId() {
		ListContainersParam param = ListContainersParam.withId("test");
		assertEquals("id", param.name());
		assertEquals("test", param.value());
	}

	@Test
	public void testIsContainerTask() {
		ListContainersParam param = ListContainersParam.isContainerTask(true);
		assertEquals("is-task", param.name());
		assertTrue(Boolean.valueOf(param.value()));
	}

	@Test
	public void testWithHealth() {
		ListContainersParam param = ListContainersParam.withHealth(HealthStatus.HEALTHY);
		assertEquals("health", param.name());
		assertEquals(HealthStatus.HEALTHY.toString().toLowerCase(), param.value());
	}
}
