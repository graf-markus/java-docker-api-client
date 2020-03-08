package com.graf.docker.client.models;

import java.util.List;

public class Health {

	private String status;
	private int failingStreak;
	private List<HealthcheckResult> log;

	public String getStatus() {
		return status;
	}

	public int getFailingStreak() {
		return failingStreak;
	}

	public List<HealthcheckResult> getLog() {
		return log;
	}
}
