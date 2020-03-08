package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerPruneResponse {

	private List<String> containersDeleted;
	private long spaceReclaimed;

	public List<String> getContainersDeleted() {
		return containersDeleted;
	}

	public long getSpaceReclaimed() {
		return spaceReclaimed;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
