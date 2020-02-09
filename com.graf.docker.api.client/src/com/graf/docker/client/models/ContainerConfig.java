package com.graf.docker.client.models;

import java.util.Map;
import java.util.Set;

public class ContainerConfig {
	
	private String hostname = "";
	private String domainname = "";
	private String user = "";
	private boolean attachStdin = false;
	private boolean attachStdout = true;
	private boolean attachStderr = true;
	private String[] portSpecs = new String[0];
	private Set<String> exposedPorts;
	private boolean tty = false;
	private boolean openStdin = false;
	private boolean stdinOnce = false;
	private String[] env = new String[0];
	private String[] cmd = new String[0];
	private String image = "";
	private Set<String> volumes;
	private String workingDir = "";
	private String[] entryPoint = new String[0];
	private boolean networkDisabled = false;
	private String[] onBuild = new String[0];
	private Map<String, String> labels;
	private String macAddress = "";
	private HostConfig hostConfig;
	private String stopSignal = "";
	private Healthcheck healthcheck;
	private NetworkingConfig networkingConfig;

	private ContainerConfig() {
		// builder pattern
	}
	
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
		return entryPoint;
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

	public static class ContainerConfigBuilder{
		
		private ContainerConfig config;
		
		private ContainerConfigBuilder() {
			config = new ContainerConfig();
		}
		
		public static ContainerConfigBuilder create() {
			return new ContainerConfigBuilder();
		}
		
		public ContainerConfigBuilder setHostName(String hostname) {
			config.hostname = hostname;
			return this;
		}
		
		public ContainerConfigBuilder setImage(String image) {
			config.image = image;
			return this;
		}
		
		public ContainerConfig build() {
			return new ContainerConfig(config);
		}
	}
	
	public class Healthcheck {

		private String[] test;
		private long interval;
		private long timeout;
		private int retries;
		private long startPeriod;

		public String[] getTest() {
			return test;
		}

		public long getInterval() {
			return interval;
		}

		public long getTimeout() {
			return timeout;
		}

		public int getRetries() {
			return retries;
		}

		public long getStartPeriod() {
			return startPeriod;
		}
	}

	public class NetworkingConfig {
		private Map<String, EndpointConfig> endpointsConfig;

		public Map<String, EndpointConfig> getEndpointsConfig() {
			return endpointsConfig;
		}
	}
}
