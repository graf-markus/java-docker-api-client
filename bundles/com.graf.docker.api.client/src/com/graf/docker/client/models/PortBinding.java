package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PortBinding {

	private String hostIp;
	private String hostPort;

	public String getHostIp() {
		return hostIp;
	}

	public String getHostPort() {
		return hostPort;
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

		private String hostIp;
		private String hostPort;

		public Builder() {
		}

		public Builder hostIp(String hostIp) {
			this.hostIp = hostIp;
			return Builder.this;
		}

		public Builder hostPort(String hostPort) {
			this.hostPort = hostPort;
			return Builder.this;
		}

		public PortBinding build() {

			return new PortBinding(this);
		}
	}

	private PortBinding(Builder builder) {
		this.hostIp = builder.hostIp;
		this.hostPort = builder.hostPort;
	}
}
