package com.graf.docker.client.models;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class NetworkConfig {

	private String name;
	private boolean checkDuplicate;
	private String driver;
	private boolean internal;
	private boolean attachable;
	private boolean ingress;
	@SerializedName("IPAM")
	private IPAM ipam;
	@SerializedName("EnableIPv6")
	private boolean enableIpv6;
	private Map<String, String> options;
	private Map<String, String> labels;

	private NetworkConfig(Builder builder) {
		this.name = builder.name;
		this.checkDuplicate = builder.checkDuplicate;
		this.driver = builder.driver;
		this.internal = builder.internal;
		this.attachable = builder.attachable;
		this.ingress = builder.ingress;
		this.ipam = builder.ipam;
		this.enableIpv6 = builder.enableIpv6;
		this.options = builder.options;
		this.labels = builder.labels;
	}

	public String getName() {
		return name;
	}

	public boolean isCheckDuplicate() {
		return checkDuplicate;
	}

	public String getDriver() {
		return driver;
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

	public IPAM getIpam() {
		return ipam;
	}

	public boolean isEnableIpv6() {
		return enableIpv6;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public Map<String, String> getLabels() {
		return labels;
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

		private String name;
		private boolean checkDuplicate;
		private String driver;
		private boolean internal;
		private boolean attachable;
		private boolean ingress;
		private IPAM ipam;
		private boolean enableIpv6;
		private Map<String, String> options = new HashMap<>();
		private Map<String, String> labels = new HashMap<>();

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder checkDuplicate(boolean checkDuplicate) {
			this.checkDuplicate = checkDuplicate;
			return Builder.this;
		}

		public Builder driver(String driver) {
			this.driver = driver;
			return Builder.this;
		}

		public Builder internal(boolean internal) {
			this.internal = internal;
			return Builder.this;
		}

		public Builder attachable(boolean attachable) {
			this.attachable = attachable;
			return Builder.this;
		}

		public Builder ingress(boolean ingress) {
			this.ingress = ingress;
			return Builder.this;
		}

		public Builder ipam(IPAM ipam) {
			this.ipam = ipam;
			return Builder.this;
		}

		public Builder enableIpv6(boolean enableIpv6) {
			this.enableIpv6 = enableIpv6;
			return Builder.this;
		}

		public Builder options(Map<String, String> options) {
			this.options.putAll(options);
			return Builder.this;
		}

		public Builder options(String key, String value) {
			this.options.put(key, value);
			return Builder.this;
		}

		public Builder labels(Map<String, String> labels) {
			this.labels.putAll(labels);
			return Builder.this;
		}

		public Builder labels(String key, String value) {
			labels.put(key, value);
			return Builder.this;
		}

		public NetworkConfig build() {

			return new NetworkConfig(this);
		}
	}
}
