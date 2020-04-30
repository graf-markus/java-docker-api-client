package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogDriver {

	private String name;
	private Map<String, String> options;

	public String getName() {
		return name;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
