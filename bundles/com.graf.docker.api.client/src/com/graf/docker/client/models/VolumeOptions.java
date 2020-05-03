package com.graf.docker.client.models;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VolumeOptions {

	private boolean noCopy;
	private Map<String, String> labels;
	private DriverConfig driverConfig;

	private VolumeOptions(Builder builder) {
		this.noCopy = builder.noCopy;
		this.labels = builder.labels;
		this.driverConfig = builder.driverConfig;
	}

	public boolean isNoCopy() {
		return noCopy;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public DriverConfig getDriverConfig() {
		return driverConfig;
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

		private boolean noCopy;
		private Map<String, String> labels;
		private DriverConfig driverConfig;

		public Builder() {
		}

		public Builder noCopy(boolean noCopy) {
			this.noCopy = noCopy;
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

		public Builder driverConfig(DriverConfig driverConfig) {
			this.driverConfig = driverConfig;
			return Builder.this;
		}

		public VolumeOptions build() {
			return new VolumeOptions(this);
		}
	}
}
