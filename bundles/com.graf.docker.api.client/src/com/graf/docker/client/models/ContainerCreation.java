package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerCreation {

	private String id;
	private String[] warnings;

	public String getId() {
		return id;
	}

	public String[] getWarnings() {
		return warnings;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
