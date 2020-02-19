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
	private List<String> portSpecs;
	private Set<String> exposedPorts;
	private boolean tty;
	private boolean openStdin;
	private boolean stdinOnce;
	private List<String> env;
	private List<String> cmd;
	private String image;
	private Map<String, Object> volumes;
	private String workingDir;
	private List<String> entrypoint;
	private boolean networkDisabled;
	private List<String> onBuild;
	private Map<String, String> labels;
	private String macAddress;
	private HostConfig hostConfig;
	private String stopSignal;
	private Healthcheck healthcheck;
	private NetworkingConfig networkingConfig;

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
		if (builder.volumes != null) {
			if (this.volumes == null) {
				this.volumes = new HashMap<>();
			}
			for (String s : builder.volumes) {
				this.volumes.put(s, new Object());
			}
		}
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

	public List<String> getPortSpecs() {
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

	public List<String> getEnv() {
		return env;
	}

	public List<String> getCmd() {
		return cmd;
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

	public List<String> getEntryPoint() {
		return entrypoint;
	}

	public boolean isNetworkDisabled() {
		return networkDisabled;
	}

	public List<String> getOnBuild() {
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
		private boolean attachStdin = false;
		private boolean attachStdout = true;
		private boolean attachStderr = true;
		private List<String> portSpecs;
		private Set<String> exposedPorts;
		private boolean tty;
		private boolean openStdin;
		private boolean stdinOnce;
		private List<String> env;
		private List<String> cmd;
		private String image;
		private Set<String> volumes;
		private String workingDir;
		private List<String> entrypoint;
		private boolean networkDisabled;
		private List<String> onBuild;
		private Map<String, String> labels;
		private String macAddress;
		private HostConfig hostConfig;
		private String stopSignal;
		private Healthcheck healthcheck;
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

		public Builder interactive() {
			return this.openStdin(true).attachStdin(true);
		}

		public Builder attachStdout(boolean attachStdout) {
			this.attachStdout = attachStdout;
			return Builder.this;
		}

		public Builder attachStderr(boolean attachStderr) {
			this.attachStderr = attachStderr;
			return Builder.this;
		}

		public Builder portSpecs(List<String> portSpecs) {
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

		public Builder env(List<String> env) {
			this.env = env;
			return Builder.this;
		}

		public Builder addEnv(String env) {
			if (this.env == null) {
				this.env = new ArrayList<>();
			}
			this.env.add(env);
			return Builder.this;
		}

		public Builder cmd(List<String> cmd) {
			this.cmd = cmd;
			return Builder.this;
		}

		public Builder cmd(String... cmd) {
			this.cmd = Arrays.asList(cmd);
			return Builder.this;
		}
		
		public Builder addCmd(String cmd) {
			if (this.cmd == null) {
				this.cmd = new ArrayList<>();
			}
			this.cmd.add(cmd);
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

		public Builder addVolumes(String volume) {
			if (this.volumes == null) {
				this.volumes = new HashSet<>();
			}
			this.volumes.add(volume);
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
			if (this.entrypoint == null) {
				this.entrypoint = new ArrayList<>();
			}
			this.entrypoint.add(entrypoint);
			return Builder.this;
		}

		public Builder networkDisabled(boolean networkDisabled) {
			this.networkDisabled = networkDisabled;
			return Builder.this;
		}

		public Builder onBuild(List<String> onBuild) {
			this.onBuild = onBuild;
			return Builder.this;
		}

		public Builder addOnBuild(String onBuild) {
			if (this.onBuild == null) {
				this.onBuild = new ArrayList<>();
			}
			this.onBuild.add(onBuild);
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

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
