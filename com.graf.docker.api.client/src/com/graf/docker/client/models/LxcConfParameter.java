package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LxcConfParameter {

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String key;
		private String value;

		public Builder() {
		}

		Builder(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public Builder key(String key) {
			this.key = key;
			return Builder.this;
		}

		public Builder value(String value) {
			this.value = value;
			return Builder.this;
		}

		public LxcConfParameter build() {

			return new LxcConfParameter(this);
		}
	}

	private LxcConfParameter(Builder builder) {
		this.key = builder.key;
		this.value = builder.value;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
