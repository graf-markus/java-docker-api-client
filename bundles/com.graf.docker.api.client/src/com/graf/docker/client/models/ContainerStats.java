package com.graf.docker.client.models;

import java.util.Date;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ContainerStats {

	@SerializedName("read")
	private Date read;
	@SerializedName("network")
	private NetworkStats network;
	@SerializedName("networks")
	private Map<String, NetworkStats> networks;
	@SerializedName("memory_stats")
	private MemoryStats memoryStats;
	@SerializedName("blkio_stats")
	private BlockIoStats blockIoStats;
	@SerializedName("cpu_stats")
	private CpuStats cpuStats;
	@SerializedName("precpu_stats")
	private CpuStats precpuStats;

	public Date getRead() {
		return read;
	}

	public NetworkStats getNetwork() {
		return network;
	}

	public Map<String, NetworkStats> getNetworks() {
		return networks;
	}

	public MemoryStats getMemoryStats() {
		return memoryStats;
	}

	public BlockIoStats getBlockIoStats() {
		return blockIoStats;
	}

	public CpuStats getCpuStats() {
		return cpuStats;
	}

	public CpuStats getPrecpuStats() {
		return precpuStats;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Date read;
		private NetworkStats network;
		private Map<String, NetworkStats> networks;
		private MemoryStats memoryStats;
		private BlockIoStats blockIoStats;
		private CpuStats cpuStats;
		private CpuStats precpuStats;

		public Builder() {
		}

		Builder(Date read, NetworkStats network, Map<String, NetworkStats> networks, MemoryStats memoryStats,
				BlockIoStats blockIoStats, CpuStats cpuStats, CpuStats precpuStats) {
			this.read = read;
			this.network = network;
			this.networks = networks;
			this.memoryStats = memoryStats;
			this.blockIoStats = blockIoStats;
			this.cpuStats = cpuStats;
			this.precpuStats = precpuStats;
		}

		public Builder read(Date read) {
			this.read = read;
			return Builder.this;
		}

		public Builder network(NetworkStats network) {
			this.network = network;
			return Builder.this;
		}

		public Builder networks(Map<String, NetworkStats> networks) {
			this.networks = networks;
			return Builder.this;
		}

		public Builder memoryStats(MemoryStats memoryStats) {
			this.memoryStats = memoryStats;
			return Builder.this;
		}

		public Builder blockIoStats(BlockIoStats blockIoStats) {
			this.blockIoStats = blockIoStats;
			return Builder.this;
		}

		public Builder cpuStats(CpuStats cpuStats) {
			this.cpuStats = cpuStats;
			return Builder.this;
		}

		public Builder precpuStats(CpuStats precpuStats) {
			this.precpuStats = precpuStats;
			return Builder.this;
		}

		public ContainerStats build() {

			return new ContainerStats(this);
		}
	}

	private ContainerStats(Builder builder) {
		this.read = builder.read;
		this.network = builder.network;
		this.networks = builder.networks;
		this.memoryStats = builder.memoryStats;
		this.blockIoStats = builder.blockIoStats;
		this.cpuStats = builder.cpuStats;
		this.precpuStats = builder.precpuStats;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
