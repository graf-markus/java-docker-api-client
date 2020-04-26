package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Volume {
	private String name;
	private String driver;
	private String mountPoint;
	private String createdAt;
	private Map<String, String> status;
	private Map<String, String> labels;
	private String scope;
	private Map<String, String> options;
	private UsageData usageData;

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}

	public String getMountPoint() {
		return mountPoint;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public Map<String, String> getStatus() {
		return status;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public String getScope() {
		return scope;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public UsageData getUsageData() {
		return usageData;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
