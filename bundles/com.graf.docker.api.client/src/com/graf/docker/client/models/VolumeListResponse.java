package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VolumeListResponse {

	private List<Volume> volumes;
	private List<String> wanrings;

	public List<Volume> getVolumes() {
		return volumes;
	}

	public List<String> getWanrings() {
		return wanrings;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
