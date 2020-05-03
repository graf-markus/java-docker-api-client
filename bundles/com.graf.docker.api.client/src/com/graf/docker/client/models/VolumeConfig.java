package com.graf.docker.client.models;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VolumeConfig {

	private String name;
	private String driver;
	private Map<String, String> driverOpts;
	private Map<String, String> labels;

	private VolumeConfig(Builder builder) {
		this.name = builder.name;
		this.driver = builder.driver;
		this.driverOpts = builder.driverOpts;
		this.labels = builder.labels;
	}

	public String getName() {
		return name;
	}

	public String getDriver() {
		return driver;
	}

	public Map<String, String> getDriverOpts() {
		return driverOpts;
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
		private String driver;
		private Map<String, String> driverOpts;
		private Map<String, String> labels;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder driver(String driver) {
			this.driver = driver;
			return Builder.this;
		}

		public Builder driverOpts(Map<String, String> driverOpts) {
			if (this.driverOpts == null) {
				this.driverOpts = new HashMap<>();
			}
			this.driverOpts.putAll(driverOpts);
			return Builder.this;
		}

		public Builder driverOpts(String key, String value) {
			if (this.driverOpts == null) {
				this.driverOpts = new HashMap<>();
			}
			this.driverOpts.put(key, value);
			return Builder.this;
		}

		public Builder labels(Map<String, String> labels) {
			if (this.labels == null) {
				this.labels = new HashMap<>();
			}
			this.labels.putAll(labels);
			return Builder.this;
		}

		public Builder labels(String key, String value) {
			if (this.labels == null) {
				this.labels = new HashMap<>();
			}
			this.labels.put(key, value);
			return Builder.this;
		}

		public VolumeConfig build() {
			return new VolumeConfig(this);
		}
	}
}
