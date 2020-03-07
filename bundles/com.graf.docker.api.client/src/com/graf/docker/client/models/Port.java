package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Port {

	@SerializedName("IP")
	private String ip;
	private int privatePort;
	private int publicPort;
	private String type;

	public int getPrivatePort() {
		return privatePort;
	}

	public int getPublicPort() {
		return publicPort;
	}

	public String getType() {
		return type;
	}

	public String getIp() {
		return ip;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
