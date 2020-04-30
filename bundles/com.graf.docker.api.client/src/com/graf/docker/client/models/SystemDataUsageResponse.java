package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SystemDataUsageResponse {

	private long layerSize;
	private List<ImageSummary> images;
	private List<ContainerSummary> containers;
	private List<Volume> volumes;
	private List<BuildCache> buildCache;

	public long getLayerSize() {
		return layerSize;
	}

	public List<ImageSummary> getImages() {
		return images;
	}

	public List<ContainerSummary> getContainers() {
		return containers;
	}

	public List<Volume> getVolumes() {
		return volumes;
	}

	public List<BuildCache> getBuildCache() {
		return buildCache;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
