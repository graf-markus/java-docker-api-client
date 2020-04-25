package com.graf.docker.client.interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NetworkCreateResponse {

	private String id;
	private String warning;

	public String getId() {
		return id;
	}

	public String getWarning() {
		return warning;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
