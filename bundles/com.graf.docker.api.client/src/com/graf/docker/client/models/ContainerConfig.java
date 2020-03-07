package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerConfig {

	private String hostname;
	private String domainname;
	private String user;
	private boolean attachStdin;
	private boolean attachStdout;
	private boolean attachStderr;
	private Set<String> exposedPorts;
	private boolean tty;
	private boolean openStdin;
	private boolean stdinOnce;
	private List<String> env;
	private List<String> cmd;
	private HealthConfig healthcheck;
	private boolean argsEscaped;
	private String image;
	private Map<String, Object> volumes;
	private String workingDir;
	private List<String> entrypoint;
	private boolean networkDisabled;
	private String macAddress;
	private List<String> onBuild;
	private Map<String, String> labels;
	private String stopSignal;
	private int stopTimeout;
	private List<String> shell;
	private HostConfig hostConfig;
	private NetworkingConfig networkingConfig;

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
