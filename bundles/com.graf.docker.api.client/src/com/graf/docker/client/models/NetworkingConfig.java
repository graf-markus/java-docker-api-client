package com.graf.docker.client.models;

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

	public static class Builder {

		private Map<String, EndpointSettings> endpointsConfig;

		public Builder() {
		}

		Builder(Map<String, EndpointSettings> endpointsConfig) {
			this.endpointsConfig = endpointsConfig;
		}

		public Builder endpointsConfig(Map<String, EndpointSettings> endpointsConfig) {
			this.endpointsConfig = endpointsConfig;
			return Builder.this;
		}

		public NetworkingConfig build() {

			return new NetworkingConfig(this);
		}
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
