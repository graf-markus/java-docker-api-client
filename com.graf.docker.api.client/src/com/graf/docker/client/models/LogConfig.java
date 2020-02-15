package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogConfig {

	private String type;
	private Map<String, String> logOptions;

	public String getType() {
		return type;
	}

	public Map<String, String> getLogOptions() {
		return logOptions;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String type;

		private Map<String, String> logOptions;

		public Builder() {
		}

		Builder(String type, Map<String, String> logOptions) {
			this.type = type;
			this.logOptions = logOptions;
		}

		public Builder type(String type) {
			this.type = type;
			return Builder.this;
		}

		public Builder logOptions(Map<String, String> logOptions) {
			this.logOptions = logOptions;
			return Builder.this;
		}

		public LogConfig build() {

			return new LogConfig(this);
		}
	}

	private LogConfig(Builder builder) {
		this.type = builder.type;
		this.logOptions = builder.logOptions;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
	
	public class LogConfigType { 
		public static final String JSON_FILE = "json-file";
		public static final String SYSLOG = "syslog";
		public static final String JOURNALD = "journald";
		public static final String GELF = "gelf";
		public static final String FLUENTD = "fluentd";
		public static final String AWSLOGS = "awslogs";
		public static final String SPLUNK = "splunk";
		public static final String ETWLOGS = "etwlogs";
		public static final String NONE = "none";
	}
}
