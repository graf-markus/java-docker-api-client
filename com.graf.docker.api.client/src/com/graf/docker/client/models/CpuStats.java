package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class CpuStats {

	@SerializedName("cpu_usage")
	private CpuUsage cpuUsage;
	@SerializedName("system_cpu_usage")
	private Long systemCpuUsage;
	@SerializedName("throttling_data")
	private ThrottlingData throttlingData;

	public CpuUsage getCpuUsage() {
		return cpuUsage;
	}

	public Long getSystemCpuUsage() {
		return systemCpuUsage;
	}

	public ThrottlingData getThrottlingData() {
		return throttlingData;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private CpuUsage cpuUsage;
		private Long systemCpuUsage;
		private ThrottlingData throttlingData;

		public Builder() {
		}

		Builder(CpuUsage cpuUsage, Long systemCpuUsage, ThrottlingData throttlingData) {
			this.cpuUsage = cpuUsage;
			this.systemCpuUsage = systemCpuUsage;
			this.throttlingData = throttlingData;
		}

		public Builder cpuUsage(CpuUsage cpuUsage) {
			this.cpuUsage = cpuUsage;
			return Builder.this;
		}

		public Builder systemCpuUsage(Long systemCpuUsage) {
			this.systemCpuUsage = systemCpuUsage;
			return Builder.this;
		}

		public Builder throttlingData(ThrottlingData throttlingData) {
			this.throttlingData = throttlingData;
			return Builder.this;
		}

		public CpuStats build() {

			return new CpuStats(this);
		}
	}

	private CpuStats(Builder builder) {
		this.cpuUsage = builder.cpuUsage;
		this.systemCpuUsage = builder.systemCpuUsage;
		this.throttlingData = builder.throttlingData;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
