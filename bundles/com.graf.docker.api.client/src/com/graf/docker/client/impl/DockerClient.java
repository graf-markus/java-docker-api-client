package com.graf.docker.client.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.exceptions.ExceptionMessage;
import com.graf.docker.client.interfaces.FilterParam;
import com.graf.docker.client.interfaces.IContainerStatsListener;
import com.graf.docker.client.interfaces.IDockerClient;
import com.graf.docker.client.interfaces.IExecResponseListener;
import com.graf.docker.client.models.ContainerSummary;
import com.graf.docker.client.models.ContainerChangeResponseItem;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreateResponse;
import com.graf.docker.client.models.ContainerWaitResponse;
import com.graf.docker.client.models.EndpointSettings;
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
import com.graf.docker.client.models.AuthConfig;
import com.graf.docker.client.models.BuildPruneResponse;
import com.graf.docker.client.models.ImageDeleteResponseItem;
import com.graf.docker.client.models.HistoryResponseItem;
import com.graf.docker.client.models.Image;
import com.graf.docker.client.models.ImagePruneResponse;
import com.graf.docker.client.models.ImageSearchResponseItem;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.Network;
import com.graf.docker.client.models.NetworkConfig;
import com.graf.docker.client.models.NetworkConnect;
import com.graf.docker.client.models.NetworkCreateResponse;
import com.graf.docker.client.models.NetworkDisconnect;
import com.graf.docker.client.models.NetworkPruneResponse;
import com.graf.docker.client.models.SystemAuthResponse;
import com.graf.docker.client.models.SystemDataUsageResponse;
import com.graf.docker.client.models.SystemInfo;
import com.graf.docker.client.models.SystemVersionResponse;
import com.graf.docker.client.models.Volume;
import com.graf.docker.client.models.VolumeConfig;
import com.graf.docker.client.models.VolumeListResponse;
import com.graf.docker.client.models.VolumePruneResponse;
import com.graf.docker.client.models.ContainerTopResponse;
import com.graf.docker.client.params.ClearCacheParam;
import com.graf.docker.client.params.CommitImageParam;
import com.graf.docker.client.params.CreateImageParam;
import com.graf.docker.client.params.ImageDeleteParam;
import com.graf.docker.client.params.ImageSearchParam;
import com.graf.docker.client.params.ImageTagParam;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.ListImagesParam;
import com.graf.docker.client.params.ListVolumesParam;
import com.graf.docker.client.params.LogsParam;
import com.graf.docker.client.params.NetworkPruneParam;
import com.graf.docker.client.params.Param;
import com.graf.docker.client.params.RemoveContainersParam;
import com.graf.docker.client.params.RemoveVolumesParam;

public class DockerClient implements IDockerClient {

	private CloseableHttpClient client;
	private String url;
	private Gson gson;
	private Map<String, ContainerStatsThread> statsThreads;
	private Map<String, ExecResponseThread> execThreads;

	public DockerClient(String url) {
		this.url = url;
		client = HttpClients.createDefault();
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	}

