package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TopResults {

	private String[] titles;
	private String[] processes;

	public String[] getTitles() {
		return titles;
	}

	public String[] getProcesses() {
		return processes;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
