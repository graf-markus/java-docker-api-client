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
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
