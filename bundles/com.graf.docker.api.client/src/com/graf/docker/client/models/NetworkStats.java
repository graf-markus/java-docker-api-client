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

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
