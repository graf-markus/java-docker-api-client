package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

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
	
}
