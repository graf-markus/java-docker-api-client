package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HealthConfig {

	private List<String> test;
	private int interval;
	private int timeout;
	private int retries;
	private int startPeriod;

	private HealthConfig(Builder builder) {
		this.test = builder.test;
		this.interval = builder.interval;
		this.timeout = builder.timeout;
		this.retries = builder.retries;
		this.startPeriod = builder.startPeriod;
	}

	public List<String> getTest() {
		return test;
	}

	public int getInterval() {
		return interval;
	}

	public int getTimeout() {
		return timeout;
	}

	public int getRetries() {
		return retries;
	}

	public int getStartPeriod() {
		return startPeriod;
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

		private List<String> test = new ArrayList<String>();
		private int interval;
		private int timeout;
		private int retries;
		private int startPeriod;

		public Builder() {
		}

		public Builder test(List<String> test) {
			this.test = test;
			return Builder.this;
		}

		public Builder addTest(String test) {
			this.test.add(test);
			return Builder.this;
		}

		public Builder addTest(String... test) {
			this.test.addAll(Arrays.asList(test));
			return Builder.this;
		}

		public Builder interval(int interval) {
			this.interval = interval;
			return Builder.this;
		}

		public Builder timeout(int timeout) {
			this.timeout = timeout;
			return Builder.this;
		}

		public Builder retries(int retries) {
			this.retries = retries;
			return Builder.this;
		}

		public Builder startPeriod(int startPeriod) {
			this.startPeriod = startPeriod;
			return Builder.this;
		}

		public HealthConfig build() {

			return new HealthConfig(this);
		}
	}
}
