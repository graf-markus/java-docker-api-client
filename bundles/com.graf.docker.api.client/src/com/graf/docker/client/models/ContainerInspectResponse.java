package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ContainerInspectResponse {

	private String id;
	private String created;
	private String path;
	private List<String> args;
	private ContainerState state;
	private String image;
	private String resolveConfPath;
	private String hostnamePath;
	private String hostsPath;
	private String logPath;
	private Node node;
	private String name;
	private int restartCount;
	private String driver;
	private String platform;
	private String mountLabel;
	private String processLabel;
	private String appArmorProfile;
	private List<String> execIds;
	private HostConfig hostConfig;
	private GraphDriverData graphDriver;
	@SerializedName("SizeRW")
	private long sizeRw;
	private long sizeRootFs;
	private List<MountPoint> mounts;
	private ContainerConfig config;
	private NetworkSettings networkSetting;

	public String getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public String getPath() {
		return path;
	}

	public List<String> getArgs() {
		return args;
	}

	public ContainerState getState() {
		return state;
	}

	public String getImage() {
		return image;
	}

	public String getResolveConfPath() {
		return resolveConfPath;
	}

	public String getHostnamePath() {
		return hostnamePath;
	}

	public String getHostsPath() {
		return hostsPath;
	}

	public String getLogPath() {
		return logPath;
	}

	public Node getNode() {
		return node;
	}

	public String getName() {
		return name;
	}

	public int getRestartCount() {
		return restartCount;
	}

	public String getDriver() {
		return driver;
	}

	public String getPlatform() {
		return platform;
	}

	public String getMountLabel() {
		return mountLabel;
	}

	public String getProcessLabel() {
		return processLabel;
	}

	public String getAppArmorProfile() {
		return appArmorProfile;
	}

	public List<String> getExecIds() {
		return execIds;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public GraphDriverData getGraphDriver() {
		return graphDriver;
	}

	public long getSizeRw() {
		return sizeRw;
	}

	public long getSizeRootFs() {
		return sizeRootFs;
	}

	public List<MountPoint> getMounts() {
		return mounts;
	}

	public ContainerConfig getConfig() {
		return config;
	}

	public NetworkSettings getNetworkSetting() {
		return networkSetting;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
