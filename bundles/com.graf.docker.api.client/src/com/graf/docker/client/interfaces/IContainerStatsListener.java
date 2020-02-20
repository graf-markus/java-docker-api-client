package com.graf.docker.client.interfaces;

import com.graf.docker.client.models.ContainerStats;

public interface IContainerStatsListener {

	void onContainerStatsReceived(ContainerStats stats);
	void onClosed(int statusCode, String message);
}
