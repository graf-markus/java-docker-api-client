package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerChangeResponseItem {

	public static final int MODIFIED = 0;
	public static final int ADDED = 1;
	public static final int DELETED = 2;

	private String path;
	private byte kind;

	public String getPath() {
		return path;
	}

	public byte getKind() {
		return kind;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
