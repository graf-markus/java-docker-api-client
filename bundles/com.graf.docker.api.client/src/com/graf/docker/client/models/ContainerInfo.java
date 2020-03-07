package com.graf.docker.client.models;

import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerInfo {

	private String id;
	private Date created;
	private String path;
	private String[] args;
	private ContainerConfig containerConfig;
	private HostConfig hostConfig;
	private ContainerState state;
	private String image;
	private NetworkSettings networkSetting;
	private String hostnamePath;
	private String hostPath;
	private String name;
	private String driver;
	private String execDriver;
	private String mountLabel;
	private Map<String, String> volumes;
	private Map<String, Boolean> volumesRW;
	private String appArmorProfile;
	private String[] execIds;
	private String logPath;
	private long restartCount;
	private MountPoint[] mounts;
	private Node node;

	public String getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public String getPath() {
		return path;
	}

	public String[] getArgs() {
		return args;
	}

	public ContainerConfig getContainerConfig() {
		return containerConfig;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public ContainerState getState() {
		return state;
	}

	public String getImage() {
		return image;
	}

	public NetworkSettings getNetworkSetting() {
		return networkSetting;
	}

	public String getHostnamePath() {
		return hostnamePath;
	}

	public String getHostPath() {
		return hostPath;
	}

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}

	public String getExecDriver() {
		return execDriver;
	}

	public String getMountLabel() {
		return mountLabel;
	}

	public Map<String, String> getVolumes() {
		return volumes;
	}

	public Map<String, Boolean> getVolumesRW() {
		return volumesRW;
	}

	public String getAppArmorProfile() {
		return appArmorProfile;
	}

	public String[] getExecIds() {
		return execIds;
	}

	public String getLogPath() {
		return logPath;
	}

	public long getRestartCount() {
		return restartCount;
	}

	public MountPoint[] getMounts() {
		return mounts;
	}

	public Node getNode() {
		return node;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public class Node {

		private String id;
		private String ip;
		private String addr;
		private String name;

		public String getId() {
			return id;
		}

		public String getIp() {
			return ip;
		}

		public String getAddr() {
			return addr;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			return gson.toJson(this);
		}
	}
}
