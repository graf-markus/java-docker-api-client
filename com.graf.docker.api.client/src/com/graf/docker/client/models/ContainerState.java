package com.graf.docker.client.models;

import java.util.Date;

public class ContainerState {

	private String status;
	private boolean running;
	private boolean paused;
	private boolean restarting;
	private int pid;
	private long exitCode;
	private Date startedAt;
	private Date finishedAt;
	private String error;
	private boolean oomKilled;
	private boolean dead;

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

	public int getPid() {
		return pid;
	}

	public long getExitCode() {
		return exitCode;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public String getError() {
		return error;
	}

	public boolean isOomKilled() {
		return oomKilled;
	}

	public boolean isDead() {
		return dead;
	}
}
