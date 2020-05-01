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
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Test;

import com.graf.docker.client.builder.DockerClientBuilder;
import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.interfaces.IContainerStatsListener;
import com.graf.docker.client.interfaces.IDockerClient;
import com.graf.docker.client.interfaces.IExecResponseListener;
import com.graf.docker.client.models.ContainerSummary;
import com.graf.docker.client.models.ContainerChangeResponseItem;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreateResponse;
import com.graf.docker.client.models.ContainerWaitResponse;
import com.graf.docker.client.models.ExecConfig;
import com.graf.docker.client.models.ExecInspectResponse;
import com.graf.docker.client.models.ExecResponse;
import com.graf.docker.client.models.ExecStartConfig;
import com.graf.docker.client.models.ContainerFileInfo;
import com.graf.docker.client.models.ContainerInspectResponse;
import com.graf.docker.client.models.ContainerLog;
import com.graf.docker.client.models.ContainerStats;
import com.graf.docker.client.models.ContainerUpdateResponse;
import com.graf.docker.client.models.ContainerPruneResponse;
import com.graf.docker.client.models.HostConfig;
import com.graf.docker.client.models.IdResponse;
import com.graf.docker.client.models.ImageSummary;
import com.graf.docker.client.models.BuildPruneResponse;
import com.graf.docker.client.models.ImageDeleteResponseItem;
import com.graf.docker.client.models.ImagePruneResponse;
import com.graf.docker.client.models.HistoryResponseItem;
import com.graf.docker.client.models.Image;
import com.graf.docker.client.models.ImageSearchResponseItem;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.Network;
import com.graf.docker.client.models.NetworkConfig;
import com.graf.docker.client.models.NetworkCreateResponse;
import com.graf.docker.client.models.NetworkPruneResponse;
import com.graf.docker.client.models.SystemDataUsageResponse;
import com.graf.docker.client.models.SystemInfo;
import com.graf.docker.client.models.SystemVersionResponse;
import com.graf.docker.client.models.Volume;
import com.graf.docker.client.models.VolumeConfig;
import com.graf.docker.client.models.VolumeListResponse;
import com.graf.docker.client.models.ContainerTopResponse;
import com.graf.docker.client.params.CreateImageParam;
import com.graf.docker.client.params.ImageTagParam;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.ListImagesParam;
import com.graf.docker.client.params.LogsParam;
import com.graf.docker.client.params.NetworkPruneParam;
import com.graf.docker.client.params.RemoveContainersParam;

public class DockerClientTest {

	private static final Logger LOGGER = Logger.getLogger(DockerClientBuilder.class.getName());
	private IDockerClient docker = DockerClientBuilder.builder().setUrl("http://localhost:2375").build();
	private ContainerConfig config = ContainerConfig.builder().image("ubuntu")
			.cmd("sh", "-c", "while :; do sleep 1; done").build();

	@After
	public void tearDown() throws Exception {
		List<ContainerSummary> containers = docker.listContainers(ListContainersParam.all());
		for (ContainerSummary c : containers) {
			docker.removeContainer(c.getId(), RemoveContainersParam.force());
		}
	}

	@Test
	public void testListContainers() throws DockerException {
		LOGGER.log(Level.INFO, "");
		List<ContainerSummary> containers = null;

		containers = docker.listContainers(ListContainersParam.all());

		assertTrue(containers.isEmpty());

		ContainerCreateResponse creation = null;

		creation = docker.createContainer(config);

		String containerId = creation.getId();

		containers = docker.listContainers(ListContainersParam.all());

		assertFalse(containers.isEmpty());
		docker.removeContainer(containerId);

	}

	@Test
	public void testCreateContainerContainerConfig() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		List<ContainerSummary> containers = docker.listContainers(ListContainersParam.all());
		assertTrue(containers.size() > 0);

