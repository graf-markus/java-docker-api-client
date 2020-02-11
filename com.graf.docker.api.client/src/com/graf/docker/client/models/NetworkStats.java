package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class NetworkStats {

	@SerializedName("rx_bytes")
	private long rxBytes;
	@SerializedName("rx_packets")
	private long rxPackets;
	@SerializedName("rx_dropped")
	private long rxDropped;
	@SerializedName("rx_errors")
	private long rxErrors;
	@SerializedName("tx_bytes")
	private long txBytes;
	@SerializedName("tx_packets")
	private long txPackets;
	@SerializedName("tx_dropped")
	private long txDropped;
	@SerializedName("tx_errors")
	private long txErrors;

	public long getRxBytes() {
		return rxBytes;
	}

	public long getRxPackets() {
		return rxPackets;
	}

	public long getRxDropped() {
		return rxDropped;
	}

	public long getRxErrors() {
		return rxErrors;
	}

	public long getTxBytes() {
		return txBytes;
	}

	public long getTxPackets() {
		return txPackets;
	}

	public long getTxDropped() {
		return txDropped;
	}

	public long getTxErrors() {
		return txErrors;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private long rxBytes;
		private long rxPackets;
		private long rxDropped;
		private long rxErrors;
		private long txBytes;
		private long txPackets;
		private long txDropped;
		private long txErrors;

		public Builder() {
		}

		Builder(long rxBytes, long rxPackets, long rxDropped, long rxErrors, long txBytes, long txPackets,
				long txDropped, long txErrors) {
			this.rxBytes = rxBytes;
			this.rxPackets = rxPackets;
			this.rxDropped = rxDropped;
			this.rxErrors = rxErrors;
			this.txBytes = txBytes;
			this.txPackets = txPackets;
			this.txDropped = txDropped;
			this.txErrors = txErrors;
		}

		public Builder rxBytes(long rxBytes) {
			this.rxBytes = rxBytes;
			return Builder.this;
		}

		public Builder rxPackets(long rxPackets) {
			this.rxPackets = rxPackets;
			return Builder.this;
		}

		public Builder rxDropped(long rxDropped) {
			this.rxDropped = rxDropped;
			return Builder.this;
		}

		public Builder rxErrors(long rxErrors) {
			this.rxErrors = rxErrors;
			return Builder.this;
		}

		public Builder txBytes(long txBytes) {
			this.txBytes = txBytes;
			return Builder.this;
		}

		public Builder txPackets(long txPackets) {
			this.txPackets = txPackets;
			return Builder.this;
		}

		public Builder txDropped(long txDropped) {
			this.txDropped = txDropped;
			return Builder.this;
		}

		public Builder txErrors(long txErrors) {
			this.txErrors = txErrors;
			return Builder.this;
		}

		public NetworkStats build() {

			return new NetworkStats(this);
		}
	}

	private NetworkStats(Builder builder) {
		this.rxBytes = builder.rxBytes;
		this.rxPackets = builder.rxPackets;
		this.rxDropped = builder.rxDropped;
		this.rxErrors = builder.rxErrors;
		this.txBytes = builder.txBytes;
		this.txPackets = builder.txPackets;
		this.txDropped = builder.txDropped;
		this.txErrors = builder.txErrors;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
