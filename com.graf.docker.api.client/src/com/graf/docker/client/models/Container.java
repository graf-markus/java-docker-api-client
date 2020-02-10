package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Container {

	private String id;
	private String[] names;
	private String image;
	private String imageID;
	private String command;
	private long created;
	private String state;
	private String status;
	private PortMapping[] ports;
	private Map<String, String> labels;
	private long sizeRw;
	private long sizeRootFs;
	private NetworkSettings networkSettings;
	private ContainerMount[] mounts;

	public String getId() {
		return id;
	}

	public String[] getNames() {
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

	public PortMapping[] getPorts() {
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

	public NetworkSettings getNetworkSettings() {
		return networkSettings;
	}

	public ContainerMount[] getMounts() {
		return mounts;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
	
	public class PortMapping {

		private int privatePort;
		private int publicPort;
		private String type;
		private String ip;

		public int getPrivatePort() {
			return privatePort;
		}

		public int getPublicPort() {
			return publicPort;
		}

		public String getType() {
			return type;
		}

		public String getIp() {
			return ip;
		}
		
		@Override
		public String toString() {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			return gson.toJson(this);
		}
	}
}
