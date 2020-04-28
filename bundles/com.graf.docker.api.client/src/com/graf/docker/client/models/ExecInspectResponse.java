package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ExecInspectResponse {

	private boolean canRemove;
	private String detachKeys;
	@SerializedName("ID")
	private String id;
	private boolean running;
	private ProcessConfig processConfig;
	private boolean openStdin;
	private boolean openStderr;
	private boolean openStdout;
	@SerializedName("ContainerID")
	private String containerId;
	private int pid;

	public boolean isCanRemove() {
		return canRemove;
	}

	public String getDetachKeys() {
		return detachKeys;
	}

	public String getId() {
		return id;
	}

	public boolean isRunning() {
		return running;
	}

	public ProcessConfig getProcessConfig() {
		return processConfig;
	}

	public boolean isOpenStdin() {
		return openStdin;
	}

	public boolean isOpenStderr() {
		return openStderr;
	}

	public boolean isOpenStdout() {
		return openStdout;
	}

	public String getContainerId() {
		return containerId;
	}

	public int getPid() {
		return pid;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
