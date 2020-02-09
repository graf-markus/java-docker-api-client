package com.graf.docker.client.models;

public class Device {

	private String pathOnHost;
	private String pathInContainer;
	private String cgroupPermissions;

	public String getPathOnHost() {
		return pathOnHost;
	}

	public String getPathInContainer() {
		return pathInContainer;
	}

	public String getCgroupPermissions() {
		return cgroupPermissions;
	}
}
