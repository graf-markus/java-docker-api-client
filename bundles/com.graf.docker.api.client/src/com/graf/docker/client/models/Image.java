package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Image {

	private String id;
	private List<String> repoTags;
	private List<String> repoDigest;
	private String parent;
	private String comment;
	private String created;
	private String container;
	private ContainerConfig containerConfig;
	private String dockerVersion;
	private String author;
	private ContainerConfig config;
	private String architecture;
	private String os;
	private String osVersion;
	private long size;
	private long virtualSize;
	private GraphDriverData graphDriver;
	private RootFS rootFS;
	private Metadata metadata;

	public String getId() {
		return id;
	}

	public List<String> getRepoTags() {
		return repoTags;
	}

	public List<String> getRepoDigest() {
		return repoDigest;
	}

	public String getParent() {
		return parent;
	}

	public String getComment() {
		return comment;
	}

	public String getCreated() {
		return created;
	}

	public String getContainer() {
		return container;
	}

	public ContainerConfig getContainerConfig() {
		return containerConfig;
	}

	public String getDockerVersion() {
		return dockerVersion;
	}

	public String getAuthor() {
		return author;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public String getArchitecture() {
		return architecture;
	}

	public String getOs() {
		return os;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public long getSize() {
		return size;
	}

	public long getVirtualSize() {
		return virtualSize;
	}

	public GraphDriverData getGraphDriver() {
		return graphDriver;
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

	class Metadata {
		private String lastTagTime;

		public String getLastTagTime() {
			return lastTagTime;
		}
	}
}
