package com.graf.docker.api.client;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;

import com.graf.docker.client.builder.DockerClientBuilder;
import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.interfaces.IContainerStatsListener;
import com.graf.docker.client.interfaces.IDockerClient;
import com.graf.docker.client.models.Container;
import com.graf.docker.client.models.ContainerChange;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreation;
import com.graf.docker.client.models.ContainerExit;
import com.graf.docker.client.models.ContainerFileInfo;
import com.graf.docker.client.models.ContainerInfo;
import com.graf.docker.client.models.ContainerLog;
import com.graf.docker.client.models.ContainerStats;
import com.graf.docker.client.models.ContainerUpdate;
import com.graf.docker.client.models.ContainersDeletedInfo;
import com.graf.docker.client.models.HostConfig;
import com.graf.docker.client.models.Image;
import com.graf.docker.client.models.ImageClearedCache;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.TopResults;
import com.graf.docker.client.params.CreateImageParam;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.ListImagesParam;
import com.graf.docker.client.params.LogsParam;
import com.graf.docker.client.params.RemoveContainersParam;

public class DockerClientTest {

	private IDockerClient docker = DockerClientBuilder.builder().setUrl("http://localhost:2375").build();
	private ContainerConfig config = ContainerConfig.builder().image("ubuntu")
			.cmd("sh", "-c", "while :; do sleep 1; done").build();

	@After
	public void tearDown() throws Exception {
		List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		for (Container c : containers) {
			docker.removeContainer(c.getId(), RemoveContainersParam.force());
		}
	}

	@Test
	public void testListContainers()  {
		List<Container> containers = null;
		try {
			containers = docker.listContainers(ListContainersParam.allContainers());
		} catch (DockerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertTrue(containers.isEmpty());

		ContainerCreation creation = null;
		try {
			creation = docker.createContainer(config);
		} catch (DockerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String containerId = creation.getId();

		try {
			containers = docker.listContainers(ListContainersParam.allContainers());
		} catch (DockerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(containers.isEmpty());

		try {
			docker.removeContainer(containerId);
		} catch (DockerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateContainerContainerConfig() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		assertTrue(containers.size() > 0);

		assertEquals(creation.getId(), containers.get(0).getId());
	}

	@Test
	public void testCreateContainerContainerConfigString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config, "test-container-name");
		List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		assertTrue(containers.size() > 0);

		assertEquals(creation.getId(), containers.get(0).getId());
		// Docker Engine adds / before Names
		assertEquals("/test-container-name", containers.get(0).getNames()[0]);
	}

	@Test
	public void testInspectContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		ContainerInfo info = docker.inspectContainer(creation.getId());
		assertNotNull(info);
	}

	@Test
	public void testTopContainerString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		TopResults top = docker.topContainer(containerId);
		assertTrue(top.getProcesses().get(0).contains("sh -c while :; do sleep 1; done"));

		docker.stopContainer(containerId);
	}

	@Test
	public void testTopContainerStringString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		TopResults top = docker.topContainer(containerId, "aux");
		assertTrue(top.getProcesses().get(0).contains("sh -c while :; do sleep 1; done"));

