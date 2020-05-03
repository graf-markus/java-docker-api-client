package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class SwarmInfo {

	@SerializedName("NodeID")
	private String nodeId;
	private String nodeAddr;
	private String localNodeState;
	private boolean controlAvailable;
	private String error;
	private List<PeerNode> remoteManagers;
	private int nodes;
	private int managers;
	private ClusterInfo cluster;

	public String getNodeId() {
		return nodeId;
	}

	public String getNodeAddr() {
		return nodeAddr;
	}

	public String getLocalNodeState() {
		return localNodeState;
	}

	public boolean isControlAvailable() {
		return controlAvailable;
	}

	public String getError() {
		return error;
	}

	public List<PeerNode> getRemoteManagers() {
		return remoteManagers;
	}

	public int getNodes() {
		return nodes;
	}

	public int getManagers() {
		return managers;
	}

	public ClusterInfo getCluster() {
		return cluster;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
