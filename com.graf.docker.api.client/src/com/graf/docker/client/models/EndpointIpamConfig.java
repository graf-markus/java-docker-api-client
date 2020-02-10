package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EndpointIpamConfig {

	private String ipv4Address;
	private String ipv6Address;

	public String getIpv4Address() {
		return ipv4Address;
	}

	public String getIpv6Address() {
		return ipv6Address;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String ipv4Address;
		private String ipv6Address;

		public Builder() {
		}

		Builder(String ipv4Address, String ipv6Address) {
			this.ipv4Address = ipv4Address;
			this.ipv6Address = ipv6Address;
		}

		public Builder ipv4Address(String ipv4Address) {
			this.ipv4Address = ipv4Address;
			return Builder.this;
		}

		public Builder ipv6Address(String ipv6Address) {
			this.ipv6Address = ipv6Address;
			return Builder.this;
		}

		public EndpointIpamConfig build() {

			return new EndpointIpamConfig(this);
		}
	}

	private EndpointIpamConfig(Builder builder) {
		this.ipv4Address = builder.ipv4Address;
		this.ipv6Address = builder.ipv6Address;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
