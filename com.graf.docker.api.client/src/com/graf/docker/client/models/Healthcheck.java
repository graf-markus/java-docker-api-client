package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Healthcheck {

	private String[] test;
	private long interval;
	private long timeout;
	private int retries;
	private long startPeriod;

	public String[] getTest() {
		return test;
	}

	public long getInterval() {
		return interval;
	}

	public long getTimeout() {
		return timeout;
	}

	public int getRetries() {
		return retries;
	}

	public long getStartPeriod() {
		return startPeriod;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String[] test;
		private long interval;
		private long timeout;
		private int retries;
		private long startPeriod;

		public Builder() {
		}

		Builder(String[] test, long interval, long timeout, int retries, long startPeriod) {
			this.test = test;
			this.interval = interval;
			this.timeout = timeout;
			this.retries = retries;
			this.startPeriod = startPeriod;
		}

		public Builder test(String[] test) {
			this.test = test;
			return Builder.this;
		}

		public Builder interval(long interval) {
			this.interval = interval;
			return Builder.this;
		}

		public Builder timeout(long timeout) {
			this.timeout = timeout;
			return Builder.this;
		}

		public Builder retries(int retries) {
			this.retries = retries;
			return Builder.this;
		}

		public Builder startPeriod(long startPeriod) {
			this.startPeriod = startPeriod;
			return Builder.this;
		}

		public Healthcheck build() {

			return new Healthcheck(this);
		}
	}

	private Healthcheck(Builder builder) {
		this.test = builder.test;
		this.interval = builder.interval;
		this.timeout = builder.timeout;
		this.retries = builder.retries;
		this.startPeriod = builder.startPeriod;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
