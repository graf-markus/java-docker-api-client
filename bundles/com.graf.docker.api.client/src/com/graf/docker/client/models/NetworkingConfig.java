package com.graf.docker.client.models;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NetworkingConfig {

	private Map<String, EndpointSettings> endpointsConfig;

	public Map<String, EndpointSettings> getEndpointsConfig() {
		return endpointsConfig;
	}

	private NetworkingConfig(Builder builder) {
		this.endpointsConfig = builder.endpointsConfig;
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

		private Map<String, EndpointSettings> endpointsConfig;

		public Builder() {
		}

		public Builder endpointsConfig(Map<String, EndpointSettings> endpointsConfig) {
			if (this.endpointsConfig == null) {
				this.endpointsConfig = new HashMap<>();
			}
			this.endpointsConfig.putAll(endpointsConfig);
			return Builder.this;
		}

		public Builder enpointsConfig(String key, EndpointSettings value) {
			if (this.endpointsConfig == null) {
				this.endpointsConfig = new HashMap<>();
			}
			this.endpointsConfig.put(key, value);
			return Builder.this;
		}

		public NetworkingConfig build() {
			return new NetworkingConfig(this);
		}
	}
}
