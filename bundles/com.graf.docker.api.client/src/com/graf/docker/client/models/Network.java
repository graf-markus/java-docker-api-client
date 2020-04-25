package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Network {

	private String name;
	private String id;
	private String created;
	private String scope;
	private String driver;
	private boolean enableIPv6;
	private IPAM IPAM;
	private boolean internal;
	private boolean attachable;
	private boolean ingress;
	private Map<String, NetworkContainer> containers;
	private Map<String, String> options;
	private Map<String, String> labels;

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getCreated() {
		return created;
	}

	public String getScope() {
		return scope;
	}

	public String getDriver() {
		return driver;
	}

	public boolean isEnableIPv6() {
		return enableIPv6;
	}

	public IPAM getIPAM() {
		return IPAM;
	}

	public boolean isInternal() {
		return internal;
	}

	public boolean isAttachable() {
		return attachable;
	}

	public boolean isIngress() {
		return ingress;
	}

	public Map<String, NetworkContainer> getContainers() {
		return containers;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
