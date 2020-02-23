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

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
