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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Long totalUsage;
		private List<Long> percpuUsage = new ArrayList<Long>();
		private Long usageInKernelmode;
		private Long usageInUsermode;

		public Builder() {
		}

		Builder(Long totalUsage, List<Long> percpuUsage, Long usageInKernelmode, Long usageInUsermode) {
			this.totalUsage = totalUsage;
			this.percpuUsage = percpuUsage;
			this.usageInKernelmode = usageInKernelmode;
			this.usageInUsermode = usageInUsermode;
		}

		public Builder totalUsage(Long totalUsage) {
			this.totalUsage = totalUsage;
			return Builder.this;
		}

		public Builder percpuUsage(List<Long> percpuUsage) {
			this.percpuUsage = percpuUsage;
			return Builder.this;
		}

		public Builder addPercpuUsage(Long percpuUsage) {
			this.percpuUsage.add(percpuUsage);
			return Builder.this;
		}

		public Builder usageInKernelmode(Long usageInKernelmode) {
			this.usageInKernelmode = usageInKernelmode;
			return Builder.this;
		}

		public Builder usageInUsermode(Long usageInUsermode) {
			this.usageInUsermode = usageInUsermode;
			return Builder.this;
		}

		public CpuUsage build() {

			return new CpuUsage(this);
		}
	}

	private CpuUsage(Builder builder) {
		this.totalUsage = builder.totalUsage;
		this.percpuUsage = builder.percpuUsage;
		this.usageInKernelmode = builder.usageInKernelmode;
		this.usageInUsermode = builder.usageInUsermode;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
