package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class CpuUsage {

	@SerializedName("total_usage")
	private long totalUsage;
	@SerializedName("percpu_usage")
	private List<Long> percpuUsage;
	@SerializedName("usage_in_kernelmode")
	private long usageInKernelmode;
	@SerializedName("usage_in_usermode")
	private long usageInUsermode;

	public long getTotalUsage() {
		return totalUsage;
	}

	public List<Long> getPercpuUsage() {
		return percpuUsage;
	}

	public long getUsageInKernelmode() {
		return usageInKernelmode;
	}

	public long getUsageInUsermode() {
		return usageInUsermode;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
