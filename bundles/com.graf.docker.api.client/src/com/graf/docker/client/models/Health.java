package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Health {

	private String status;
	private int failingStreak;
	private List<HealthcheckResult> log;

	public String getStatus() {
		return status;
	}

	public int getFailingStreak() {
		return failingStreak;
	}

	public List<HealthcheckResult> getLog() {
		return log;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