	@Override
	public List<ContainerSummary> listContainers(final ListContainersParam... params) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", "json")
				.addParameters(params).build();
		ContainerSummary[] containers = execute(request, 200, ContainerSummary[].class);
		return Arrays.asList(containers);
	}

	@Override
	public ContainerCreateResponse createContainer(ContainerConfig config) throws DockerException {
		return createContainer(config, null);
	}

	@Override
	public ContainerCreateResponse createContainer(ContainerConfig config, String containerName)
			throws DockerException {
		RequestBuilder builder = RequestBuilder.post().setUrl(url).addPaths("containers", "create").setBody(config);
		if (!isNullOrEmpty(containerName)) {
			builder.addParameter("name", containerName);
		}
		HttpPost request = (HttpPost) builder.build();
		return execute(request, 201, ContainerCreateResponse.class);
	}

	@Override
	public ContainerInspectResponse inspectContainer(String containerId) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "json")
				.build();
		return execute(request, 200, ContainerInspectResponse.class);
	}

	@Override
	public ContainerTopResponse topContainer(String containerId) throws DockerException {
		return topContainer(containerId, null);
	}

	@Override
	public ContainerTopResponse topContainer(String containerId, String psargs) throws DockerException {
		RequestBuilder builder = RequestBuilder.get();
		if (!isNullOrEmpty(psargs)) {
			builder.addParameter("ps_args", psargs);
		}
		HttpGet request = (HttpGet) builder.setUrl(url).addPaths("containers", containerId, "top").build();
		return execute(request, 200, ContainerTopResponse.class);
	}

	@Override
	public ContainerLog logContainer(String containerId, LogsParam... param) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "logs")
				.addParameters(param).build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				InputStream stream = response.getEntity().getContent();
				byte[] header = new byte[8];
				StringBuilder builder = new StringBuilder();
				ContainerLog.Builder logBuilder = ContainerLog.builder();
				while ((stream.read(header)) != -1) {
					int sizeToRead = byteArrayToInt(new byte[] { header[4], header[5], header[6], header[7] });
					byte[] read = new byte[sizeToRead];
					stream.read(read);
					builder.append(new String(read));
					if (header[0] == 1) {
						logBuilder.stdout(builder.toString());
					} else if (header[0] == 2) {
						logBuilder.stderr(builder.toString());
					}
					header = new byte[8];
					builder.setLength(0);
				}
				return logBuilder.build();
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public List<ContainerChangeResponseItem> inspectContainerChanges(String containerId) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "changes")
				.build();
		ContainerChangeResponseItem[] changes = execute(request, 200, ContainerChangeResponseItem[].class);
		if (changes != null) {
			return Arrays.asList(changes);
		}
		return new ArrayList<>();
	}

	@Override
	public String exportContainer(String containerId) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "export")
				.build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String binaryString = EntityUtils.toString(response.getEntity());
				return binaryString;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public ContainerStats statContainer(String containerId) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "stats")
				.addParameter("stream", String.valueOf(false)).build();
		return execute(request, 200, ContainerStats.class);
	}

	@Override
	public void statContainerStream(String containerId, IContainerStatsListener listener) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "stats")
				.build();
		ContainerStatsThread t = new ContainerStatsThread(containerId, request, listener);
		t.start();
		getStatsThreadsMap().put(containerId, t);
	}

	@Override
	public void addContainerStatListener(String containerId, IContainerStatsListener listener) throws DockerException {
		if (getStatsThreadsMap().get(containerId) != null) {
			getStatsThreadsMap().get(containerId).addContainerStatListener(listener);
		}
	}

	@Override
	public void removeContainerStatListener(String containerId, IContainerStatsListener listener)
			throws DockerException {
		if (getStatsThreadsMap().get(containerId) != null) {
			getStatsThreadsMap().get(containerId).removeContainerStatListener(listener);
		}
	}

	@Override
	public void resizeTTYContainer(String containerId, int height, int width) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "resize")
				.addParameter("h", String.valueOf(height)).addParameter("w", String.valueOf(width)).build();
		execute(request, 200, String.class);
	}

	public void startContainer(String containerId) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "start")
				.build();
		execute(request, 204);
	}

	@Override
	public void stopContainer(String containerId) throws DockerException {
		this.stopContainer(containerId, 0);
	}

	@Override
	public void stopContainer(String containerId, int timeToWaitMillis) throws DockerException {
		this.stopContainer(containerId, timeToWaitMillis, TimeUnit.MILLISECONDS);
	}

	@Override
	public void stopContainer(String containerId, int time, TimeUnit unit) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "stop")
				.addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build();
		execute(request, 204);
	}

	@Override
	public void restartContainer(String containerId) throws DockerException {
		this.restartContainer(containerId, 0);
	}

	@Override
	public void restartContainer(String containerId, int timeToWaitMillis) throws DockerException {
		this.restartContainer(containerId, timeToWaitMillis, TimeUnit.MILLISECONDS);
	}

	@Override
	public void restartContainer(String containerId, int time, TimeUnit unit) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "restart")
				.addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build();
		execute(request, 204);
	}

	@Override
	public void killContainer(String containerId, KillSignal signal) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "kill")
				.addParameter("signal", signal.toString()).build();
		execute(request, 204);
	}

	@Override
	public ContainerUpdateResponse updateContainer(String containerId, HostConfig config) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "update")
				.setBody(config).build();
		return execute(request, 200, ContainerUpdateResponse.class);
	}

	@Override
	public void renameContainer(String containerId, String name) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "rename")
				.addParameter("name", name).build();
		execute(request, 204);
	}

	@Override
	public void pauseContainer(String containerId) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "pause")
				.build();
		execute(request, 204);
	}

	@Override
	public void unpauseContainer(String containerId) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "unpause")
				.build();
		execute(request, 204);
	}

	@Override
	public ContainerWaitResponse waitForContainer(String containerId) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", containerId, "wait")
				.build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			byte[] bytes = new byte[4096];
			int read = response.getEntity().getContent().read(bytes);
			return gson.fromJson(new String(bytes, 0, read - 1), ContainerWaitResponse.class);
		} catch (Exception e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException {
		HttpDelete request = (HttpDelete) RequestBuilder.delete().setUrl(url).addPaths("containers", containerId)
				.addParameters(params).build();
		execute(request, 204);
	}

	@Override
	public ContainerFileInfo fileInfoContainer(String containerId, String path) throws DockerException {
		HttpHead request = (HttpHead) RequestBuilder.head().setUrl(url).addPaths("containers", containerId, "archive")
				.addParameter("path", path).build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			String header = response.getHeaders("X-Docker-Container-Path-Stat")[0].getValue();
			byte[] decodedBytes = Base64.getDecoder().decode(header);
			String decodedString = new String(decodedBytes);
			if (statusCode == 200) {
				return gson.fromJson(decodedString, ContainerFileInfo.class);
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (Exception e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public String archiveContainer(String containerId, String path) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("containers", containerId, "archive")
				.addParameter("path", path).build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String binaryString = EntityUtils.toString(response.getEntity());
				return binaryString;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public void extractToContainer(String containerId, String containerPath, String hostPath) throws DockerException {
		FileInputStream stream;
		try {
			stream = new FileInputStream(new File(hostPath));
		} catch (FileNotFoundException e) {
			throw new DockerException("File not found");
		}
		HttpPut request = (HttpPut) RequestBuilder.put().setUrl(url).addPaths("containers", containerId, "archive")
				.addParameter("path", containerPath).build();
		InputStreamEntity reqEntity = new InputStreamEntity(stream, 1, ContentType.APPLICATION_OCTET_STREAM);
		reqEntity.setChunked(true);
		request.setEntity(reqEntity);
		execute(request, 200);
	}

	@Override
	public ContainerPruneResponse pruneContainers() throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", "prune").build();
		return execute(request, 200, ContainerPruneResponse.class);
	}

	// ==================================================
	// Image API

	@Override
	public List<ImageSummary> listImages(ListImagesParam... param) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("images", "json").addParameters(param)
				.build();
		ImageSummary[] images = execute(request, 200, ImageSummary[].class);
		return Arrays.asList(images);
	}

	@Override
	public BuildPruneResponse clearImageBuildCache(ClearCacheParam... param) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("build", "prune").addParameters(param)
				.build();
		return execute(request, 200, BuildPruneResponse.class);
	}

	@Override
	public void createImage(CreateImageParam... param) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("images", "create")
				.addParameters(param).build();
		execute(request, 200);
	}

	@Override
	public Image inspectImage(String imageName) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("images", imageName, "json").build();
		return execute(request, 200, Image.class);
	}

	@Override
	public List<HistoryResponseItem> imageHistory(String imageName) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("images", imageName, "history").build();
		HistoryResponseItem[] images = execute(request, 200, HistoryResponseItem[].class);
		return Arrays.asList(images);
	}

	@Override
	public void tagImage(String imageName, ImageTagParam... param) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("images", imageName, "tag")
				.addParameters(param).build();
		execute(request, 201);
	}

	@Override
	public List<ImageDeleteResponseItem> removeImage(String imageName, ImageDeleteParam... param)
			throws DockerException {
		HttpDelete request = (HttpDelete) RequestBuilder.delete().setUrl(url).addPaths("images", imageName)
				.addParameters(param).build();
		ImageDeleteResponseItem[] info = execute(request, 200, ImageDeleteResponseItem[].class);
		return Arrays.asList(info);
	}

	@Override
	public List<ImageSearchResponseItem> searchImage(String term, ImageSearchParam... param) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("images", "search")
				.addParameter("term", term).addParameters(param).build();
		ImageSearchResponseItem[] results = execute(request, 200, ImageSearchResponseItem[].class);
		return Arrays.asList(results);
	}

	@Override
	public ImagePruneResponse pruneImages() throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("images", "prune").build();
		return execute(request, 200, ImagePruneResponse.class);
	}

	@Override
	public IdResponse commitImage(ContainerConfig config, CommitImageParam... param) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPath("commit").addParameters(param)
				.setBody(config).build();
		return execute(request, 201, IdResponse.class);
	}

	@Override
	public String getImage(String name) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("images", name, "get").build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String binaryString = EntityUtils.toString(response.getEntity());
				return binaryString;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public String getImages(String... names) throws DockerException {
		RequestBuilder builder = RequestBuilder.get();
		for (String s : names) {
			builder.addParameter("names", s);
		}
		HttpGet request = (HttpGet) builder.setUrl(url).addPaths("images", "get").build();
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				String binaryString = EntityUtils.toString(response.getEntity());
				return binaryString;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public void loadImage(String pathToTarball) throws DockerException {
		FileInputStream stream;
		try {
			stream = new FileInputStream(new File(pathToTarball));
		} catch (FileNotFoundException e) {
			throw new DockerException("File not found", 0);
		}
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("images", "load").build();
		InputStreamEntity reqEntity = new InputStreamEntity(stream);
		request.setEntity(reqEntity);
		execute(request, 200);
	}

	// ==============================================================
	// Network API

	@Override
	public List<Network> listNetworks() throws DockerException {
		HttpGet rquest = (HttpGet) RequestBuilder.get().setUrl(url).addPath("networks").build();
		Network[] networks = execute(rquest, 200, Network[].class);
		return Arrays.asList(networks);
	}

	@Override
	public Network inspectNetwork(String id) throws DockerException {
		return inspectNetwork(id, false, "");
	}

	@Override
	public Network inspectNetwork(String id, boolean verbose) throws DockerException {
		return inspectNetwork(id, verbose, "");
	}

	@Override
	public Network inspectNetwork(String id, boolean verbose, String scope) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPath("networks").addPath(id)
				.addParameter("verbose", String.valueOf(verbose)).addParameter("scope", scope).build();
		return execute(request, 200, Network.class);
	}

	@Override
	public Network inspectNetwork(String id, String scope) throws DockerException {
		return inspectNetwork(id, false, scope);
	}

	@Override
	public void removeNetwork(String id) throws DockerException {
		HttpDelete request = (HttpDelete) RequestBuilder.delete().setUrl(url).addPaths("networks", id).build();
		execute(request, 204);
	}

	@Override
	public NetworkCreateResponse createNetwork(NetworkConfig config) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("networks", "create").setBody(config)
				.build();
		return execute(request, 201, NetworkCreateResponse.class);
	}

	@Override
	public void connectToNetwork(String id, String container, EndpointSettings endpoint) throws DockerException {
		NetworkConnect connect;
		if (endpoint != null) {
			connect = NetworkConnect.builder().container(container).endpointConfig(endpoint).build();
		} else {
			connect = NetworkConnect.builder().container(container).build();
		}
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("networks", id, "connect")
				.setBody(connect).build();
		execute(request, 200);
	}

	@Override
	public void connectToNetwork(String id, String container) throws DockerException {
		connectToNetwork(id, container, null);
	}

	@Override
	public void disconnectFromNetwork(String id, String container, boolean force) throws DockerException {
		NetworkDisconnect disconnect = NetworkDisconnect.builder().container(container).force(force).build();
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("networks", id, "disconnect")
				.setBody(disconnect).build();
		execute(request, 200);
	}

	@Override
	public NetworkPruneResponse pruneNetworks(NetworkPruneParam... params) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("networks", "prune")
				.addParameters(params).build();
		return execute(request, 200, NetworkPruneResponse.class);
	}

	// ==================================================
	// Volume API

	@Override
	public VolumeListResponse listVolumes(ListVolumesParam... params) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("volumes").addParameters(params).build();
		return execute(request, 200, VolumeListResponse.class);
	}

	@Override
	public Volume createVolume(VolumeConfig config) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("volumes", "create").setBody(config)
				.build();
		return execute(request, 201, Volume.class);
	}

	@Override
	public Volume inspectVolume(String name) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("volumes", name).build();
		return execute(request, 200, Volume.class);
	}

	@Override
	public void removeVolume(String name, boolean force) throws DockerException {
		HttpDelete request = (HttpDelete) RequestBuilder.delete().setUrl(url).addPaths("volumes", name)
				.addParameter("forece", String.valueOf(force)).build();
		execute(request, 204);
	}

	@Override
	public VolumePruneResponse pruneVolume(RemoveVolumesParam... param) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("volumes", "prune")
				.addParameters(param).build();
		return execute(request, 200, VolumePruneResponse.class);
	}

	// ==================================================
	// Exec API

	@Override
	public IdResponse createExec(String container, ExecConfig config) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("containers", container, "exec")
				.setBody(config).build();
		return execute(request, 201, IdResponse.class);
	}

	@Override
	public void startExec(String id, IExecResponseListener listener) throws DockerException {
		RequestBuilder builder = RequestBuilder.post().setUrl(url).addPaths("exec", id, "start");
		ExecStartConfig defaultConfig = ExecStartConfig.builder().detach(false).tty(false).build();
		builder.setBody(defaultConfig);

		HttpPost request = (HttpPost) builder.build();
		ExecResponseThread t = new ExecResponseThread(id, request, listener);
		getExecThreadsMap().put(id, t);
		t.start();
	}

	@Override
	public void stopExec(String id) throws DockerException {
		Thread t = getExecThreadsMap().get(id);
		if (t != null) {
			t.interrupt();
		}
		getExecThreadsMap().remove(id);
	}

	@Override
	public void addExecResponseListener(String id, IExecResponseListener listener) {
		if (getExecThreadsMap().get(id) != null) {
			getExecThreadsMap().get(id).addExecResponseListener(listener);
		}
	}

	@Override
	public void removeExecResponseLsitener(String id, IExecResponseListener listener) {
		if (getExecThreadsMap().get(id) != null) {
			getExecThreadsMap().get(id).removeExecResponseListener(listener);
		}
	}

	@Override
	public ExecInspectResponse inspectExec(String id) throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("exec", id, "json").build();
		return execute(request, 200, ExecInspectResponse.class);
	}
	// ==================================================
	// System API

	@Override
	public SystemAuthResponse authenticate(AuthConfig authConfig) throws DockerException {
		HttpPost request = (HttpPost) RequestBuilder.post().setUrl(url).addPaths("auth").setBody(authConfig).build();
		return execute(request, 200, SystemAuthResponse.class);
	}

	@Override
	public SystemVersionResponse versionInfo() throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("version").build();
		return execute(request, 200, SystemVersionResponse.class);
	}

	@Override
	public String ping() throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("_ping").build();
		return execute(request, 200, String.class);
	}

	@Override
	public SystemDataUsageResponse dataUsage() throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("system", "df").build();
		return execute(request, 200, SystemDataUsageResponse.class);
	}

	@Override
	public SystemInfo systemInfo() throws DockerException {
		HttpGet request = (HttpGet) RequestBuilder.get().setUrl(url).addPaths("info").build();
		return execute(request, 200, SystemInfo.class);
	}

	// ==================================================

	@Override
	public ContainerCreateResponse runContainer(ContainerConfig config) throws DockerException {
		return this.runContainer(config, null);
	}

	@Override
	public ContainerCreateResponse runContainer(ContainerConfig config, String containerName) throws DockerException {
		ContainerCreateResponse creation = this.createContainer(config, containerName);
		this.startContainer(creation.getId());
		return creation;
	}

	@Override
	public void stopStatContainerStream(String containerId) {
		Thread t = getStatsThreadsMap().get(containerId);
		if (t != null) {
			t.interrupt();
		}
		getStatsThreadsMap().remove(containerId);
	}

	@Override
	public void stopAndRemoveContainer(String containerId) throws DockerException {
		this.stopContainer(containerId);
		this.removeContainer(containerId);
	}

	@Override
	public void runExec(String container, ExecConfig config, IExecResponseListener listener) throws DockerException {
		IdResponse id = this.createExec(container, config);
		this.startExec(id.getId(), listener);
	}

	// ==================================================

	private void execute(HttpUriRequest request, int successStatusCode) throws DockerException {
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String jsonEntity = "";
			if (entity != null) {
				jsonEntity = EntityUtils.toString(entity);
			}
			if (statusCode == successStatusCode) {
				return;
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	private <T> T execute(HttpUriRequest request, int successStatusCode, Class<T> returnClazz) throws DockerException {
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == successStatusCode) {
				return gson.fromJson(jsonEntity, returnClazz);
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private Map<String, ContainerStatsThread> getStatsThreadsMap() {
		if (statsThreads == null) {
			statsThreads = new ConcurrentHashMap<>();
		}
		return statsThreads;
	}

	private Map<String, ExecResponseThread> getExecThreadsMap() {
		if (execThreads == null) {
			execThreads = new ConcurrentHashMap<>();
		}
		return execThreads;
	}

	public static int byteArrayToInt(byte[] b) {
		if (b.length == 4)
			return b[0] << 24 | (b[1] & 0xff) << 16 | (b[2] & 0xff) << 8 | (b[3] & 0xff);
		else if (b.length == 2)
			return 0x00 << 24 | 0x00 << 16 | (b[0] & 0xff) << 8 | (b[1] & 0xff);

		return 0;
	}

	static class RequestBuilder {

		private StringBuilder pathBuilder;
		private List<Param> params;
		private Map<String, List<String>> filterParams;
		private List<String> paths;
		private String url;
		private String body = null;
		private RequestType type;
		private Gson gson;

		public RequestBuilder() {
			pathBuilder = new StringBuilder();
			params = new ArrayList<>();
			paths = new ArrayList<>();
			filterParams = new HashMap<>();
			gson = new Gson();
		}

		public RequestBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public RequestBuilder addPath(String path) {
			paths.add("/" + path);
			return this;
		}

		public RequestBuilder addPaths(String... paths) {
			for (String p : paths) {
				this.paths.add("/" + p);
			}
			return this;
		}

		public RequestBuilder addParameter(final String name, final String value) {
			params.add(new Param(name, value));
			return this;
		}

		public <T> RequestBuilder setBody(T body) {
			this.body = gson.toJson(body);
			return this;
		}

		public RequestBuilder addParameters(final Param... params) {
			for (final Param param : params) {
				if (param instanceof FilterParam) {
					if (filterParams.containsKey(param.name())) {
						filterParams.get(param.name()).add(param.value());
					} else {
						ArrayList<String> value = new ArrayList<>();
						value.add(param.value());
						filterParams.put(param.name(), value);
					}
				} else {
					this.params.add(param);
				}
			}
			return this;
		}

		public HttpUriRequest build() throws DockerException {
			pathBuilder.append(this.url);
			if (paths != null) {
				for (String s : paths) {
					pathBuilder.append(s);
				}
			}
			if (params != null) {
				if (params.size() > 0) {
					pathBuilder.append("?").append(params.get(0).name()).append("=").append(params.get(0).value());
				}
				for (int i = 1; i < params.size(); i++) {
					pathBuilder.append("&").append(params.get(i).name()).append("=").append(params.get(i).value());
				}
			}
			if (filterParams != null && filterParams.size() > 0) {
				Gson gson = new Gson();
				if (params.size() > 0) {
					pathBuilder.append("&");
				} else {
					pathBuilder.append("?");
				}
				String params = "";
				try {
					params = URLEncoder.encode(gson.toJson(filterParams), "UTF-8");
				} catch (UnsupportedEncodingException e) {
				}
				pathBuilder.append("filters=").append(params);
			}
			HttpUriRequest request;
			if (type == RequestType.GET) {
				request = new HttpGet(pathBuilder.toString());
				return request;
			}
			if (type == RequestType.PUT) {
				request = new HttpPut(pathBuilder.toString());
				return request;
			}
			if (type == RequestType.POST) {
				request = new HttpPost(pathBuilder.toString());
				if (body != null) {
					request.setHeader("Content-Type", "application/json");
					try {
						((HttpPost) request).setEntity(new StringEntity(body));
					} catch (UnsupportedEncodingException e) {
						throw new DockerException(e.getMessage());
					}
				}
				return request;
			}
			if (type == RequestType.DELETE) {
				request = new HttpDelete(pathBuilder.toString());
				return request;
			}
			if (type == RequestType.HEAD) {
				request = new HttpHead(pathBuilder.toString());
				return request;
			}
			return null;
		}

		public static RequestBuilder post() {
			RequestBuilder builder = new RequestBuilder();
			builder.type = RequestType.POST;
			return builder;
		}

		public static RequestBuilder put() {
			RequestBuilder builder = new RequestBuilder();
			builder.type = RequestType.PUT;
			return builder;
		}

		public static RequestBuilder get() {
			RequestBuilder builder = new RequestBuilder();
			builder.type = RequestType.GET;
			return builder;
		}

		public static RequestBuilder delete() {
			RequestBuilder builder = new RequestBuilder();
			builder.type = RequestType.DELETE;
			return builder;
		}

		public static RequestBuilder head() {
			RequestBuilder builder = new RequestBuilder();
			builder.type = RequestType.HEAD;
			return builder;
		}

		private enum RequestType {
			POST, PUT, DELETE, GET, HEAD
		}
	}

	class ContainerStatsThread extends Thread {

		private List<IContainerStatsListener> listeners = new ArrayList<>();
		private String id;
		private HttpGet request;
		private Gson gson;
		private int statusCode = 0;
		private String message = "Container Stats closed";

		public ContainerStatsThread(String containerId, HttpGet request, IContainerStatsListener listener) {
			this.listeners.add(listener);
			this.id = containerId;
			this.request = request;
			this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		}

		public synchronized void addContainerStatListener(IContainerStatsListener listener) {
			this.listeners.add(listener);
		}

		public synchronized void removeContainerStatListener(IContainerStatsListener listener) {
			this.listeners.remove(listener);
		}

		@Override
		public void run() {
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
					int len = 0;
					StringBuilder builder = new StringBuilder();
					CharBuffer buffer = CharBuffer.allocate(4096);
					while (((len = reader.read(buffer)) != -1) && !Thread.currentThread().isInterrupted()) {
						builder.append(buffer.flip().toString());
						if (len < 4096) {
							ContainerStats stats = gson.fromJson(builder.toString(), ContainerStats.class);
							listeners.stream().forEach(l -> l.onContainerStatsReceived(id, stats));
							builder.setLength(0);
						}
						buffer.clear();
					}
				}
			} catch (IOException e) {
				Thread.currentThread().interrupt();
				message = e.getMessage();
			} finally {
				listeners.stream().forEach(l -> l.onClosed(statusCode, message));
				getStatsThreadsMap().remove(id);
			}
		}
	}

	class ExecResponseThread extends Thread {

		private List<IExecResponseListener> listeners = new ArrayList<>();
		private String id;
		private HttpPost request;
		private int statusCode = 0;
		private String message = "Exec Response closed";

		public ExecResponseThread(String id, HttpPost request, IExecResponseListener listener) {
			this.id = id;
			this.request = request;
			listeners.add(listener);
		}

		public synchronized void addExecResponseListener(IExecResponseListener listener) {
			this.listeners.add(listener);
		}

		public synchronized void removeExecResponseListener(IExecResponseListener listener) {
			this.listeners.remove(listener);
		}

		@Override
		public void run() {
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
					int len = 0;
					StringBuilder builder = new StringBuilder();
					CharBuffer buffer = CharBuffer.allocate(4096);
					while (((len = reader.read(buffer)) != -1) && !Thread.currentThread().isInterrupted()) {
						builder.append(buffer.flip().toString());
						if (len < 4096) {
							ExecResponse res = ExecResponse.builder().id(id).message(builder.toString().trim()).build();
							listeners.stream().forEach(l -> l.onMessage(res));
							builder.setLength(0);
						}
						buffer.clear();
					}
				}
			} catch (IOException e) {
				Thread.currentThread().interrupt();
				message = e.getMessage();
			} finally {
				ExecResponse res = ExecResponse.builder().id(id).message(message).build();
				listeners.stream().forEach(l -> l.onClosed(statusCode, res));
				getExecThreadsMap().remove(id);
			}
		}
	}
}
