package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ImagePruneResponse {

	private List<ImageDeleteResponseItem> imagesDeleted;
	private int spaceReclaimed;

	public List<ImageDeleteResponseItem> getImagesDeleted() {
		return imagesDeleted;
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
