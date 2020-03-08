package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ContainerState {

	private String status;
	private boolean running;
	private boolean paused;
	private boolean restarting;
	@SerializedName("OOMKilled")
	private boolean oomKilled;
	private boolean dead;
	private int pid;
	private int exitCode;
	private String error;
	private String startedAt;
	private String finishedAt;
	private Health health;

	public String getStatus() {
		return status;
	}

	public boolean isRunning() {
		return running;
	}

	public boolean isPaused() {
		return paused;
	}

	public boolean isRestarting() {
		return restarting;
	}

	public boolean isOomKilled() {
		return oomKilled;
	}

	public boolean isDead() {
		return dead;
	}

	public int getPid() {
		return pid;
	}

	public int getExitCode() {
		return exitCode;
	}

	public String getError() {
		return error;
	}

	public String getStartedAt() {
		return startedAt;
	}

	public String getFinishedAt() {
		return finishedAt;
	}

	public Health getHealth() {
		return health;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
