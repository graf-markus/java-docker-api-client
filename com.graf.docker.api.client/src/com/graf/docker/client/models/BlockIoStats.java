package com.graf.docker.client.models;

import java.util.ArrayList;
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private List<Object> ioServiceBytesRecursive = new ArrayList<Object>();
		private List<Object> ioServicedRecursive = new ArrayList<Object>();
		private List<Object> ioQueueRecursive = new ArrayList<Object>();
		private List<Object> ioServiceTimeRecursive = new ArrayList<Object>();
		private List<Object> ioWaitTimeRecursive = new ArrayList<Object>();
		private List<Object> ioMergedRecursive = new ArrayList<Object>();
		private List<Object> ioTimeRecursive = new ArrayList<Object>();
		private List<Object> sectorsRecursive = new ArrayList<Object>();

		public Builder() {
		}

		Builder(List<Object> ioServiceBytesRecursive, List<Object> ioServicedRecursive, List<Object> ioQueueRecursive,
				List<Object> ioServiceTimeRecursive, List<Object> ioWaitTimeRecursive, List<Object> ioMergedRecursive,
				List<Object> ioTimeRecursive, List<Object> sectorsRecursive) {
			this.ioServiceBytesRecursive = ioServiceBytesRecursive;
			this.ioServicedRecursive = ioServicedRecursive;
			this.ioQueueRecursive = ioQueueRecursive;
			this.ioServiceTimeRecursive = ioServiceTimeRecursive;
			this.ioWaitTimeRecursive = ioWaitTimeRecursive;
			this.ioMergedRecursive = ioMergedRecursive;
			this.ioTimeRecursive = ioTimeRecursive;
			this.sectorsRecursive = sectorsRecursive;
		}

		public Builder ioServiceBytesRecursive(List<Object> ioServiceBytesRecursive) {
			this.ioServiceBytesRecursive = ioServiceBytesRecursive;
			return Builder.this;
		}

		public Builder addIoServiceBytesRecursive(Object ioServiceBytesRecursive) {
			this.ioServiceBytesRecursive.add(ioServiceBytesRecursive);
			return Builder.this;
		}

		public Builder ioServicedRecursive(List<Object> ioServicedRecursive) {
			this.ioServicedRecursive = ioServicedRecursive;
			return Builder.this;
		}

		public Builder addIoServicedRecursive(Object ioServicedRecursive) {
			this.ioServicedRecursive.add(ioServicedRecursive);
			return Builder.this;
		}

		public Builder ioQueueRecursive(List<Object> ioQueueRecursive) {
			this.ioQueueRecursive = ioQueueRecursive;
			return Builder.this;
		}

		public Builder addIoQueueRecursive(Object ioQueueRecursive) {
			this.ioQueueRecursive.add(ioQueueRecursive);
			return Builder.this;
		}

		public Builder ioServiceTimeRecursive(List<Object> ioServiceTimeRecursive) {
			this.ioServiceTimeRecursive = ioServiceTimeRecursive;
			return Builder.this;
		}

		public Builder addIoServiceTimeRecursive(Object ioServiceTimeRecursive) {
			this.ioServiceTimeRecursive.add(ioServiceTimeRecursive);
			return Builder.this;
		}

		public Builder ioWaitTimeRecursive(List<Object> ioWaitTimeRecursive) {
			this.ioWaitTimeRecursive = ioWaitTimeRecursive;
			return Builder.this;
		}

		public Builder addIoWaitTimeRecursive(Object ioWaitTimeRecursive) {
			this.ioWaitTimeRecursive.add(ioWaitTimeRecursive);
			return Builder.this;
		}

		public Builder ioMergedRecursive(List<Object> ioMergedRecursive) {
			this.ioMergedRecursive = ioMergedRecursive;
			return Builder.this;
		}

		public Builder addIoMergedRecursive(Object ioMergedRecursive) {
			this.ioMergedRecursive.add(ioMergedRecursive);
			return Builder.this;
		}

		public Builder ioTimeRecursive(List<Object> ioTimeRecursive) {
			this.ioTimeRecursive = ioTimeRecursive;
			return Builder.this;
		}

		public Builder addIoTimeRecursive(Object ioTimeRecursive) {
			this.ioTimeRecursive.add(ioTimeRecursive);
			return Builder.this;
		}

		public Builder sectorsRecursive(List<Object> sectorsRecursive) {
			this.sectorsRecursive = sectorsRecursive;
			return Builder.this;
		}

		public Builder addSectorsRecursive(Object sectorsRecursive) {
			this.sectorsRecursive.add(sectorsRecursive);
			return Builder.this;
		}

		public BlockIoStats build() {

			return new BlockIoStats(this);
		}

	}

	private BlockIoStats(Builder builder) {
		this.ioServiceBytesRecursive = builder.ioServiceBytesRecursive;
		this.ioServicedRecursive = builder.ioServicedRecursive;
		this.ioQueueRecursive = builder.ioQueueRecursive;
		this.ioServiceTimeRecursive = builder.ioServiceTimeRecursive;
		this.ioWaitTimeRecursive = builder.ioWaitTimeRecursive;
		this.ioMergedRecursive = builder.ioMergedRecursive;
		this.ioTimeRecursive = builder.ioTimeRecursive;
		this.sectorsRecursive = builder.sectorsRecursive;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
