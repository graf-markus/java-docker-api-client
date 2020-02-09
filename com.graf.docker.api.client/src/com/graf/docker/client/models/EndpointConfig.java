package com.graf.docker.client.models;

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

	public class EndpointIpamConfig {

		private String ipv4Address;
		private String ipv6Address;

		public String getIpv4Address() {
			return ipv4Address;
		}

		public String getIpv6Address() {
			return ipv6Address;
		}

	}
}
