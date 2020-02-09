package com.graf.docker.client.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
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

	private static final Logger LOGGER = Logger.getLogger(DockerClient.class.getName());
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
		try {
			URIBuilder uriBuilder = new URIBuilder();
			addParameters(uriBuilder, params);
			URI uri = uriBuilder.setPath(new RequestPathBuilder(url).addPath("containers").addPath("json").build()).build();
			HttpGet request = new HttpGet(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 200) {
					String jsonEntity = EntityUtils.toString(response.getEntity());
					Container[] containers = gson.fromJson(jsonEntity, Container[].class);
					return new ArrayList<Container>(Arrays.asList(containers));
				}
				throw new DockerException("", statusCode);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "", e);
			}
		} catch (URISyntaxException e) {
			LOGGER.log(Level.SEVERE, "", e);
		}
		return null;
	}

	@Override
	public ContainerInfo inspectContainer(String containerId) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder().setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("json").build());
			URI uri = uriBuilder.build();
			HttpGet request = new HttpGet(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				String jsonEntity = EntityUtils.toString(response.getEntity());
				if (statusCode == 200) {
					ContainerInfo info = gson.fromJson(jsonEntity, ContainerInfo.class);
					return info;
				}
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "", e);
			}
		} catch (URISyntaxException e) {
			LOGGER.log(Level.SEVERE, "", e);
		}
		return null;
	}

	@Override
	public ContainerCreation createContainer(ContainerConfig config) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(new RequestPathBuilder(url).addPath("containers").addPath("create").build()).build();
			HttpPost request = new HttpPost(uri);
			request.setHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(gson.toJson(config)));
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				String jsonEntity = EntityUtils.toString(response.getEntity());
				if (statusCode == 201) {
					ContainerCreation creation = gson.fromJson(jsonEntity, ContainerCreation.class);
					return creation;
				}
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, "", e);
			}
		} catch (URISyntaxException | UnsupportedEncodingException e) {
			LOGGER.log(Level.SEVERE, "", e);
		}
		return null;
	}

	@Override
	public TopResults topContainer(String containerId, String psargs) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("top").build());
			uriBuilder.addParameter("ps_args", psargs);
			URI uri = uriBuilder.build();
			HttpGet request = new HttpGet(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				String jsonEntity = EntityUtils.toString(response.getEntity());
				if (statusCode == 200) {
					TopResults top = gson.fromJson(jsonEntity, TopResults.class);
					return top;
				}
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {

		}
		return null;
	}

	public void startContainer(String containerId) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("start").build())
					.build();
			HttpPost request = new HttpPost(uri);
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
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {

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
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("stop").build())
					.addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build();
			HttpPost request = new HttpPost(uri);
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
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
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
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("restart").build())
					.addParameter("t", String.valueOf(((int) unit.toSeconds(time)))).build();
			HttpPost request = new HttpPost(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 204) {
					return;
				}
				String jsonEntity = EntityUtils.toString(response.getEntity());
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void killContainer(String containerId, KillSignal signal) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("kill").build())
					.addParameter("signal", signal.toString()).build();
			HttpPost request = new HttpPost(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 204) {
					return;
				}
				String jsonEntity = EntityUtils.toString(response.getEntity());
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void pauseContainer(String containerId) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("pause").build())
					.build();
			HttpPost request = new HttpPost(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 204) {
					return;
				}
				String jsonEntity = EntityUtils.toString(response.getEntity());
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unpauseContainer(String containerId) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(
					new RequestPathBuilder(url).addPath("containers").addPath(containerId).addPath("unpause").build())
					.build();
			HttpPost request = new HttpPost(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 204) {
					return;
				}
				String jsonEntity = EntityUtils.toString(response.getEntity());
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			addParameters(uriBuilder, params);
			URI uri = uriBuilder.setPath(new RequestPathBuilder(url).addPath("containers").addPath(containerId).build())
					.build();
			HttpDelete request = new HttpDelete(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				if (statusCode == 204) {
					return;
				}
				String jsonEntity = EntityUtils.toString(response.getEntity());
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ContainersDeletedInfo deleteContainers() throws DockerException {
		try {
			URIBuilder uriBuilder = new URIBuilder();
			URI uri = uriBuilder.setPath(new RequestPathBuilder(url).addPath("containers").addPath("prune").build())
					.build();
			HttpPost request = new HttpPost(uri);
			try (CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request)) {
				int statusCode = response.getStatusLine().getStatusCode();
				String jsonEntity = EntityUtils.toString(response.getEntity());
				if (statusCode == 200) {
					return gson.fromJson(jsonEntity, ContainersDeletedInfo.class);
				}
				throw new DockerException(gson.fromJson(jsonEntity, ExceptionMessage.class).getMessage(), statusCode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

	private URIBuilder addParameters(URIBuilder builder, final Param... params) {
		for (final Param param : params) {
			builder.addParameter(param.name(), param.value());
		}
		return builder;
	}

	class RequestPathBuilder {

		private StringBuilder pathBuilder;

		public RequestPathBuilder(String url) {
			pathBuilder = new StringBuilder(url);
		}

		public RequestPathBuilder addPath(String path) {
			pathBuilder.append("/" + path);
			return this;
		}

		public String build() {
			return pathBuilder.toString();
		}
	}
}
