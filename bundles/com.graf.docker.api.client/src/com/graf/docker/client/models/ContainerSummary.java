package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerSummary {

	private String id;
	private List<String> names;
	private String image;
	private String imageID;
	private String command;
	private long created;
	private List<Port> ports;
	private long sizeRw;
	private long sizeRootFs;
	private Map<String, String> labels;
	private String state;
	private String status;
	private HostConfig hostConfig;
	private NetworkSettings networkSettings;
	private List<Mount> mounts;

	public String getId() {
		return id;
	}

	public List<String> getNames() {
		return names;
	}

	public String getImage() {
		return image;
	}

	public String getImageId() {
		return imageID;
	}

	public String getCommand() {
		return command;
	}

	public long getCreated() {
		return created;
	}

	public String getState() {
		return state;
	}

	public String getStatus() {
		return status;
	}

	public List<Port> getPorts() {
		return ports;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public long getSizeRw() {
		return sizeRw;
	}

	public long getSizeRootFs() {
		return sizeRootFs;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public List<Mount> getMounts() {
		return mounts;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	class HostConfig {

		private String networkMode;

		public String getNetworkMode() {
			return networkMode;
		}
	}

	class NetworkSettings {
		private Map<String, EndpointSettings> networks;

		public Map<String, EndpointSettings> getNetworks() {
			return networks;
		}
	}
}
