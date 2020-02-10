package com.graf.docker.client.models;

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
	private String[] portSpecs;
	private Set<String> exposedPorts;
	private boolean tty;
	private boolean openStdin;
	private boolean stdinOnce;
	private String[] env;
	private String[] cmd;
	private String image;
	private Set<String> volumes;
	private String workingDir;
	private String[] entrypoint;
	private boolean networkDisabled;
	private String[] onBuild;
	private Map<String, String> labels;
	private String macAddress;
	private HostConfig hostConfig;
	private String stopSignal;
	private Healthcheck healthcheck;
	private NetworkingConfig networkingConfig;

	private ContainerConfig(ContainerConfig config) {
		this.hostname = config.hostname;
		this.image = config.image;
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

	public String[] getPortSpecs() {
		return portSpecs;
	}

	public Set<String> getExposedPorts() {
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

	public String[] getEnv() {
		return env;
	}

	public String[] getCmd() {
		return cmd;
	}

	public String getImage() {
		return image;
	}

	public Set<String> getVolumes() {
		return volumes;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public String[] getEntryPoint() {
		return entrypoint;
	}

	public boolean isNetworkDisabled() {
		return networkDisabled;
	}

	public String[] getOnBuild() {
		return onBuild;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public HostConfig getHostConfig() {
		return hostConfig;
	}

	public String getStopSignal() {
		return stopSignal;
	}

	public Healthcheck getHealthcheck() {
		return healthcheck;
	}

	public NetworkingConfig getNetworkingConfig() {
		return networkingConfig;
	}

	public static ContainerConfig.Builder builder() {
		return new ContainerConfig.Builder();
	}

	public static class Builder {

		private String hostname;
		private String domainname;
		private String user;
		private boolean attachStdin;
		private boolean attachStdout;
		private boolean attachStderr;
		private String[] portSpecs;
		private Set<String> exposedPorts;
		private boolean tty;
		private boolean openStdin;
		private boolean stdinOnce;
		private String[] env;
		private String[] cmd;
		private String image;
		private Set<String> volumes;
		private String workingDir;
		private String[] entrypoint;
		private boolean networkDisabled;
		private String[] onBuild;
		private Map<String, String> labels;
		private String macAddress;
		private HostConfig hostConfig;
		private String stopSignal;
		private Healthcheck healthcheck;
		private NetworkingConfig networkingConfig;

		public Builder() {
		}

		Builder(String hostname, String domainname, String user, boolean attachStdin, boolean attachStdout,
				boolean attachStderr, String[] portSpecs, Set<String> exposedPorts, boolean tty, boolean openStdin,
				boolean stdinOnce, String[] env, String[] cmd, String image, Set<String> volumes, String workingDir,
				String[] entrypoint, boolean networkDisabled, String[] onBuild, Map<String, String> labels,
				String macAddress, HostConfig hostConfig, String stopSignal, Healthcheck healthcheck,
				NetworkingConfig networkingConfig) {
			this.hostname = hostname;
			this.domainname = domainname;
			this.user = user;
			this.attachStdin = attachStdin;
			this.attachStdout = attachStdout;
			this.attachStderr = attachStderr;
			this.portSpecs = portSpecs;
			this.exposedPorts = exposedPorts;
			this.tty = tty;
			this.openStdin = openStdin;
			this.stdinOnce = stdinOnce;
			this.env = env;
			this.cmd = cmd;
			this.image = image;
			this.volumes = volumes;
			this.workingDir = workingDir;
			this.entrypoint = entrypoint;
			this.networkDisabled = networkDisabled;
			this.onBuild = onBuild;
			this.labels = labels;
			this.macAddress = macAddress;
			this.hostConfig = hostConfig;
			this.stopSignal = stopSignal;
			this.healthcheck = healthcheck;
			this.networkingConfig = networkingConfig;
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

		public Builder portSpecs(String[] portSpecs) {
			this.portSpecs = portSpecs;
			return Builder.this;
		}

		public Builder exposedPorts(Set<String> exposedPorts) {
			this.exposedPorts = exposedPorts;
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

		public Builder env(String[] env) {
			this.env = env;
			return Builder.this;
		}

		public Builder cmd(String[] cmd) {
			this.cmd = cmd;
			return Builder.this;
		}

		public Builder image(String image) {
			this.image = image;
			return Builder.this;
		}

		public Builder volumes(Set<String> volumes) {
			this.volumes = volumes;
			return Builder.this;
		}

		public Builder workingDir(String workingDir) {
			this.workingDir = workingDir;
			return Builder.this;
		}

		public Builder entrypoint(String[] entrypoint) {
			this.entrypoint = entrypoint;
			return Builder.this;
		}

		public Builder networkDisabled(boolean networkDisabled) {
			this.networkDisabled = networkDisabled;
			return Builder.this;
		}

		public Builder onBuild(String[] onBuild) {
			this.onBuild = onBuild;
			return Builder.this;
		}

		public Builder labels(Map<String, String> labels) {
			this.labels = labels;
			return Builder.this;
		}

		public Builder macAddress(String macAddress) {
			this.macAddress = macAddress;
			return Builder.this;
		}

		public Builder hostConfig(HostConfig hostConfig) {
			this.hostConfig = hostConfig;
			return Builder.this;
		}

		public Builder stopSignal(String stopSignal) {
			this.stopSignal = stopSignal;
			return Builder.this;
		}

		public Builder healthcheck(Healthcheck healthcheck) {
			this.healthcheck = healthcheck;
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

	private ContainerConfig(Builder builder) {
		this.hostname = builder.hostname;
		this.domainname = builder.domainname;
		this.user = builder.user;
		this.attachStdin = builder.attachStdin;
		this.attachStdout = builder.attachStdout;
		this.attachStderr = builder.attachStderr;
		this.portSpecs = builder.portSpecs;
		this.exposedPorts = builder.exposedPorts;
		this.tty = builder.tty;
		this.openStdin = builder.openStdin;
		this.stdinOnce = builder.stdinOnce;
		this.env = builder.env;
		this.cmd = builder.cmd;
		this.image = builder.image;
		this.volumes = builder.volumes;
		this.workingDir = builder.workingDir;
		this.entrypoint = builder.entrypoint;
		this.networkDisabled = builder.networkDisabled;
		this.onBuild = builder.onBuild;
		this.labels = builder.labels;
		this.macAddress = builder.macAddress;
		this.hostConfig = builder.hostConfig;
		this.stopSignal = builder.stopSignal;
		this.healthcheck = builder.healthcheck;
		this.networkingConfig = builder.networkingConfig;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
