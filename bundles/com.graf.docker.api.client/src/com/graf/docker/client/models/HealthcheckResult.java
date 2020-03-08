package com.graf.docker.client.models;

public class HealthcheckResult {

	private String start;
	private String end;
	private int exitCode;
	private String output;

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public int getExitCode() {
		return exitCode;
	}

	public String getOutput() {
		return output;
	}
}
