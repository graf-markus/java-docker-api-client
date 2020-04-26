package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NetworkPruneResponse {

	private List<String> networksDeleted;

	public List<String> getNetworksDeleted() {
		return networksDeleted;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
