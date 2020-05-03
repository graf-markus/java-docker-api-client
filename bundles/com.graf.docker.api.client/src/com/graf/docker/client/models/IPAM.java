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

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String driver;

		private List<Map<String, String>> config;
		private Map<String, String> options;

		public Builder() {
		}

		public Builder driver(String driver) {
			this.driver = driver;
			return Builder.this;
		}

		public Builder config(List<Map<String, String>> config) {
			if (this.config == null) {
				this.config = new ArrayList<>();
			}
			this.config.addAll(config);
			return Builder.this;
		}

		public Builder config(Map<String, String> config) {
			if (this.config == null) {
				this.config = new ArrayList<>();
			}
			this.config.add(config);
			return Builder.this;
		}

		public Builder options(Map<String, String> options) {
			if (this.options == null) {
				this.options = new HashMap<>();
			}
			this.options.putAll(options);
			return Builder.this;
		}

		public Builder option(String key, String value) {
			if (this.options == null) {
				this.options = new HashMap<>();
			}
			this.options.put(key, value);
			return Builder.this;
		}

		public IPAM build() {

			return new IPAM(this);
		}
	}
}
