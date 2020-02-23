package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class MemoryStats {

	@SerializedName("stats")
	private Stats stats;
	@SerializedName("max_usage")
	private long maxUsage;
	@SerializedName("usage")
	private long usage;
	@SerializedName("failcnt")
	private long failcnt;
	@SerializedName("limit")
	private long limit;

	public Stats getStats() {
		return stats;
	}

	public long getMaxUsage() {
		return maxUsage;
	}

	public long getUsage() {
		return usage;
	}

	public long getFailcnt() {
		return failcnt;
	}

	public long getLimit() {
		return limit;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
