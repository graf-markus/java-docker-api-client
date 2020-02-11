package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ThrottlingData {

	@SerializedName("periods")
	private long periods;
	@SerializedName("throttled_periods")
	private long throttledPeriods;
	@SerializedName("throttled_time")
	private long throttledTime;

	public long getPeriods() {
		return periods;
	}

	public long getThrottledPeriods() {
		return throttledPeriods;
	}

	public long getThrottledTime() {
		return throttledTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private long periods;
		private long throttledPeriods;
		private long throttledTime;

		public Builder() {
		}

		Builder(long periods, long throttledPeriods, long throttledTime) {
			this.periods = periods;
			this.throttledPeriods = throttledPeriods;
			this.throttledTime = throttledTime;
		}

		public Builder periods(long periods) {
			this.periods = periods;
			return Builder.this;
		}

		public Builder throttledPeriods(long throttledPeriods) {
			this.throttledPeriods = throttledPeriods;
			return Builder.this;
		}

		public Builder throttledTime(long throttledTime) {
			this.throttledTime = throttledTime;
			return Builder.this;
		}

		public ThrottlingData build() {

			return new ThrottlingData(this);
		}
	}

	private ThrottlingData(Builder builder) {
		this.periods = builder.periods;
		this.throttledPeriods = builder.throttledPeriods;
		this.throttledTime = builder.throttledTime;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
