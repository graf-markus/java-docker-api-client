package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ImageDeleteResponseItem {

	private String untagged;
	private String deleted;

	public String getUntagged() {
		return untagged;
	}

	public String getDeleted() {
		return deleted;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
