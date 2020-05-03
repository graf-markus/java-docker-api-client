package com.graf.docker.client.models;

public class NetworkConnect {

	private String container;
	private EndpointSettings endpointConfig;

	private NetworkConnect(Builder builder) {
		this.container = builder.container;
		this.endpointConfig = builder.endpointConfig;
	}

	public String getContainer() {
		return container;
	}

	public EndpointSettings getEndpointConfig() {
		return endpointConfig;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String container;
		private EndpointSettings endpointConfig;

		public Builder() {
		}

		public Builder container(String container) {
			this.container = container;
			return Builder.this;
		}

		public Builder endpointConfig(EndpointSettings endpointConfig) {
			this.endpointConfig = endpointConfig;
			return Builder.this;
		}

		public NetworkConnect build() {
			return new NetworkConnect(this);
		}
	}
}
