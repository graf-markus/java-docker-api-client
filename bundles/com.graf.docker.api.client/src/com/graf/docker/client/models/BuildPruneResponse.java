package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BuildPruneResponse {

	private List<String> cachesDeleted;
	private int spaceReclaimed;

	public List<String> getCachesDeleted() {
		return cachesDeleted;
	}

	public int getSpaceReclaimed() {
		return spaceReclaimed;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
