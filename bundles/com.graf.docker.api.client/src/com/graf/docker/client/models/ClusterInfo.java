package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ClusterInfo {

	@SerializedName("ID")
	private String id;
	private ObjectVersion version;
	private String createdAt;
	private SwarmSpec spec;
	@SerializedName("TLSInfo")
	private TLSInfo tlsInfo;
	private boolean rootRotationInProgress;
	private int dataPathPort;
	private List<String> defaultAddrPool;
	private int subnetSize;

	public String getId() {
		return id;
	}

	public ObjectVersion getVersion() {
		return version;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public SwarmSpec getSpec() {
		return spec;
	}

	public TLSInfo getTlsInfo() {
		return tlsInfo;
	}

	public boolean isRootRotationInProgress() {
		return rootRotationInProgress;
	}

	public int getDataPathPort() {
		return dataPathPort;
	}

	public List<String> getDefaultAddrPool() {
		return defaultAddrPool;
	}

	public int getSubnetSize() {
		return subnetSize;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
