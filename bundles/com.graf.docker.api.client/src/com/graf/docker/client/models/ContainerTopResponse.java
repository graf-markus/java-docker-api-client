package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerTopResponse {

	private List<String> titles;
	private List<List<String>> processes;

	public List<String> getTitles() {
		return titles;
	}

	public List<List<String>> getProcesses() {
		return processes;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
