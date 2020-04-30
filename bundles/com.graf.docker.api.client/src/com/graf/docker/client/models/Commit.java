package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Commit {
	@SerializedName("ID")
	private String id;
	private String expected;

	public String getId() {
		return id;
	}

	public String getExpected() {
		return expected;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
