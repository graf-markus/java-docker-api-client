package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NetworkSettings {

	private String ipAddress;
	private int ipPrefixLen;
	private String gateway;
	private String bridge;
	private Map<String, Map<String, String>> portMapping;
	private Map<String, List<PortBinding>> ports;
	private String macAddress;
	private Map<String, AttachedNetwork> networks;
	private String endpointId;
	private String sandboxId;
	private boolean hairpinMode;
	private String linkLocalIPv6Address;
	private int linkLocalIPv6PrefixLen;
	private String globalIPv6Address;
	private int globalIPv6PrefixLen;
	private String ipv6Gateway;

	public String getIpAddress() {
		return ipAddress;
	}

	public int getIpPrefixLen() {
		return ipPrefixLen;
	}

	public String getGateway() {
		return gateway;
	}

	public String getBridge() {
		return bridge;
	}

	public Map<String, Map<String, String>> getPortMapping() {
		return portMapping;
	}

	public Map<String, List<PortBinding>> getPorts() {
		return ports;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public Map<String, AttachedNetwork> getNetworks() {
		return networks;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getSandboxId() {
		return sandboxId;
	}

	public boolean isHairpinMode() {
		return hairpinMode;
	}

	public String getLinkLocalIPv6Address() {
		return linkLocalIPv6Address;
	}

	public int getLinkLocalIPv6PrefixLen() {
		return linkLocalIPv6PrefixLen;
	}

	public String getGlobalIPv6Address() {
		return globalIPv6Address;
	}

	public int getGlobalIPv6PrefixLen() {
		return globalIPv6PrefixLen;
	}

	public String getIpv6Gateway() {
		return ipv6Gateway;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
