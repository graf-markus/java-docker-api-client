package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class BlockIoStats {

	@SerializedName("io_service_bytes_recursive")
	private List<Object> ioServiceBytesRecursive;
	@SerializedName("io_serviced_recursive")
	private List<Object> ioServicedRecursive;
	@SerializedName("io_queue_recursive")
	private List<Object> ioQueueRecursive;
	@SerializedName("io_service_time_recursive")
	private List<Object> ioServiceTimeRecursive;
	@SerializedName("io_wait_time_recursive")
	private List<Object> ioWaitTimeRecursive;
	@SerializedName("io_merged_recursive")
	private List<Object> ioMergedRecursive;
	@SerializedName("io_time_recursive")
	private List<Object> ioTimeRecursive;
	@SerializedName("sectors_recursive")
	private List<Object> sectorsRecursive;

	public List<Object> getIoServiceBytesRecursive() {
		return ioServiceBytesRecursive;
	}

	public List<Object> getIoServicedRecursive() {
		return ioServicedRecursive;
	}

	public List<Object> getIoQueueRecursive() {
		return ioQueueRecursive;
	}

	public List<Object> getIoServiceTimeRecursive() {
		return ioServiceTimeRecursive;
	}

	public List<Object> getIoWaitTimeRecursive() {
		return ioWaitTimeRecursive;
	}

	public List<Object> getIoMergedRecursive() {
		return ioMergedRecursive;
	}

	public List<Object> getIoTimeRecursive() {
		return ioTimeRecursive;
	}

	public List<Object> getSectorsRecursive() {
		return sectorsRecursive;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
