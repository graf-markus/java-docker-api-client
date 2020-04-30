package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Raft {

	private long snapshotInterval;
	private long keepOldSnaphsots;
	private long logEntriesForSlowFollowers;
	private int electionTick;
	private int heartbeatTick;

	public long getSnapshotInterval() {
		return snapshotInterval;
	}

	public long getKeepOldSnaphsots() {
		return keepOldSnaphsots;
	}

	public long getLogEntriesForSlowFollowers() {
		return logEntriesForSlowFollowers;
	}

	public int getElectionTick() {
		return electionTick;
	}

	public int getHeartbeatTick() {
		return heartbeatTick;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