		assertEquals(creation.getId(), containers.get(0).getId());
	}

	@Test
	public void testCreateContainerContainerConfigString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config, "test-container-name");
		List<ContainerSummary> containers = docker.listContainers(ListContainersParam.all());
		assertTrue(containers.size() > 0);

		assertEquals(creation.getId(), containers.get(0).getId());
		// Docker Engine adds / before Names
		assertEquals("/test-container-name", containers.get(0).getNames().get(0));
	}

	@Test
	public void testInspectContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		ContainerInspectResponse info = docker.inspectContainer(creation.getId());
		assertNotNull(info);
	}

	@Test
	public void testTopContainerString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerTopResponse top = docker.topContainer(containerId);
		assertTrue(top.getProcesses().get(0).contains("sh -c while :; do sleep 1; done"));

		docker.stopContainer(containerId);
	}

	@Test
	public void testTopContainerStringString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerTopResponse top = docker.topContainer(containerId, "aux");
		assertTrue(top.getProcesses().get(0).contains("sh -c while :; do sleep 1; done"));

		docker.stopContainer(containerId);
	}

	@Test
	public void testLogContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerConfig config = ContainerConfig.builder().image("ubuntu")
				.cmd("sh", "-c", "while :; do echo test; sleep 1; done").build();
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerLog log = docker.logContainer(containerId, LogsParam.stdout(), LogsParam.stderr());
		assertTrue(log.getStderrLogs().isEmpty());
		assertTrue(!log.getStdoutLogs().isEmpty());

		docker.stopContainer(containerId);
	}

	@Test
	public void testInspectContainerChanges() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerConfig config = ContainerConfig.builder().image("ubuntu").cmd("sh", "-c", "touch test.txt").build();
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		List<ContainerChangeResponseItem> changes = docker.inspectContainerChanges(containerId);
		assertTrue(changes.size() > 0);
		assertTrue(changes.get(0).getKind() == ContainerChangeResponseItem.ADDED);
	}

	@Test
	public void testExportContainer() throws DockerException, IOException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();

		String binary = docker.exportContainer(containerId);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./export.tar.gz")))) {
			writer.write(binary);
		}

		assertTrue(Files.exists(Paths.get("./export.tar.gz")));
		assertTrue(Files.size(Paths.get("./export.tar.gz")) > 0);

		Files.delete(Paths.get("./export.tar.gz"));
	}

	@Test
	public void testStatContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerStats stats = docker.statContainer(containerId);

		assertNotNull(stats);
	}

	@Test
	public void testStatContainerStream() throws DockerException, InterruptedException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
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
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.resizeTTYContainer(containerId, 55, 55);

		docker.stopContainer(containerId);
	}

	@Test
	public void testStartContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);
	}

	@Test
	public void testStopContainerString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringInt() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);

		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testStopContainerStringIntTimeUnit() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);

		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testRestartContainerString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringInt() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId, 2000);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRestartContainerStringIntTimeUnit() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.restartContainer(containerId, 2, TimeUnit.SECONDS);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testKillContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.killContainer(containerId, KillSignal.SIGKILL);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		docker.removeContainer(containerId);
	}

	@Test
	public void testUpdateContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		HostConfig config = info.getHostConfig();
		assertTrue(info.getState().isRunning());

		ContainerUpdateResponse update = docker.updateContainer(containerId, HostConfig.builder().cpus(1).build());

		info = docker.inspectContainer(containerId);
		assertNotEquals(config, info.getHostConfig());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testRenameContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
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
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.pauseContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isPaused());

		docker.stopAndRemoveContainer(containerId);
	}

	@Test
	public void testUnpauseContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
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
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
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

		ContainerWaitResponse exit = docker.waitForContainer(containerId);
		assertNull(exit.getError());
		assertEquals(137, exit.getStatusCode());
	}

	@Test
	public void testRemoveContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();

		List<ContainerSummary> containers = docker.listContainers(ListContainersParam.all());
		assertTrue(containsContainer(containers, containerId));

		docker.removeContainer(containerId);
		containers = docker.listContainers(ListContainersParam.all());

		assertFalse(containsContainer(containers, containerId));
	}

	private boolean containsContainer(List<ContainerSummary> containers, String containerId) {
		for (ContainerSummary c : containers) {
			if (c.getId().equals(containerId)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testFileInfoContainer() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		ContainerFileInfo fileInfo = docker.fileInfoContainer(containerId, "/");

		assertEquals("/", fileInfo.getName());
		assertEquals(4096, fileInfo.getSize());
	}

	@Test
	public void testArchiveContainer() throws DockerException, IOException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		String binary = docker.archiveContainer(containerId, "/");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./archive.tar")))) {
			writer.write(binary);
		}

		assertTrue(Files.exists(Paths.get("./archive.tar")));
		assertTrue(Files.size(Paths.get("./archive.tar")) > 0);

		Files.delete(Paths.get("./archive.tar"));
	}

	@Test
	public void testDeleteContainers() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());

		assertTrue(containsContainer(docker.listContainers(ListContainersParam.all()), containerId));

		ContainerPruneResponse deletedInfo = docker.pruneContainers();

		assertFalse(containsContainer(docker.listContainers(ListContainersParam.all()), containerId));
		assertTrue(deletedInfo.getContainersDeleted().size() > 0);
		assertTrue(deletedInfo.getContainersDeleted().get(0).equals(containerId));
	}

	@Test
	public void testRunContainerContainerConfig() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.runContainer(config);
		String containerId = creation.getId();

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
	}

	@Test
	public void testRunContainerContainerConfigString() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.runContainer(config, "test");
		String containerId = creation.getId();

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());
		// Docker Engine adds / in front of name
		assertEquals("/test", info.getName());
	}

	@Test
	public void testStopStatContainerStream() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);

		ContainerInspectResponse info = docker.inspectContainer(containerId);
		assertTrue(info.getState().isRunning());

		docker.stopContainer(containerId);

		info = docker.inspectContainer(containerId);
		assertFalse(info.getState().isRunning());
	}

	@Test
	public void testListImages() throws DockerException {
		LOGGER.log(Level.INFO, "");
		List<ImageSummary> images = docker.listImages(ListImagesParam.all());

		assertTrue(images.size() > 0);
		assertTrue(containsImage(images, "ubuntu:latest"));
	}

	@Test
	public void testClearBuildCache() throws DockerException {
		LOGGER.log(Level.INFO, "");
		BuildPruneResponse cleared = docker.clearImageBuildCache();

		assertEquals(0, cleared.getSpaceReclaimed());
	}

	@Test
	public void testCreateImage() throws DockerException {
		LOGGER.log(Level.INFO, "");
		docker.createImage(CreateImageParam.fromImage("debian"), CreateImageParam.tag("10-slim"));

		List<ImageSummary> images = docker.listImages(ListImagesParam.reference("debian"));

		assertTrue(images.size() > 0);
	}

	@Test
	public void testInspectImage() throws DockerException {
		LOGGER.log(Level.INFO, "");
		Image info = docker.inspectImage("1d622ef86b13");

		assertEquals("ubuntu:latest", info.getRepoTags().get(0));
	}

	@Test
	public void testImageHistory() throws DockerException {
		LOGGER.log(Level.INFO, "");
		List<HistoryResponseItem> history = docker.imageHistory("1d622ef86b13");

		assertTrue(history.size() > 0);
	}

	@Test
	public void testTagImage() throws DockerException {
		LOGGER.log(Level.INFO, "");
		docker.tagImage("1d622ef86b13", ImageTagParam.repo("ubuntu"), ImageTagParam.newTag("test"));
		Image info = docker.inspectImage("1d622ef86b13");

		assertTrue(info.getRepoTags().size() > 1);
		assertEquals("ubuntu:test", info.getRepoTags().get(1));
	}

	@Test
	public void testDeleteImage() throws DockerException {
		LOGGER.log(Level.INFO, "");
		docker.createImage(CreateImageParam.fromImage("hello-world"));
		List<ImageDeleteResponseItem> infos = docker.removeImage("hello-world");

		assertEquals("hello-world:latest", infos.get(0).getUntagged());
	}

	@Test
	public void testSearchImage() throws DockerException {
		LOGGER.log(Level.INFO, "");
		List<ImageSearchResponseItem> results = docker.searchImage("hello-world");
		assertTrue(results.size() > 0);
		assertTrue(results.get(0).isOfficial());
		assertEquals("hello-world", results.get(0).getName());
	}

	@Test
	public void testImagePrune() throws DockerException {
		LOGGER.log(Level.INFO, "");
		docker.createImage(CreateImageParam.fromImage("hello-world"));
		ImagePruneResponse info = docker.pruneImages();
	}

	@Test
	public void testGetImageSingle() throws DockerException, IOException {
		LOGGER.log(Level.INFO, "");
		String binary = docker.getImage("ubuntu:latest");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./image.tar.gz")))) {
			writer.write(binary);
		}
		assertTrue(Files.exists(Paths.get("./image.tar.gz")));
		assertTrue(Files.size(Paths.get("./image.tar.gz")) > 0);

		Files.delete(Paths.get("./image.tar.gz"));
	}

	@Test
	public void testGetImageMultiple() throws DockerException, IOException {
		LOGGER.log(Level.INFO, "");
		String binary = docker.getImages("ubuntu:latest", "debian");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./images.tar.gz")))) {
			writer.write(binary);
		}
		assertTrue(Files.exists(Paths.get("./images.tar.gz")));
		assertTrue(Files.size(Paths.get("./images.tar.gz")) > 0);

		Files.delete(Paths.get("./images.tar.gz"));
	}

	private static boolean containsImage(List<ImageSummary> images, String imageRepo) {
		for (ImageSummary image : images) {
			if (image.getRepoTags().get(0).equals(imageRepo)) {
				return true;
			}
		}
		return false;
	}

	@Test
	public void testListNetworks() throws DockerException {
		LOGGER.log(Level.INFO, "");
		List<Network> networks = docker.listNetworks();
		assertTrue(networks.size() > 0);
	}

	@Test
	public void testInspectNetwork() throws DockerException {
		LOGGER.log(Level.INFO, "");
		Network network = docker.inspectNetwork("bridge");
		assertEquals(network.getName(), "bridge");
	}

	@Test
	public void testCreateNetworkAndDeleteNetwork() throws DockerException {
		LOGGER.log(Level.INFO, "");
		NetworkConfig config = NetworkConfig.builder().name("test").build();
		NetworkCreateResponse response = docker.createNetwork(config);
		assertEquals("", response.getWarning());
		String id = response.getId();
		docker.removeNetwork(id);
	}

	@Test
	public void testConnectToNetwork() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		NetworkConfig config = NetworkConfig.builder().name("test").build();
		NetworkCreateResponse response = docker.createNetwork(config);
		String id = response.getId();
		String containerId = creation.getId();
		docker.startContainer(containerId);
		docker.connectToNetwork(id, containerId);
		docker.stopContainer(containerId);
		docker.removeNetwork(id);
	}

	@Test
	public void testDisconnectFromNetwork() throws DockerException {
		LOGGER.log(Level.INFO, "");
		ContainerCreateResponse creation = docker.createContainer(config);
		NetworkConfig config = NetworkConfig.builder().name("test").build();
		NetworkCreateResponse response = docker.createNetwork(config);
		String id = response.getId();
		String containerId = creation.getId();
		docker.startContainer(containerId);
		docker.connectToNetwork(id, containerId);
		docker.disconnectFromNetwork(id, containerId, true);
		docker.stopContainer(containerId);
		docker.removeNetwork(id);
	}

	@Test
	public void testPruneNetworks() throws DockerException {
		LOGGER.log(Level.INFO, "");
		NetworkPruneParam param = NetworkPruneParam.label("test");
		NetworkConfig config = NetworkConfig.builder().name("test").build();
		docker.createNetwork(config);
		NetworkPruneResponse pruneResponse = docker.pruneNetworks();
		assertEquals("test", pruneResponse.getNetworksDeleted().get(0));
	}

	@Test
	public void testVolumesAPI() throws DockerException {
		LOGGER.log(Level.INFO, "");
		Volume vol = docker.createVolume(VolumeConfig.builder().name("test").build());
		assertEquals("test", vol.getName());

		VolumeListResponse response = docker.listVolumes();
		assertEquals("test", response.getVolumes().get(0).getName());

		Volume volume = docker.inspectVolume("test");
		assertEquals("test", volume.getName());

		docker.removeVolume("test", false);

		docker.pruneVolume();
	}

	@Test
	public void testExec() throws DockerException {
		ExecConfig execconfig = ExecConfig.builder().cmd("sh", "-c", "while :; do echo test; sleep 1; done").build();
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);
		IdResponse id = docker.createExec(containerId, execconfig);
		docker.startExec(id.getId(), new IExecResponseListener() {
			@Override
			public void onMessage(ExecResponse response) {
				System.out.println(response.getMessage());
			}

			@Override
			public void onClosed(int statusCode, String message) {
				System.out.println(statusCode);
				System.out.println(message);
			}
		});
		ExecInspectResponse response = docker.inspectExec(id.getId());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		docker.stopExec(id.getId());
	}

	@Test
	public void testRunExec() throws DockerException {
		ExecConfig execconfig = ExecConfig.builder().cmd("ls -h").build();
		ContainerCreateResponse creation = docker.createContainer(config);
		String containerId = creation.getId();
		docker.startContainer(containerId);
		docker.runExec(containerId, execconfig);
	}

	@Test
	public void testSystemInfo() throws DockerException {
		SystemInfo response = docker.systemInfo();
	}

	@Test
	public void testVersionInfo() throws DockerException {
		SystemVersionResponse response = docker.versionInfo();
	}

	@Test
	public void testPing() throws DockerException {
		String message = docker.ping();
		assertEquals("OK", message);
	}

	@Test
	public void testDataUsage() throws DockerException {
		SystemDataUsageResponse response = docker.dataUsage();
	}
}
