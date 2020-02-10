package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BlkioDeviceRate {

	private String path;
	private int rate;

	public String getPath() {
		return path;
	}

	public int getRate() {
		return rate;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String path;
		private int rate;

		public Builder() {
		}

		Builder(String path, int rate) {
			this.path = path;
			this.rate = rate;
		}

		public Builder path(String path) {
			this.path = path;
			return Builder.this;
		}

		public Builder rate(int rate) {
			this.rate = rate;
			return Builder.this;
		}

		public BlkioDeviceRate build() {

			return new BlkioDeviceRate(this);
		}
	}

	private BlkioDeviceRate(Builder builder) {
		this.path = builder.path;
		this.rate = builder.rate;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
