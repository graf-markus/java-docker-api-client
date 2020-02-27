package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ImageClearedCache {

	private String cachesDeleted;
	private int spaceReclaimed;

	public String getCachesDeleted() {
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
