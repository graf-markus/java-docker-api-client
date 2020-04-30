package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PluginInfo {

	private List<String> volume;
	private List<String> network;
	private List<String> authorization;
	private List<String> log;

	public List<String> getVolume() {
		return volume;
	}

	public List<String> getNetwork() {
		return network;
	}

	public List<String> getAuthorization() {
		return authorization;
	}

	public List<String> getLog() {
		return log;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
