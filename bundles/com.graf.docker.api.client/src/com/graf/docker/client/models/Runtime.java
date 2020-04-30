package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Runtime {

	@SerializedName("path")
	private String path;
	@SerializedName("runtimeArgs")
	private List<String> runtimeArgs;

	public String getPath() {
		return path;
	}

	public List<String> getRuntimeArgs() {
		return runtimeArgs;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
