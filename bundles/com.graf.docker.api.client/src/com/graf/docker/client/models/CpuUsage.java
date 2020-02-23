package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class CpuUsage {

	@SerializedName("total_usage")
	private Long totalUsage;
	@SerializedName("percpu_usage")
	private List<Long> percpuUsage;
	@SerializedName("usage_in_kernelmode")
	private Long usageInKernelmode;
	@SerializedName("usage_in_usermode")
	private Long usageInUsermode;

	public Long getTotalUsage() {
		return totalUsage;
	}

	public List<Long> getPercpuUsage() {
		return percpuUsage;
	}

	public Long getUsageInKernelmode() {
		return usageInKernelmode;
	}

	public Long getUsageInUsermode() {
		return usageInUsermode;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
