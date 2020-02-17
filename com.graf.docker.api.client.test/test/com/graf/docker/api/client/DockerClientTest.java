package com.graf.docker.api.client;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.graf.docker.client.builder.DockerClientBuilder;
import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.interfaces.IDockerClient;
import com.graf.docker.client.models.Container;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreation;
import com.graf.docker.client.models.ContainerInfo;
import com.graf.docker.client.models.ContainerUpdate;
import com.graf.docker.client.models.HostConfig;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.params.ListContainersParam;

public class DockerClientTest {

	private IDockerClient docker = DockerClientBuilder.builder().setUrl("http://localhost:2375").build();
	private ContainerConfig config = ContainerConfig.builder().image("ubuntu")
			.cmd("sh", "-c", "while :; do sleep 1; done").build();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDockerClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testListContainers() throws DockerException {
		List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		
		for(Container c : containers) {
			System.out.println(c);
		}
		
		assertEquals(true, containers.isEmpty());
		
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		
		containers = docker.listContainers(ListContainersParam.allContainers());
		assertEquals(false, containers.isEmpty());
		
		docker.removeContainer(containerId);
	}

	@Test
	public void testCreateContainerContainerConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateContainerContainerConfigString() {
		fail("Not yet implemented");
	}

	@Test
	public void testInspectContainer() throws DockerException {

		ContainerInfo info = docker.inspectContainer("f3c43e73d558");

		fail("Not yet implemented");
	}

	@Test
	public void testTopContainerString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTopContainerStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testInspectContainerChanges() {
		fail("Not yet implemented");
	}

	@Test
	public void testExportContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testStatContainerStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testResizeTTYContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopContainerString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);

		assertEquals(true, info.getState().isRunning());

		docker.stopContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertEquals(false, info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringInt() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);

		assertEquals(true, info.getState().isRunning());

		docker.stopContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertEquals(false, info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringIntTimeUnit() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);

		assertEquals(true, info.getState().isRunning());

		docker.stopContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertEquals(false, info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testRestartContainerString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.restartContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringInt() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.restartContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringIntTimeUnit() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.restartContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testKillContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.killContainer(containerId, KillSignal.SIGKILL);

		info = docker.inspectContainer(containerId);
		assertEquals(false, info.getState().isRunning());
		
		docker.removeContainer(containerId);
	}

	@Test
	public void testUpdateContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);
		
		ContainerInfo info = docker.inspectContainer(containerId);
		HostConfig config = info.getHostConfig();
		assertEquals(true, info.getState().isRunning());
		
		ContainerUpdate update = docker.updateContainer(containerId, HostConfig.builder().cpus(5).build());
		
		info = docker.inspectContainer(containerId);
		assertNotEquals(config, info.getHostConfig());
		
		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRenameContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);
		
		ContainerInfo info = docker.inspectContainer(containerId);
		String oldContainerName = info.getName();
		assertEquals(true, info.getState().isRunning());
		
		docker.renameContainer(containerId, "test-docker-name");
		
		creation = docker.createContainer(config);
		String newContainerName = creation.getId();
		
		assertNotEquals(oldContainerName, newContainerName);
		
		docker.stopAndRemoveContainer(containerId);
		
	}

	@Test
	public void testPauseContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());
		
		docker.pauseContainer(containerId);
		
		info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isPaused());
		
		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testUnpauseContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());
		
		docker.pauseContainer(containerId);
		
		info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isPaused());
		
		docker.unpauseContainer(containerId);
		
		info = docker.inspectContainer(containerId);
		assertEquals(false, info.getState().isPaused());
		
		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testWaitForContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testFileInfoContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testArchiveContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testExtractToContainer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteContainers() {
		fail("Not yet implemented");
	}

	@Test
	public void testRunContainerContainerConfig() {
		fail("Not yet implemented");
	}

	@Test
	public void testRunContainerContainerConfigString() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopStatContainerStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testByteArrayToInt() {
		fail("Not yet implemented");
	}

}
