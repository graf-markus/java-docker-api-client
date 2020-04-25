package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class DeviceRequest {

	private String driver;
	private int count;
	@SerializedName("DeviceIDs")
	private List<String> deviceIds;
	private List<List<String>> capabilities;
	private Map<String, String> options;

	private DeviceRequest(Builder builder) {
		this.driver = builder.driver;
		this.count = builder.count;
		this.deviceIds = builder.deviceIds;
		this.capabilities = builder.capabilities;
		this.options = builder.options;
	}

	public String getDriver() {
		return driver;
	}

	public int getCount() {
		return count;
	}

	public List<String> getDeviceIds() {
		return deviceIds;
	}

	public List<List<String>> getCapabilities() {
		return capabilities;
	}

	public Map<String, String> getOptions() {
		return options;
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

		private String driver;
		private int count;
		private List<String> deviceIds = new ArrayList<String>();
		private List<List<String>> capabilities = new ArrayList<>();
		private Map<String, String> options = new HashMap<>();

		public Builder() {
		}

		public Builder driver(String driver) {
			this.driver = driver;
			return Builder.this;
		}

		public Builder count(int count) {
			this.count = count;
			return Builder.this;
		}

		public Builder deviceIds(List<String> deviceIds) {
			this.deviceIds.addAll(deviceIds);
			return Builder.this;
		}

		public Builder deviceIds(String deviceIds) {
			this.deviceIds.add(deviceIds);
			return Builder.this;
		}

		public Builder deviceIds(String... deviceIds) {
			this.deviceIds.addAll(Arrays.asList(deviceIds));
			return Builder.this;
		}

		public Builder capabilities(List<String> capabilities) {
			this.capabilities.add(capabilities);
			return Builder.this;
		}

		public Builder options(Map<String, String> options) {
			this.options.putAll(options);
			return Builder.this;
		}

		public Builder option(String key, String value) {
			this.options.put(key, value);
			return Builder.this;
		}

		public DeviceRequest build() {

			return new DeviceRequest(this);
		}
	}
}
