package com.graf.docker.client.models;

import java.util.Map;

public class LogConfig {

	private String type;
	private Map<String, String> logOptions;

	public String getType() {
		return type;
	}

	public Map<String, String> getLogOptions() {
		return logOptions;
	}
}
