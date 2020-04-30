package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class BuildCache {
	@SerializedName("ID")
	private String id;
	private String parent;
	private String type;
	private String description;
	private boolean inUse;
	private boolean shared;
	private int size;
	private int createdAt;
	private int lastUsedAt;
	private int usageCount;

	public String getId() {
		return id;
	}

	public String getParent() {
		return parent;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public boolean isInUse() {
		return inUse;
	}

	public boolean isShared() {
		return shared;
	}

	public int getSize() {
		return size;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public int getLastUsedAt() {
		return lastUsedAt;
	}

	public int getUsageCount() {
		return usageCount;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
