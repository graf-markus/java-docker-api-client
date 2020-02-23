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

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
