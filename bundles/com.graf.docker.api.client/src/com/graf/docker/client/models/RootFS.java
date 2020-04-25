package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RootFS {

	private String type;
	private List<String> layers;

	public String getType() {
		return type;
	}

	public List<String> getLayers() {
		return layers;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
