package com.graf.docker.client.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.TopResults;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.LogsParam;
import com.graf.docker.client.params.Param;
import com.graf.docker.client.params.RemoveContainersParam;

public class DockerClient implements IDockerClient {

	private CloseableHttpClient client;
	private String url;
	private Gson gson;
	private Map<String, Thread> statsThreads;

	public DockerClient(String url) {
		this.url = url;
		client = HttpClients.createDefault();
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	}

	@Override
	public List<Container> listContainers(final ListContainersParam... params) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath("json")
				.addParameters(params).build());
		return Arrays.asList(execute(request, 200, Container[].class));
	}

	@Override
	public ContainerCreation createContainer(ContainerConfig config) throws DockerException {
		return createContainer(config, null);
	}

	@Override
	public ContainerCreation createContainer(ContainerConfig config, String containerName) throws DockerException {
		RequestBuilder builder = RequestBuilder.builder().setUrl(url).addPath("containers").addPath("create");
		if (!isNullOrEmpty(containerName)) {
			builder.addParameter("name", containerName);
		}
		HttpPost request = new HttpPost(builder.build());
		try {
			request.setHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(gson.toJson(config)));
		} catch (UnsupportedEncodingException e) {
			throw new DockerException(e.getMessage());
		}
		return execute(request, 201, ContainerCreation.class);
	}

	@Override
	public ContainerInfo inspectContainer(String containerId) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("json").build());
		return execute(request, 200, ContainerInfo.class);
	}

	@Override
	public TopResults topContainer(String containerId) throws DockerException {
		return topContainer(containerId, null);
	}

	@Override
	public TopResults topContainer(String containerId, String psargs) throws DockerException {
		RequestBuilder builder = RequestBuilder.builder();
		if (!isNullOrEmpty(psargs)) {
			builder.addParameter("ps_args", psargs);
		}
		HttpGet request = new HttpGet(
				builder.setUrl(url).addPath("containers").addPath(containerId).addPath("top").build());
		return execute(request, 200, TopResults.class);
	}

	@Override
	public ContainerLog logContainer(String containerId, LogsParam... param) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("logs").addParameters(param).build());
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				InputStream stream = response.getEntity().getContent();
				int len = 0;
				byte[] header = new byte[8];
				StringBuilder builder = new StringBuilder();
				ContainerLog.Builder logBuilder = ContainerLog.builder();
				while ((len = stream.read(header)) != -1) {
					int sizeToRead = byteArrayToInt(new byte[] { header[4], header[5], header[6], header[7] });
					byte[] read = new byte[sizeToRead];
					stream.read(read);
					builder.append(new String(read));
					if (header[0] == 1) {
						logBuilder.addStdout(builder.toString());
					} else if (header[0] == 2) {
						logBuilder.addStderr(builder.toString());
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
	public List<ContainerChange> inspectContainerChanges(String containerId) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("changes").build());
		ContainerChange[] changes = execute(request, 200, ContainerChange[].class);
		if (changes != null) {
			return Arrays.asList(changes);
		}
		return new ArrayList<>();
	}

	@Override
	public String exportContainer(String containerId) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("export").build());
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
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("stats").addParameter("stream", String.valueOf(false)).build());
		return execute(request, 200, ContainerStats.class);
	}

	@Override
	public void statContainerStream(String containerId, IContainerStatsListener listener) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("stats").build());
		Thread t = new Thread(new ContainerStatsRunnable(request, listener));
		t.start();
		getStatsThreadsMap().put(containerId, t);
	}

	@Override
	public void resizeTTYContainer(String containerId, int height, int width) throws DockerException {
		HttpPost request = new HttpPost(
				RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId).addPath("resize")
						.addParameter("h", String.valueOf(height)).addParameter("w", String.valueOf(width)).build());
		execute(request, 200, String.class);
	}

	public void startContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("start").build());
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
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("stop").addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build());
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
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("restart").addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build());
		execute(request, 204);
	}

	@Override
	public void killContainer(String containerId, KillSignal signal) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("kill").addParameter("signal", signal.toString()).build());
		execute(request, 204);
	}

	@Override
	public ContainerUpdate updateContainer(String containerId, HostConfig config) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("update").build());
		try {
			request.setHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(gson.toJson(config)));
		} catch (UnsupportedEncodingException e) {
			throw new DockerException(e.getMessage());
		}
		return execute(request, 200, ContainerUpdate.class);
	}

	@Override
	public void renameContainer(String containerId, String name) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("rename").addParameter("name", name).build());
		execute(request, 204);
	}

	@Override
	public void pauseContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("pause").build());
		execute(request, 204);
	}

	@Override
	public void unpauseContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("unpause").build());
		execute(request, 204);
	}

	@Override
	public ContainerExit waitForContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("wait").build());
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			return gson.fromJson(new String(response.getEntity().getContent().readAllBytes()), ContainerExit.class);
		} catch (Exception e) {
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	@Override
	public void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException {
		HttpDelete request = new HttpDelete(RequestBuilder.builder().setUrl(url).addPath("containers")
				.addPath(containerId).addParameters(params).build());
		execute(request, 204);
	}

	@Override
	public ContainerFileInfo fileInfoContainer(String containerId, String path) throws DockerException {
		HttpHead request = new HttpHead(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("archive").addParameter("path", path).build());
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
	public void archiveContainer(String containerId, String path) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("archive").addParameter("path", path).build());
		execute(request, 200);
	}

	@Override
	public void extractToContainer(String containerId, String containerPath, String hostPath) throws DockerException {
		FileInputStream stream;
		try {
			stream = new FileInputStream(new File(hostPath));
		} catch (FileNotFoundException e) {
			throw new DockerException("File not found", 0);
		}
		HttpPut request = new HttpPut(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("archive").addParameter("path", containerPath).build());
		InputStreamEntity reqEntity = new InputStreamEntity(stream, 1, ContentType.APPLICATION_OCTET_STREAM);
		reqEntity.setChunked(true);
		request.setEntity(reqEntity);
		execute(request, 200);
	}

	@Override
	public ContainersDeletedInfo deleteContainers() throws DockerException {
		HttpPost request = new HttpPost(
				RequestBuilder.builder().setUrl(url).addPath("containers").addPath("prune").build());
		return execute(request, 200, ContainersDeletedInfo.class);
	}

	// ==================================================

	@Override
	public ContainerCreation runContainer(ContainerConfig config) throws DockerException {
		return this.runContainer(config, null);
	}

	@Override
	public ContainerCreation runContainer(ContainerConfig config, String containerName) throws DockerException {
		ContainerCreation creation = this.createContainer(config, containerName);
		this.startContainer(creation.getId());
		return creation;
	}

	@Override
	public void stopStatContainerStream(String containerId) {
		Thread t = getStatsThreadsMap().get(containerId);
		if (t != null) {
			t.interrupt();
			getStatsThreadsMap().remove(containerId);
		}
	}

	@Override
	public void stopAndRemoveContainer(String containerId) throws DockerException {
		this.stopContainer(containerId);
		this.removeContainer(containerId);
	}

	// ==================================================

	private void execute(HttpUriRequest request, int successStatusCode) throws DockerException {
		int statusCode = 0;
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == successStatusCode) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
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
			throw new DockerException(e.getMessage(), statusCode);
		}
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private Map<String, Thread> getStatsThreadsMap() {
		if (statsThreads == null) {
			statsThreads = new ConcurrentHashMap<>();
		}
		return statsThreads;
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
		private List<String> paths;
		private String url;

		public RequestBuilder() {
			pathBuilder = new StringBuilder();
			params = new ArrayList<>();
			paths = new ArrayList<>();
		}

		public RequestBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public RequestBuilder addPath(String path) {
			paths.add("/" + path);
			return this;
		}

		public RequestBuilder addParameter(final String name, final String value) {
			params.add(new Param(name, value));
			return this;
		}

		public RequestBuilder addParameters(final Param... params) {
			for (final Param param : params) {
				this.params.add(param);
			}
			return this;
		}

		public String build() {
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
			return pathBuilder.toString();
		}

		public static RequestBuilder builder() {
			return new RequestBuilder();
		}
	}

	class ContainerStatsRunnable implements Runnable {

		private IContainerStatsListener listener;
		private HttpGet request;
		private Gson gson;
		private int statusCode = 0;
		private String message = "Container Stats closed";

		public ContainerStatsRunnable(HttpGet request, IContainerStatsListener listener) {
			this.listener = listener;
			this.request = request;
			this.gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
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
							listener.onContainerStatsReceived(stats);
							builder.setLength(0);
						}
						buffer.clear();
					}
				}
			} catch (IOException e) {
				Thread.currentThread().interrupt();
				message = e.getMessage();
			} finally {
				listener.onClosed(statusCode, message);
			}
		}
	}
}