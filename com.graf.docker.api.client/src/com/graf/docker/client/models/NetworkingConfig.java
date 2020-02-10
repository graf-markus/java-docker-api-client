package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NetworkingConfig {

	private Map<String, EndpointConfig> endpointsConfig;

	public Map<String, EndpointConfig> getEndpointsConfig() {
		return endpointsConfig;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Map<String, EndpointConfig> endpointsConfig;

		public Builder() {
		}

		Builder(Map<String, EndpointConfig> endpointsConfig) {
			this.endpointsConfig = endpointsConfig;
		}

		public Builder endpointsConfig(Map<String, EndpointConfig> endpointsConfig) {
			this.endpointsConfig = endpointsConfig;
			return Builder.this;
		}

		public NetworkingConfig build() {

			return new NetworkingConfig(this);
		}
	}

	private NetworkingConfig(Builder builder) {
		this.endpointsConfig = builder.endpointsConfig;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
