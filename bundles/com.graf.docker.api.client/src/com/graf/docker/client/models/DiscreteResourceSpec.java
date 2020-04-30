package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DiscreteResourceSpec implements ResourceSpec {

	private String kind;
	private long value;

	public String getKind() {
		return kind;
	}

	public long getValue() {
		return value;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
