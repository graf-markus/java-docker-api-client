package com.graf.docker.client.builder;

import com.graf.docker.client.impl.DockerClient;
import com.graf.docker.client.interfaces.IDockerClient;

public class DockerClientBuilder {

	private String url = "http://localhost:2375";
	
	private DockerClientBuilder() {
		
	}

	public static DockerClientBuilder create() {
		return new DockerClientBuilder();
	}

	public DockerClientBuilder setUrl(String url) {
		this.url = url;
		return this;
	}
	
	public IDockerClient build() {
		return new DockerClient(url);
	}
}
