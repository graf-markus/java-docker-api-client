package com.graf.docker.client.models;

public class NetworkDisconnect {

	private String container;
	private boolean force;

	private NetworkDisconnect(Builder builder) {
		this.container = builder.container;
		this.force = builder.force;
	}

	public String getContainer() {
		return container;
	}

	public boolean isForce() {
		return force;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String container;
		private boolean force;

		public Builder() {
		}

		public Builder container(String container) {
			this.container = container;
			return Builder.this;
		}

		public Builder force(boolean force) {
			this.force = force;
			return Builder.this;
		}

		public NetworkDisconnect build() {
			return new NetworkDisconnect(this);
		}
	}
}
