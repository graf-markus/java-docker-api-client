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
		private Map<String, String> driverOpts = new HashMap<>();
		private Map<String, String> labels = new HashMap<>();

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
			this.driverOpts.putAll(driverOpts);
			return Builder.this;
		}

		public Builder driverOpts(String key, String value) {
			this.driverOpts.put(key, value);
			return Builder.this;
		}

		public Builder labels(Map<String, String> labels) {
			this.labels.putAll(labels);
			return Builder.this;
		}

		public Builder labels(String key, String value) {
			this.labels.put(key, value);
			return Builder.this;
		}

		public VolumeConfig build() {
			return new VolumeConfig(this);
		}
	}
}
