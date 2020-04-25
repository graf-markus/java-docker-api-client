package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class NetworkContainer {

	private String name;
	@SerializedName("EndpointID")
	private String endpointId;
	private String macAddress;
	@SerializedName("IPv4Adress")
	private String ipv4Address;
	@SerializedName("IPv6Address")
	private String ipv6Address;

	public String getName() {
		return name;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public String getIpv4Address() {
		return ipv4Address;
	}

	public String getIpv6Address() {
		return ipv6Address;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
