package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Dispatcher {

	private long heartbeatPeriod;

	public long getHeartbeatPeriod() {
		return heartbeatPeriod;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
