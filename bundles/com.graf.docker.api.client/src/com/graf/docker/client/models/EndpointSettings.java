package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class EndpointSettings {

	@SerializedName("IPAMConfig")
	private EndpointIPAMConfig ipamConfig;
	private List<String> links;
	private List<String> aliases;
	@SerializedName("NetworkID")
	private String networkId;
	@SerializedName("EndpointID")
	private String endpointId;
	private String gateway;
	@SerializedName("IPAddress")
	private String ipAddress;
	@SerializedName("IPPrefixLen")
	private int ipPrefixLen;
	@SerializedName("IPv6Gateway")
	private String ipv6Gateway;
	@SerializedName("GlobalIPv6Address")
	private String globalIPv6Address;
	@SerializedName("GlobalIPv6PrefixLen")
	private int globalIPv6PrefixLen;
	private String macAddress;
	private Map<String, String> driverOpts;

	private EndpointSettings(Builder builder) {
		this.ipamConfig = builder.ipamConfig;
		this.links = builder.links;
		this.aliases = builder.aliases;
		this.networkId = builder.networkId;
		this.endpointId = builder.endpointId;
		this.gateway = builder.gateway;
		this.ipAddress = builder.ipAddress;
		this.ipPrefixLen = builder.ipPrefixLen;
		this.ipv6Gateway = builder.ipv6Gateway;
		this.globalIPv6Address = builder.globalIPv6Address;
		this.globalIPv6PrefixLen = builder.globalIPv6PrefixLen;
		this.macAddress = builder.macAddress;
		this.driverOpts = builder.driverOpts;
	}

	public EndpointIPAMConfig getIpamConfig() {
		return ipamConfig;
	}

	public List<String> getLinks() {
		return links;
	}

	public List<String> getAliases() {
		return aliases;
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

	public String getIpv6Gateway() {
		return ipv6Gateway;
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

	public String getNetworkId() {
		return networkId;
	}

	public String getEndpointId() {
		return endpointId;
	}

	public Map<String, String> getDriverOpts() {
		return driverOpts;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private EndpointIPAMConfig ipamConfig;
		private List<String> links;
		private List<String> aliases;
		private String networkId;
		private String endpointId;
		private String gateway;
		private String ipAddress;
		private int ipPrefixLen;
		private String ipv6Gateway;
		private String globalIPv6Address;
		private int globalIPv6PrefixLen;
		private String macAddress;
		private Map<String, String> driverOpts;

		public Builder() {
		}

		public Builder ipamConfig(EndpointIPAMConfig ipamConfig) {
			this.ipamConfig = ipamConfig;
			return Builder.this;
		}

		public Builder links(List<String> links) {
			this.links = links;
			return Builder.this;
		}

		public Builder links(String... links) {
			if (links.length < 0) {
				return Builder.this;
			}
			if (this.links != null) {
				this.links = new ArrayList<String>();
			}
			this.links.addAll(Arrays.asList(links));
			return Builder.this;
		}

		public Builder aliases(List<String> aliases) {
			this.aliases = aliases;
			return Builder.this;
		}

		public Builder aliases(String... aliases) {
			if (aliases.length < 0) {
				return Builder.this;
			}
			if (this.aliases != null) {
				this.aliases = new ArrayList<String>();
			}
			this.aliases.addAll(Arrays.asList(aliases));
			return Builder.this;
		}

		public Builder networkId(String networkId) {
			this.networkId = networkId;
			return Builder.this;
		}

		public Builder endpointId(String endpointId) {
			this.endpointId = endpointId;
			return Builder.this;
		}

		public Builder gateway(String gateway) {
			this.gateway = gateway;
			return Builder.this;
		}

		public Builder ipAddress(String ipAddress) {
			this.ipAddress = ipAddress;
			return Builder.this;
		}

		public Builder ipPrefixLen(int ipPrefixLen) {
			this.ipPrefixLen = ipPrefixLen;
			return Builder.this;
		}

		public Builder ipv6Gateway(String ipv6Gateway) {
			this.ipv6Gateway = ipv6Gateway;
			return Builder.this;
		}

		public Builder globalIPv6Address(String globalIPv6Address) {
			this.globalIPv6Address = globalIPv6Address;
			return Builder.this;
		}

		public Builder globalIPv6PrefixLen(int globalIPv6PrefixLen) {
			this.globalIPv6PrefixLen = globalIPv6PrefixLen;
			return Builder.this;
		}

		public Builder macAddress(String macAddress) {
			this.macAddress = macAddress;
			return Builder.this;
		}

		public Builder driverOpts(Map<String, String> driverOpts) {
			this.driverOpts = driverOpts;
			return Builder.this;
		}

		public Builder driverOpts(String key, String value) {
			if (this.driverOpts != null) {
				this.driverOpts = new HashMap<String, String>();
			}
			this.driverOpts.put(key, value);
			return Builder.this;
		}

		public EndpointSettings build() {
			return new EndpointSettings(this);
		}
	}
}
