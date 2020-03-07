package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BlkioWeightDevice {

	private String path;
	private int weight;

	private BlkioWeightDevice(Builder builder) {
		this.path = builder.path;
		this.weight = builder.weight;
	}

	public String getPath() {
		return path;
	}

	public int getWeight() {
		return weight;
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

		private String path;
		private int weight;

		public Builder() {
		}

		Builder(String path, int weight) {
			this.path = path;
			this.weight = weight;
		}

		public Builder path(String path) {
			this.path = path;
			return Builder.this;
		}

		public Builder weight(int weight) {
			this.weight = weight;
			return Builder.this;
		}

		public BlkioWeightDevice build() {

			return new BlkioWeightDevice(this);
		}
	}
}
