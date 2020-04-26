package com.graf.docker.client.models;

public class NetworkDisconnect {

	private String container;
	private boolean force;

	public NetworkDisconnect(String container, boolean force) {
		this.container = container;
		this.force = force;
	}
}
