package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ImageInfo {

	private String id;
	private String container;
	private String os;
	private String architecture;
	private String parent;
	private ContainerConfig containerConfig;
	private String dokcerVersion;
	private long virtualSize;
	private long size;
	private String author;
	private GraphDriver graphDriver;
	private List<String> repoDigest;
	private List<String> repoTags;
	private ContainerConfig config;
	private RootFS rootFS;
	private Metadata metadata;

	public String getId() {
		return id;
	}

	public String getContainer() {
		return container;
	}

	public String getOs() {
		return os;
	}

	public String getArchitecture() {
		return architecture;
	}

	public String getParent() {
		return parent;
	}

	public ContainerConfig getContainerConfig() {
		return containerConfig;
	}

	public String getDokcerVersion() {
		return dokcerVersion;
	}

	public long getVirtualSize() {
		return virtualSize;
	}

	public long getSize() {
		return size;
	}

	public String getAuthor() {
		return author;
	}

	public GraphDriver getGraphDriver() {
		return graphDriver;
	}

	public List<String> getRepoDigest() {
		return repoDigest;
	}

	public List<String> getRepoTags() {
		return repoTags;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public RootFS getRootFS() {
		return rootFS;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	class GraphDriver {
		private String name;
		private Map<String, String> data;

		public String getName() {
			return name;
		}

		public Map<String, String> getData() {
			return data;
		}
	}

	class Metadata {
		private String lastTagTime;

		public String getLastTagTime() {
			return lastTagTime;
		}
	}
}
