package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerExit {

	private String error;
	private int statusCode;

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
