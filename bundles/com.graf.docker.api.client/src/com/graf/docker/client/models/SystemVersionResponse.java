package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class SystemVersionResponse {

	private Platform platform;
	private List<Component> components;
	private String version;
	private String apiVersion;
	@SerializedName("MinAPIVersion")
	private String minApiVersion;
	private String gitCommit;
	private String goVersion;
	private String os;
	private String arch;
	private String kernelVersion;
	private boolean experimental;
	private String buildTime;

	public Platform getPlatform() {
		return platform;
	}

	public List<Component> getComponents() {
		return components;
	}

	public String getVersion() {
		return version;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public String getMinApiVersion() {
		return minApiVersion;
	}

	public String getGitCommit() {
		return gitCommit;
	}

	public String getGoVersion() {
		return goVersion;
	}

	public String getOs() {
		return os;
	}

	public String getArch() {
		return arch;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}

	public boolean isExperimental() {
		return experimental;
	}

	public String getBuildTime() {
		return buildTime;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
