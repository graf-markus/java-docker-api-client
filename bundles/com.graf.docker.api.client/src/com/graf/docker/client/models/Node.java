package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Node {
	private String id;
	private String ip;
	private String addr;
	private String name;

	public String getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

	public String getAddr() {
		return addr;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
