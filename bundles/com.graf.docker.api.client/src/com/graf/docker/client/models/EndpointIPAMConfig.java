package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EndpointIPAMConfig {

	private String ipv4Address;
	private String ipv6Address;
	private List<String> linkLocalIPs;

	private EndpointIPAMConfig(Builder builder) {
		this.ipv4Address = builder.ipv4Address;
		this.ipv6Address = builder.ipv6Address;
		this.linkLocalIPs = builder.linkLocalIPs;
	}

	public String getIpv4Address() {
		return ipv4Address;
	}

	public String getIpv6Address() {
		return ipv6Address;
	}

	public List<String> getLinkLocalIPs() {
		return linkLocalIPs;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String ipv4Address;
		private String ipv6Address;
		private List<String> linkLocalIPs;

		public Builder() {
		}

		public Builder ipv4Address(String ipv4Address) {
			this.ipv4Address = ipv4Address;
			return Builder.this;
		}

		public Builder ipv6Address(String ipv6Address) {
			this.ipv6Address = ipv6Address;
			return Builder.this;
		}

		public Builder linkLocalIPs(List<String> linkLocalIPs) {
			if (this.linkLocalIPs == null) {
				this.linkLocalIPs = new ArrayList<>();
			}
			this.linkLocalIPs.addAll(linkLocalIPs);
			return Builder.this;
		}

		public Builder linkLocalIPs(String... linkLocalIPs) {
			if (this.linkLocalIPs == null) {
				this.linkLocalIPs = new ArrayList<>();
			}
			this.linkLocalIPs.addAll(Arrays.asList(linkLocalIPs));
			return Builder.this;
		}

		public EndpointIPAMConfig build() {

			return new EndpointIPAMConfig(this);
		}
	}
}
