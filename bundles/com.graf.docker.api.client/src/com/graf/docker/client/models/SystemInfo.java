package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class SystemInfo {

	@SerializedName("ID")
	private String id;
	private int containers;
	private int containerRunning;
	private int containersPaused;
	private int images;
	private String driver;
	private List<List<String>> driverStatus;
	private String dockerRootDir;
	private List<List<String>> systemStatus;
	private PluginInfo plugins;
	private boolean memoryLimit;
	private boolean swapLimit;
	private boolean kernelMemory;
	private boolean cpuCfsPeriod;
	private boolean cpuCfsQuota;
	@SerializedName("CPUShares")
	private boolean cpuShares;
	@SerializedName("CPUSet")
	private boolean cpuSet;
	private boolean pidsLimit;
	private boolean oomKillDisable;
	@SerializedName("IPv4Forwarding")
	private boolean ipv4Forwarding;
	private boolean bridgeNfIptables;
	private boolean bridgeNfIp6tables;
	private boolean debug;
	private int nfd;
	private int nGoroutines;
	private String systemTime;
	private String loggingDriver;
	private String cgroupDriver;
	private int nEventListener;
	private String kernelVersion;
	private String operatingSystem;
	@SerializedName("OSType")
	private String osType;
	private String architecture;
	@SerializedName("NCPU")
	private int ncpu;
	private long memTotal;
	private String indexServerAddress;
	private RegistryServiceConfig registryConfig;
	private List<Map<String, ResourceSpec>> genericResources;
	private String httpProxy;
	private String httpsProxy;
	private String noProxy;
	private String name;
	private List<String> labels;
	private boolean experimentalBuild;
	private String serverVersion;
	private String clusterStore;
	private String clusterAdvertise;
	private Map<String, Runtime> runtimes;
	private String defaultRuntime;
	private SwarmInfo swarm;
	private boolean liveRestoreEnabled;
	private String isolation;
	private String initBinary;
	private Commit containerdCommit;
	private Commit RuncCommit;
	private Commit initCommit;
	private List<String> securityOptions;
	private String productLicense;
	private List<String> warnings;

	public String getId() {
		return id;
	}

	public int getContainers() {
		return containers;
	}

	public int getContainerRunning() {
		return containerRunning;
	}

	public int getContainersPaused() {
		return containersPaused;
	}

	public int getImages() {
		return images;
	}

	public String getDriver() {
		return driver;
	}

	public List<List<String>> getDriverStatus() {
		return driverStatus;
	}

	public String getDockerRootDir() {
		return dockerRootDir;
	}

	public List<List<String>> getSystemStatus() {
		return systemStatus;
	}

	public PluginInfo getPlugins() {
		return plugins;
	}

	public boolean isMemoryLimit() {
		return memoryLimit;
	}

	public boolean isSwapLimit() {
		return swapLimit;
	}

	public boolean isKernelMemory() {
		return kernelMemory;
	}

	public boolean isCpuCfsPeriod() {
		return cpuCfsPeriod;
	}

	public boolean isCpuCfsQuota() {
		return cpuCfsQuota;
	}

	public boolean isCpuShares() {
		return cpuShares;
	}

	public boolean isCpuSet() {
		return cpuSet;
	}

	public boolean isPidsLimit() {
		return pidsLimit;
	}

	public boolean isOomKillDisable() {
		return oomKillDisable;
	}

	public boolean isIpv4Forwarding() {
		return ipv4Forwarding;
	}

	public boolean isBridgeNfIptables() {
		return bridgeNfIptables;
	}

	public boolean isBridgeNfIp6tables() {
		return bridgeNfIp6tables;
	}

	public boolean isDebug() {
		return debug;
	}

	public int getNfd() {
		return nfd;
	}

	public int getnGoroutines() {
		return nGoroutines;
	}

	public String getSystemTime() {
		return systemTime;
	}

	public String getLoggingDriver() {
		return loggingDriver;
	}

	public String getCgroupDriver() {
		return cgroupDriver;
	}

	public int getnEventListener() {
		return nEventListener;
	}

	public String getKernelVersion() {
		return kernelVersion;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public String getOsType() {
		return osType;
	}

	public String getArchitecture() {
		return architecture;
	}

	public int getNcpu() {
		return ncpu;
	}

	public long getMemTotal() {
		return memTotal;
	}

	public String getIndexServerAddress() {
		return indexServerAddress;
	}

	public RegistryServiceConfig getRegistryConfig() {
		return registryConfig;
	}

	public List<Map<String, ResourceSpec>> getGenericResources() {
		return genericResources;
	}

	public String getHttpProxy() {
		return httpProxy;
	}

	public String getHttpsProxy() {
		return httpsProxy;
	}

	public String getNoProxy() {
		return noProxy;
	}

	public String getName() {
		return name;
	}

	public List<String> getLabels() {
		return labels;
	}

	public boolean isExperimentalBuild() {
		return experimentalBuild;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public String getClusterStore() {
		return clusterStore;
	}

	public String getClusterAdvertise() {
		return clusterAdvertise;
	}

	public Map<String, Runtime> getRuntimes() {
		return runtimes;
	}

	public String getDefaultRuntime() {
		return defaultRuntime;
	}

	public SwarmInfo getSwarm() {
		return swarm;
	}

	public boolean isLiveRestoreEnabled() {
		return liveRestoreEnabled;
	}

	public String getIsolation() {
		return isolation;
	}

	public String getInitBinary() {
		return initBinary;
	}

	public Commit getContainerdCommit() {
		return containerdCommit;
	}

	public Commit getRuncCommit() {
		return RuncCommit;
	}

	public Commit getInitCommit() {
		return initCommit;
	}

	public List<String> getSecurityOptions() {
		return securityOptions;
	}

	public String getProductLicense() {
		return productLicense;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
