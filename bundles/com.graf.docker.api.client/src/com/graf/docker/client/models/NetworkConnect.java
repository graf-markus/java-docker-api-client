package com.graf.docker.client.models;

public class NetworkConnect {

	private String container;
	private EndpointSettings endpointConfig;

	public NetworkConnect(String container) {
		this.container = container;
	}

	public NetworkConnect(String container, EndpointSettings endpoint) {
		this.container = container;
		this.endpointConfig = endpoint;
	}
}
