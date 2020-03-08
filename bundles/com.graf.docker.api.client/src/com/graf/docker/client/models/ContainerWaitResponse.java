package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerWaitResponse {

	private int statusCode;
	private String error;

	public String getError() {
		return error;
	}

	public int getStatusCode() {
		return statusCode;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