		docker.stopContainer(containerId);
	}

	@Test
	public void testLogContainer() throws DockerException {
		ContainerConfig config = ContainerConfig.builder().image("ubuntu")
				.cmd("sh", "-c", "while :; do echo test; sleep 1; done").build();
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerLog log = docker.logContainer(containerId, LogsParam.stdout(), LogsParam.stderr());
		assertTrue(log.getStderrLogs().isEmpty());
		assertTrue(!log.getStdoutLogs().isEmpty());

		docker.stopContainer(containerId);
	}

	@Test
	public void testInspectContainerChanges() throws DockerException {
		ContainerConfig config = ContainerConfig.builder().image("ubuntu").cmd("sh", "-c", "touch test.txt").build();
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		List<ContainerChange> changes = docker.inspectContainerChanges(containerId);
		assertTrue(changes.size() > 0);
		assertTrue(changes.get(0).getKind() == ContainerChange.ADDED);
	}

	@Test
	public void testExportContainer() throws DockerException, IOException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();

		String binary = docker.exportContainer(containerId);

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./export.tar.gz")));
		writer.write(binary);

		assertTrue(Files.exists(Paths.get("./export.tar.gz")));
		assertTrue(Files.size(Paths.get("./export.tar.gz")) > 0);

		Files.delete(Paths.get("./export.tar.gz"));

	}

	@Test
	public void testStatContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerStats stats = docker.statContainer(containerId);

		assertNotNull(stats);
	}

	@Test
	public void testStatContainerStream() throws DockerException, InterruptedException {

		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertEquals(true, info.getState().isRunning());

		docker.statContainerStream(containerId, new IContainerStatsListener() {

			@Override
			public void onContainerStatsReceived(ContainerStats stats) {
				assertNotNull(stats);
			}

			@Override
			public void onClosed(int statusCode, String message) {
				assertEquals(200, statusCode);
			}
		});

		Thread.sleep(5000);

		docker.stopStatContainerStream(containerId);
	}

	@Test
	public void testResizeTTYContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.resizeTTYContainer(containerId, 55, 55);

		docker.stopContainer(containerId);
	}

	@Test
	public void testStartContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);
	}

	@Test
	public void testStopContainerString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringInt() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);

		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringIntTimeUnit() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);

		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testRestartContainerString() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringInt() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringIntTimeUnit() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testKillContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.killContainer(containerId, KillSignal.SIGKILL);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testUpdateContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		HostConfig config = info.getHostConfig();
		assertTrue(info.getState().isRunning());

		ContainerUpdate update = docker.updateContainer(containerId, HostConfig.builder().cpus(1).build());

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
		assertTrue(info.getState().isRunning());

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
		assertTrue(info.getState().isRunning());

		docker.pauseContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isPaused());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testUnpauseContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.pauseContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isPaused());

		docker.unpauseContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isPaused());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testWaitForContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					docker.stopContainer(containerId);
				} catch (DockerException | InterruptedException e) {

				}
			}
		}).start();

		ContainerExit exit = docker.waitForContainer(containerId);
		assertNull(exit.getError());
		assertEquals(137, exit.getStatusCode());
	}

	@Test
	public void testRemoveContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();

		List<Container> containers = docker.listContainers(ListContainersParam.allContainers());
		assertTrue(containsContainer(containers, containerId));

		docker.removeContainer(containerId);
		containers = docker.listContainers(ListContainersParam.allContainers());

		assertFalse(containsContainer(containers, containerId));
	}

	private boolean containsContainer(List<Container> containers, String containerId) {
		for (Container c : containers) {
			if (c.getId().equals(containerId)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testFileInfoContainer() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerFileInfo fileInfo = docker.fileInfoContainer(containerId, "/");

		assertEquals("/", fileInfo.getName());
		assertEquals(4096, fileInfo.getSize());
	}

	@Test
	public void testArchiveContainer() throws DockerException, IOException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
		
		String binary = docker.archiveContainer(containerId, "/");

		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./archive.tar")));
		writer.write(binary);

		assertTrue(Files.exists(Paths.get("./archive.tar")));
		assertTrue(Files.size(Paths.get("./archive.tar")) > 0);

		Files.delete(Paths.get("./archive.tar"));
	}

	@Test
	public void testDeleteContainers() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
		
		docker.stopContainer(containerId);
		
		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());
		
		assertTrue(containsContainer(docker.listContainers(ListContainersParam.allContainers()), containerId));
		
		ContainersDeletedInfo deletedInfo = docker.deleteContainers();
		
		assertFalse(containsContainer(docker.listContainers(ListContainersParam.allContainers()), containerId));
		assertTrue(deletedInfo.getContainersDeleted().length > 0);
		assertTrue(deletedInfo.getContainersDeleted()[0].equals(containerId));
	}

	@Test
	public void testRunContainerContainerConfig() throws DockerException {
		ContainerCreation creation = docker.runContainer(config);
		String containerId = creation.getId();
		
		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
	}

	@Test
	public void testRunContainerContainerConfigString() throws DockerException {
		ContainerCreation creation = docker.runContainer(config, "test");
		String containerId = creation.getId();
		
		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
		// Docker Engine adds / in front of name
		assertEquals("/test", info.getName());
	}

	@Test
	public void testStopStatContainerStream() throws DockerException {
		ContainerCreation creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInfo info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
		
		docker.stopContainer(containerId);
		
		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());
	}
	
	@Test
	public void testListImages() throws DockerException {
		List<Image> images = docker.listImages(ListImagesParam.allImages());
		
		assertTrue(images.size() > 0);
		assertEquals("ubuntu:latest", images.get(0).getRepoTags().get(0));
	}
	
	@Test
	public void testClearBuildCache() throws DockerException {
		ImageClearedCache cleared = docker.clearImageBuildCache();
		
		assertEquals(0, cleared.getSpaceReclaimed());
	}
	
	@Test
	public void testCreateImage() throws DockerException {
		docker.createImage(CreateImageParam.fromImage("debian"), CreateImageParam.withTag("10-slim"));
		
		List<Image> images = docker.listImages(ListImagesParam.withReference("debian"));
		
		assertTrue(images.size() > 0);
		
	}
}
