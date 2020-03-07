package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerCreateResponse {

	private String id;
	private List<String> warnings;

	public String getId() {
		return id;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
