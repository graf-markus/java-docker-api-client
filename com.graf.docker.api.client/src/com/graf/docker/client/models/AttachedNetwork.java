package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AttachedNetwork {

	private String aliases;
	private String networkId;
	private String endpointId;
	private String gateway;
	private String ipAddress;
	private int ipPrefixLen;
	private String ipV6Gateway;
	private String globalIPv6Address;
	private int globalIPv6PrefixLen;
	private String macAddress;

	public String getAliases() {
		return aliases;
	}

	public String getNetworkId() {
		return networkId;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getGateway() {
		return gateway;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getIpPrefixLen() {
		return ipPrefixLen;
	}

	public String getIpV6Gateway() {
		return ipV6Gateway;
	}

	public String getGlobalIPv6Address() {
		return globalIPv6Address;
	}

	public int getGlobalIPv6PrefixLen() {
		return globalIPv6PrefixLen;
	}

	public String getMacAddress() {
		return macAddress;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
