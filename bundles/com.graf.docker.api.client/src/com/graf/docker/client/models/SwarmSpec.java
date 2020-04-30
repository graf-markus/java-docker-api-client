package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class SwarmSpec {

	private String name;
	private Map<String, String> labels;
	private Map<String, Integer> orchestration;
	private Raft raft;
	private Dispatcher dispatcher;
	@SerializedName("CAConfig")
	private CAConfig caConfig;
	private Map<String, Boolean> encryptionConfig;
	private TaskDefault taskDefaults;

	public String getName() {
		return name;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public Map<String, Integer> getOrchestration() {
		return orchestration;
	}

	public Raft getRaft() {
		return raft;
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}

	public CAConfig getCaConfig() {
		return caConfig;
	}

	public Map<String, Boolean> getEncryptionConfig() {
		return encryptionConfig;
	}

	public TaskDefault getTaskDefaults() {
		return taskDefaults;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
