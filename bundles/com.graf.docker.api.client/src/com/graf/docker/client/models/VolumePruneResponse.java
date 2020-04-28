package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VolumePruneResponse {

	private List<String> volmesDeleted;
	private long spaceReclaimed;

	public List<String> getVolmesDeleted() {
		return volmesDeleted;
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
