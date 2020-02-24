package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Image {

	private String id;
	private String parentId;
	private List<String> repoTags;
	private int created;
	private int size;
	private int sharedSize;
	private int virtualSize;
	private Map<String, String> labels;
	private int containers;

	public String getId() {
		return id;
	}

	public String getParentId() {
		return parentId;
	}

	public List<String> getRepoTags() {
		return repoTags;
	}

	public int getCreated() {
		return created;
	}

	public int getSize() {
		return size;
	}

	public int getSharedSize() {
		return sharedSize;
	}

	public int getVirtualSize() {
		return virtualSize;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public int getContainers() {
		return containers;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
