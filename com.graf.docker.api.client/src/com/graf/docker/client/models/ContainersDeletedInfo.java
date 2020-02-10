package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainersDeletedInfo {

	private String[] containersDeleted;
	private int spaceReclaimed;

	public String[] getContainersDeleted() {
		return containersDeleted;
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
