package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Component {
	private String name;
	private String version;
	private Object details;

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public Object getDetails() {
		return details;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
