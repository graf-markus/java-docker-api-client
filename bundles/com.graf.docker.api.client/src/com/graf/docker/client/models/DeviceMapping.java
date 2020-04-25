package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DeviceMapping {

	private String pathOnHost;
	private String pathInContainer;
	private String cgroupPermissions;

	private DeviceMapping(Builder builder) {
		this.pathOnHost = builder.pathOnHost;
		this.pathInContainer = builder.pathInContainer;
		this.cgroupPermissions = builder.cgroupPermissions;
	}

	public String getPathOnHost() {
		return pathOnHost;
	}

	public String getPathInContainer() {
		return pathInContainer;
	}

	public String getCgroupPermissions() {
		return cgroupPermissions;
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

		private String pathOnHost;
		private String pathInContainer;
		private String cgroupPermissions;

		public Builder() {
		}

		public Builder pathOnHost(String pathOnHost) {
			this.pathOnHost = pathOnHost;
			return Builder.this;
		}

		public Builder pathInContainer(String pathInContainer) {
			this.pathInContainer = pathInContainer;
			return Builder.this;
		}

		public Builder cgroupPermissions(String cgroupPermissions) {
			this.cgroupPermissions = cgroupPermissions;
			return Builder.this;
		}

		public DeviceMapping build() {

			return new DeviceMapping(this);
		}
	}
}
