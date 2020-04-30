package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class PeerNode {

	@SerializedName("NodeID")
	private String nodeId;
	private String addr;

	public String getNodeId() {
		return nodeId;
	}

	public String getAddr() {
		return addr;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
