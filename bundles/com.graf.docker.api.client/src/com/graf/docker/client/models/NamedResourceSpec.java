package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NamedResourceSpec implements ResourceSpec {
	private String kind;
	private String value;

	public String getKind() {
		return kind;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
