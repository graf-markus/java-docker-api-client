package com.graf.docker.client.models;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DriverConfig {

	private String name;
	private Map<String, String> options;

	private DriverConfig(Builder builder) {
		this.name = builder.name;
		this.options = builder.options;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String name;
		private Map<String, String> options = new HashMap<>();

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder options(Map<String, String> options) {
			this.options = options;
			return Builder.this;
		}

		public Builder addOption(String key, String value) {
			this.options.put(key, value);
			return Builder.this;
		}

		public DriverConfig build() {
			return new DriverConfig(this);
		}
	}
}
