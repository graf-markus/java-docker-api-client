package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsageData {

	private int size;
	private int refCount;

	public int getSize() {
		return size;
	}

	public int getRefCount() {
		return refCount;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
