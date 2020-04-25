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
	private Map<String, Object> exposedPorts;
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

	private ContainerConfig(Builder builder) {
		this.hostname = builder.hostname;
		this.domainname = builder.domainname;
		this.user = builder.user;
		this.attachStdin = builder.attachStdin;
		this.attachStdout = builder.attachStdout;
		this.attachStderr = builder.attachStderr;
		this.exposedPorts = builder.exposedPorts;
		this.tty = builder.tty;
		this.openStdin = builder.openStdin;
		this.stdinOnce = builder.stdinOnce;
		this.env = builder.env;
		this.cmd = builder.cmd;
		this.healthcheck = builder.healthcheck;
		this.argsEscaped = builder.argsEscaped;
		this.image = builder.image;
		this.volumes = builder.volumes;
		this.workingDir = builder.workingDir;
		this.entrypoint = builder.entrypoint;
		this.networkDisabled = builder.networkDisabled;
		this.macAddress = builder.macAddress;
		this.onBuild = builder.onBuild;
		this.labels = builder.labels;
		this.stopSignal = builder.stopSignal;
		this.stopTimeout = builder.stopTimeout;
		this.shell = builder.shell;
		this.hostConfig = builder.hostConfig;
		this.networkingConfig = builder.networkingConfig;
	}

	public String getHostname() {
		return hostname;
	}

	public String getDomainname() {
		return domainname;
	}

	public String getUser() {
		return user;
	}

	public boolean isAttachStdin() {
		return attachStdin;
	}

	public boolean isAttachStdout() {
		return attachStdout;
	}

	public boolean isAttachStderr() {
		return attachStderr;
	}

	public Map<String, Object> getExposedPorts() {
		return exposedPorts;
	}

	public boolean isTty() {
		return tty;
	}

	public boolean isOpenStdin() {
		return openStdin;
	}

	public boolean isStdinOnce() {
		return stdinOnce;
	}

	public List<String> getEnv() {
		return env;
	}

	public List<String> getCmd() {
		return cmd;
	}

	public HealthConfig getHealthcheck() {
		return healthcheck;
	}

	public boolean isArgsEscaped() {
		return argsEscaped;
	}

	public String getImage() {
		return image;
	}

	public Map<String, Object> getVolumes() {
		return volumes;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public List<String> getEntrypoint() {
		return entrypoint;
	}

	public boolean isNetworkDisabled() {
		return networkDisabled;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public List<String> getOnBuild() {
		return onBuild;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public String getStopSignal() {
		return stopSignal;
	}

	public int getStopTimeout() {
		return stopTimeout;
	}

	public List<String> getShell() {
		return shell;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public NetworkingConfig getNetworkingConfig() {
		return networkingConfig;
	}

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String hostname;
		private String domainname;
		private String user;
		private boolean attachStdin;
		private boolean attachStdout;
		private boolean attachStderr;
		private Map<String, Object> exposedPorts = new HashMap<>();
		private boolean tty;
		private boolean openStdin;
		private boolean stdinOnce;
		private List<String> env = new ArrayList<String>();
		private List<String> cmd = new ArrayList<String>();
		private HealthConfig healthcheck;
		private boolean argsEscaped;
		private String image;
		private Map<String, Object> volumes = new HashMap<>();
		private String workingDir;
		private List<String> entrypoint = new ArrayList<String>();
		private boolean networkDisabled;
		private String macAddress;
		private List<String> onBuild = new ArrayList<String>();
		private Map<String, String> labels = new HashMap<>();
		private String stopSignal;
		private int stopTimeout;
		private List<String> shell = new ArrayList<String>();
		private HostConfig hostConfig;
		private NetworkingConfig networkingConfig;

		public Builder() {
		}

		public Builder hostname(String hostname) {
			this.hostname = hostname;
			return Builder.this;
		}

		public Builder domainname(String domainname) {
			this.domainname = domainname;
			return Builder.this;
		}

		public Builder user(String user) {
			this.user = user;
			return Builder.this;
		}

		public Builder attachStdin(boolean attachStdin) {
			this.attachStdin = attachStdin;
			return Builder.this;
		}

		public Builder attachStdout(boolean attachStdout) {
			this.attachStdout = attachStdout;
			return Builder.this;
		}

		public Builder attachStderr(boolean attachStderr) {
			this.attachStderr = attachStderr;
			return Builder.this;
		}

		public Builder addExposedPort(String port) {
			this.exposedPorts.put(port, new Object());
			return Builder.this;
		}

		public Builder addExBuilder(String... ports) {
			for (String p : ports) {
				this.exposedPorts.put(p, new Object());
			}
			return Builder.this;
		}

		public Builder tty(boolean tty) {
			this.tty = tty;
			return Builder.this;
		}

		public Builder openStdin(boolean openStdin) {
			this.openStdin = openStdin;
			return Builder.this;
		}

		public Builder stdinOnce(boolean stdinOnce) {
			this.stdinOnce = stdinOnce;
			return Builder.this;
		}

		public Builder env(List<String> env) {
			this.env = env;
			return Builder.this;
		}

		public Builder addEnv(String env) {
			this.env.add(env);
			return Builder.this;
		}

		public Builder addEnv(String... env) {
			this.env.addAll(Arrays.asList(env));
			return Builder.this;
		}

		public Builder cmd(List<String> cmd) {
			this.cmd = cmd;
			return Builder.this;
		}

		public Builder cmd(String... cmd) {
			this.cmd.addAll(Arrays.asList(cmd));
			return Builder.this;
		}

		public Builder addCmd(String cmd) {
			this.cmd.add(cmd);
			return Builder.this;
		}

		public Builder healthcheck(HealthConfig healthcheck) {
			this.healthcheck = healthcheck;
			return Builder.this;
		}

		public Builder argsEscaped(boolean argsEscaped) {
			this.argsEscaped = argsEscaped;
			return Builder.this;
		}

		public Builder image(String image) {
			this.image = image;
			return Builder.this;
		}

		public Builder addVolumes(String volume) {
			this.volumes.put(volume, new Object());
			return Builder.this;
		}

		public Builder addVolumes(String... volumes) {
			for (String v : volumes) {
				this.volumes.put(v, new Object());
			}
			return Builder.this;
		}

		public Builder workingDir(String workingDir) {
			this.workingDir = workingDir;
			return Builder.this;
		}

		public Builder entrypoint(List<String> entrypoint) {
			this.entrypoint = entrypoint;
			return Builder.this;
		}

		public Builder addEntrypoint(String entrypoint) {
			this.entrypoint.add(entrypoint);
			return Builder.this;
		}

		public Builder addEntrypoint(String... entrypoint) {
			this.entrypoint.addAll(Arrays.asList(entrypoint));
			return Builder.this;
		}

		public Builder networkDisabled(boolean networkDisabled) {
			this.networkDisabled = networkDisabled;
			return Builder.this;
		}

		public Builder macAddress(String macAddress) {
			this.macAddress = macAddress;
			return Builder.this;
		}

		public Builder onBuild(List<String> onBuild) {
			this.onBuild = onBuild;
			return Builder.this;
		}

		public Builder addOnBuild(String onBuild) {
			this.onBuild.add(onBuild);
			return Builder.this;
		}

		public Builder addOnBuild(String... onBuild) {
			this.onBuild.addAll(Arrays.asList(onBuild));
			return Builder.this;
		}

		public Builder labels(Map<String, String> labels) {
			this.labels = labels;
			return Builder.this;
		}

		public Builder addLabel(String key, String value) {
			this.labels.put(key, value);
			return Builder.this;
		}

		public Builder stopSignal(String stopSignal) {
			this.stopSignal = stopSignal;
			return Builder.this;
		}

		public Builder stopTimeout(int stopTimeout) {
			this.stopTimeout = stopTimeout;
			return Builder.this;
		}

		public Builder shell(List<String> shell) {
			this.shell = shell;
			return Builder.this;
		}

		public Builder addShell(String shell) {
			this.shell.add(shell);
			return Builder.this;
		}

		public Builder addShell(String... shell) {
			this.shell.addAll(Arrays.asList(shell));
			return Builder.this;
		}

		public Builder hostConfig(HostConfig hostConfig) {
			this.hostConfig = hostConfig;
			return Builder.this;
		}

		public Builder networkingConfig(NetworkingConfig networkingConfig) {
			this.networkingConfig = networkingConfig;
			return Builder.this;
		}

		public ContainerConfig build() {
			return new ContainerConfig(this);
		}
	}
}
