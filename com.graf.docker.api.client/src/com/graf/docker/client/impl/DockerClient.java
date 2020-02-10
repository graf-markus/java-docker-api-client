package com.graf.docker.client.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.exceptions.ExceptionMessage;
import com.graf.docker.client.interfaces.IDockerClient;
import com.graf.docker.client.models.Container;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreation;
import com.graf.docker.client.models.ContainerInfo;
import com.graf.docker.client.models.ContainersDeletedInfo;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.TopResults;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.Param;
import com.graf.docker.client.params.RemoveContainersParam;

public class DockerClient implements IDockerClient {

	private CloseableHttpClient client;
	private String url;
	private Gson gson;

	public DockerClient(String url) {
		this.url = url;
		client = HttpClients.createDefault();
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
	}

	@Override
	public List<Container> listContainers(final ListContainersParam... params) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath("json")
				.addParameters(params).build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == 200) {
				Container[] containers = gson.fromJson(jsonEntity, Container[].class);
				return new ArrayList<Container>(Arrays.asList(containers));
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public ContainerInfo inspectContainer(String containerId) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("Containers").addPath(containerId)
				.addPath("json").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == 200) {
				ContainerInfo info = gson.fromJson(jsonEntity, ContainerInfo.class);
				return info;
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public ContainerCreation createContainer(ContainerConfig config) throws DockerException {
		HttpPost request = new HttpPost(
				RequestBuilder.builder().setUrl(url).addPath("containers").addPath("create").build());
		try {
			request.setHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(gson.toJson(config)));
		} catch (UnsupportedEncodingException e) {
			throw new DockerException(e.getMessage());
		}
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == 201) {
				ContainerCreation creation = gson.fromJson(jsonEntity, ContainerCreation.class);
				return creation;
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
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
				builder.setUrl(url).addPath("container").addPath(containerId).addPath("top").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == 200) {
				TopResults top = gson.fromJson(jsonEntity, TopResults.class);
				return top;
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void statContainer(String containerId) throws DockerException {
		HttpGet request = new HttpGet(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("stats").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
			int len = 0;
			while ((len = reader.read()) != -1) {
				System.out.print((char) len);
			}
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	public void startContainer(String containerId) throws DockerException {

		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("start").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			if (statusCode == 304) {
				throw new DockerException(String.format("container with id %s already started", containerId),
						statusCode);
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
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
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			if (statusCode == 304) {
				throw new DockerException(String.format("container with id %s already stopped", containerId),
						statusCode);
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void restartContainer(String containerId) throws DockerException {
		this.stopContainer(containerId, 0);
	}

	@Override
	public void restartContainer(String containerId, int timeToWaitMillis) throws DockerException {
		this.stopContainer(containerId, timeToWaitMillis, TimeUnit.MILLISECONDS);
	}

	@Override
	public void restartContainer(String containerId, int time, TimeUnit unit) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("restart").addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void killContainer(String containerId, KillSignal signal) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("kill").addParameter("signal", signal.toString()).build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void pauseContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("pause").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void unpauseContainer(String containerId) throws DockerException {
		HttpPost request = new HttpPost(RequestBuilder.builder().setUrl(url).addPath("containers").addPath(containerId)
				.addPath("unpause").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException {
		HttpDelete request = new HttpDelete(RequestBuilder.builder().setUrl(url).addPath("containers")
				.addPath(containerId).addParameters(params).build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 204) {
				return;
			}
			String jsonEntity = EntityUtils.toString(response.getEntity());
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
	}

	@Override
	public ContainersDeletedInfo deleteContainers() throws DockerException {

		HttpPost request = new HttpPost(
				RequestBuilder.builder().setUrl(url).addPath("containers").addPath("prune").build());
		try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
			int statusCode = response.getStatusLine().getStatusCode();
			String jsonEntity = EntityUtils.toString(response.getEntity());
			if (statusCode == 200) {
				return gson.fromJson(jsonEntity, ContainersDeletedInfo.class);
			}
			throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
		} catch (IOException e) {
			throw new DockerException(e.getMessage());
		}
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

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}
}
