package com.graf.docker.client.models;

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
}
