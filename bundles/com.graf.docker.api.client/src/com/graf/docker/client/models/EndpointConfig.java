package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EndpointConfig {

	private EndpointIpamConfig ipamConfig;
	private String[] links;
	private String[] aliases;
	private String gateway;
	private String ipAddress;
	private int ipPrefixLeng;
	private String ipv6GAteway;
	private String globalIPv6Address;
	private int globalIPv6PrefixLen;
	private String macAddress;

	public EndpointIpamConfig getIpamConfig() {
		return ipamConfig;
	}

	public String[] getLinks() {
		return links;
	}

	public String[] getAliases() {
		return aliases;
	}

	public String getGateway() {
		return gateway;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public int getIpPrefixLeng() {
		return ipPrefixLeng;
	}

	public String getIpv6GAteway() {
		return ipv6GAteway;
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private EndpointIpamConfig ipamConfig;
		private String[] links;
		private String[] aliases;
		private String gateway;
		private String ipAddress;
		private int ipPrefixLeng;
		private String ipv6GAteway;
		private String globalIPv6Address;
		private int globalIPv6PrefixLen;
		private String macAddress;

		public Builder() {
		}

		Builder(EndpointIpamConfig ipamConfig, String[] links, String[] aliases, String gateway, String ipAddress,
				int ipPrefixLeng, String ipv6GAteway, String globalIPv6Address, int globalIPv6PrefixLen,
				String macAddress) {
			this.ipamConfig = ipamConfig;
			this.links = links;
			this.aliases = aliases;
			this.gateway = gateway;
			this.ipAddress = ipAddress;
			this.ipPrefixLeng = ipPrefixLeng;
			this.ipv6GAteway = ipv6GAteway;
			this.globalIPv6Address = globalIPv6Address;
			this.globalIPv6PrefixLen = globalIPv6PrefixLen;
			this.macAddress = macAddress;
		}

		public Builder ipamConfig(EndpointIpamConfig ipamConfig) {
			this.ipamConfig = ipamConfig;
			return Builder.this;
		}

		public Builder links(String[] links) {
			this.links = links;
			return Builder.this;
		}

		public Builder aliases(String[] aliases) {
			this.aliases = aliases;
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

		public Builder ipPrefixLeng(int ipPrefixLeng) {
			this.ipPrefixLeng = ipPrefixLeng;
			return Builder.this;
		}

		public Builder ipv6GAteway(String ipv6GAteway) {
			this.ipv6GAteway = ipv6GAteway;
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

		public EndpointConfig build() {

			return new EndpointConfig(this);
		}
	}

	private EndpointConfig(Builder builder) {
		this.ipamConfig = builder.ipamConfig;
		this.links = builder.links;
		this.aliases = builder.aliases;
		this.gateway = builder.gateway;
		this.ipAddress = builder.ipAddress;
		this.ipPrefixLeng = builder.ipPrefixLeng;
		this.ipv6GAteway = builder.ipv6GAteway;
		this.globalIPv6Address = builder.globalIPv6Address;
		this.globalIPv6PrefixLen = builder.globalIPv6PrefixLen;
		this.macAddress = builder.macAddress;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
