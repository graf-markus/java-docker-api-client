package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IPAM {

	private String driver;
	private List<Map<String, String>> config;
	private Map<String, String> options;

	private IPAM(Builder builder) {
		this.driver = builder.driver;
		this.config = builder.config;
		this.options = builder.options;
	}

	public String getDriver() {
		return driver;
	}

	public List<Map<String, String>> getConfig() {
		return config;
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

		private String driver;

		private List<Map<String, String>> config = new ArrayList<>();
		private Map<String, String> options = new HashMap<>();

		public Builder() {
		}

		Builder(String driver, List<Map<String, String>> config, Map<String, String> options) {
			this.driver = driver;
			this.config = config;
			this.options = options;
		}

		public Builder driver(String driver) {
			this.driver = driver;
			return Builder.this;
		}

		public Builder config(List<Map<String, String>> config) {
			this.config = config;
			return Builder.this;
		}

		public Builder addConfig(Map<String, String> config) {
			this.config.add(config);
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

		public IPAM build() {

			return new IPAM(this);
		}
	}
}
