package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HealthcheckResult {

	private String start;
	private String end;
	private int exitCode;
	private String output;

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public int getExitCode() {
		return exitCode;
	}

	public String getOutput() {
		return output;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
