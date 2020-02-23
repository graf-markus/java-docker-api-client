package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerUpdate {

	private List<String> warnings;

	public List<String> getWarnings() {
		return warnings;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
