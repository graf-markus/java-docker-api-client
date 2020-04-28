package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ProcessConfig {

	@SerializedName("privileged")
	private boolean privileged;
	@SerializedName("user")
	private String user;
	@SerializedName("tty")
	private boolean tty;
	@SerializedName("entrypoint")
	private String entrypoint;
	@SerializedName("arguments")
	private List<String> arguments;

	public boolean isPrivileged() {
		return privileged;
	}

	public String getUser() {
		return user;
	}

	public boolean isTty() {
		return tty;
	}

	public String getEntrypoint() {
		return entrypoint;
	}

	public List<String> getArguments() {
		return arguments;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
