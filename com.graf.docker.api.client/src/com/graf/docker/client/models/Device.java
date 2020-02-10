package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
