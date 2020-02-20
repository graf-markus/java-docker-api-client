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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Stats stats;
		private long maxUsage;
		private long usage;
		private long failcnt;
		private long limit;

		public Builder() {
		}

		Builder(Stats stats, long maxUsage, long usage, long failcnt, long limit) {
			this.stats = stats;
			this.maxUsage = maxUsage;
			this.usage = usage;
			this.failcnt = failcnt;
			this.limit = limit;
		}

		public Builder stats(Stats stats) {
			this.stats = stats;
			return Builder.this;
		}

		public Builder maxUsage(long maxUsage) {
			this.maxUsage = maxUsage;
			return Builder.this;
		}

		public Builder usage(long usage) {
			this.usage = usage;
			return Builder.this;
		}

		public Builder failcnt(long failcnt) {
			this.failcnt = failcnt;
			return Builder.this;
		}

		public Builder limit(long limit) {
			this.limit = limit;
			return Builder.this;
		}

		public MemoryStats build() {

			return new MemoryStats(this);
		}
	}

	private MemoryStats(Builder builder) {
		this.stats = builder.stats;
		this.maxUsage = builder.maxUsage;
		this.usage = builder.usage;
		this.failcnt = builder.failcnt;
		this.limit = builder.limit;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
