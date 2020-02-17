package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HostConfig {

	private String[] binds;
	private int blkioWeight;
	private BlkioWeightDevice[] blkioWeightDevice;
	private BlkioDeviceRate[] blkioDeviceReadBps;
	private BlkioDeviceRate[] blkioDeviceWriteBps;
	private BlkioDeviceRate[] blkioDeviceReadIOps;
	private BlkioDeviceRate[] blkioDeviceWriteIOps;
	private String containerIdFile;
	private LxcConfParameter[] lxcConf;
	private boolean privileged;
	private Map<String, PortBinding[]> portBindings;
	private String[] links;
	private boolean publishAllPorts;
	private String[] dns;
	private String[] dnsOptions;
	private String[] dnsSearch;
	private String[] extraHosts;
	private String[] groupAdd;
	private String[] volumesFrom;
	private String[] capAdd;
	private String[] capDrop;
	private String networkMode;
	private String[] securityOpt;
	private Device[] devices;
	private long memory;
	private long memorySwap;
	private int memorySwappiness;
	private long memoryReservation;
	private long kernelMemory;
	private long nanoCpus;
	private long cpuPeriod;
	private long cpuShares;
	private String cpusetCpus;
	private String cpusetMems;
	private long cpuQuota;
	private String cgroupParent;
	private RestartPolicy restartPolicy;
	private LogConfig logConfig;
	private String ipcMode;
	private Ulimit[] ulimits;
	private String pidMode;
	private long shmSize;
	private boolean oomKillDisable;
	private int oomScoreAdj;
	private boolean autoRemove;
	private int pidsLimit;
	private Map<String, String> tmpfs;
	private boolean readonlyRootfs;
	private String runtime;
	private Map<String, String> storageOpt;

	private HostConfig(Builder builder) {
		this.binds = builder.binds;
		this.blkioWeight = builder.blkioWeight;
		this.blkioWeightDevice = builder.blkioWeightDevice;
		this.blkioDeviceReadBps = builder.blkioDeviceReadBps;
		this.blkioDeviceWriteBps = builder.blkioDeviceWriteBps;
		this.blkioDeviceReadIOps = builder.blkioDeviceReadIOps;
		this.blkioDeviceWriteIOps = builder.blkioDeviceWriteIOps;
		this.containerIdFile = builder.containerIdFile;
		this.lxcConf = builder.lxcConf;
		this.privileged = builder.privileged;
		this.portBindings = builder.portBindings;
		this.links = builder.links;
		this.publishAllPorts = builder.publishAllPorts;
		this.dns = builder.dns;
		this.dnsOptions = builder.dnsOptions;
		this.dnsSearch = builder.dnsSearch;
		this.extraHosts = builder.extraHosts;
		this.groupAdd = builder.groupAdd;
		this.volumesFrom = builder.volumesFrom;
		this.capAdd = builder.capAdd;
		this.capDrop = builder.capDrop;
		this.networkMode = builder.networkMode;
		this.securityOpt = builder.securityOpt;
		this.devices = builder.devices;
		this.memory = builder.memory;
		this.memorySwap = builder.memorySwap;
		this.memorySwappiness = builder.memorySwappiness;
		this.memoryReservation = builder.memoryReservation;
		this.kernelMemory = builder.kernelMemory;
		this.nanoCpus = builder.nanoCpus;
		this.cpuPeriod = builder.cpuPeriod;
		this.cpuShares = builder.cpuShares;
		this.cpusetCpus = builder.cpusetCpus;
		this.cpusetMems = builder.cpusetMems;
		this.cpuQuota = builder.cpuQuota;
		this.cgroupParent = builder.cgroupParent;
		this.restartPolicy = builder.restartPolicy;
		this.logConfig = builder.logConfig;
		this.ipcMode = builder.ipcMode;
		this.ulimits = builder.ulimits;
		this.pidMode = builder.pidMode;
		this.shmSize = builder.shmSize;
		this.oomKillDisable = builder.oomKillDisable;
		this.oomScoreAdj = builder.oomScoreAdj;
		this.autoRemove = builder.autoRemove;
		this.pidsLimit = builder.pidsLimit;
		this.tmpfs = builder.tmpfs;
		this.readonlyRootfs = builder.readonlyRootfs;
		this.runtime = builder.runtime;
		this.storageOpt = builder.storageOpt;
	}

	public String[] getBinds() {
		return binds;
	}

	public int getBlkioWeight() {
		return blkioWeight;
	}

	public BlkioWeightDevice[] getBlkioWeightDevice() {
		return blkioWeightDevice;
	}

	public BlkioDeviceRate[] getBlkioDeviceReadBps() {
		return blkioDeviceReadBps;
	}

	public BlkioDeviceRate[] getBlkioDeviceWriteBps() {
		return blkioDeviceWriteBps;
	}

	public BlkioDeviceRate[] getBlkioDeviceReadIOps() {
		return blkioDeviceReadIOps;
	}

	public BlkioDeviceRate[] getBlkioDeviceWriteIOps() {
		return blkioDeviceWriteIOps;
	}

	public String getContainerIdFile() {
		return containerIdFile;
	}

	public LxcConfParameter[] getLxcConf() {
		return lxcConf;
	}

	public boolean isPrivileged() {
		return privileged;
	}

	public Map<String, PortBinding[]> getPortBindings() {
		return portBindings;
	}

	public String[] getLinks() {
		return links;
	}

	public boolean isPublishAllPorts() {
		return publishAllPorts;
	}

	public String[] getDns() {
		return dns;
	}

	public String[] getDnsOptions() {
		return dnsOptions;
	}

	public String[] getDnsSearch() {
		return dnsSearch;
	}

	public String[] getExtraHosts() {
		return extraHosts;
	}

	public String[] getGroupAdd() {
		return groupAdd;
	}

	public String[] getVolumesFrom() {
		return volumesFrom;
	}

	public String[] getCapAdd() {
		return capAdd;
	}

	public String[] getCapDrop() {
		return capDrop;
	}

	public String getNetworkMode() {
		return networkMode;
	}

	public String[] getSecurityOpt() {
		return securityOpt;
	}

	public Device[] getDevices() {
		return devices;
	}

	public long getMemory() {
		return memory;
	}

	public long getMemorySwap() {
		return memorySwap;
	}

	public int getMemorySwappiness() {
		return memorySwappiness;
	}

	public long getMemoryReservation() {
		return memoryReservation;
	}

	public long getKernelMemory() {
		return kernelMemory;
	}

	public long getNanoCpus() {
		return nanoCpus;
	}

	public float cpus(float cpus) {
		return (float) (nanoCpus / 10E8);
	}

	public long getCpuPeriod() {
		return cpuPeriod;
	}

	public long getCpuShares() {
		return cpuShares;
	}

	public String getCpusetCpus() {
		return cpusetCpus;
	}

	public String getCpusetMems() {
		return cpusetMems;
	}

	public long getCpuQuota() {
		return cpuQuota;
	}

	public String getCgroupParent() {
		return cgroupParent;
	}

	public RestartPolicy getRestartPolicy() {
		return restartPolicy;
	}

	public LogConfig getLogConfig() {
		return logConfig;
	}

	public String getIpcMode() {
		return ipcMode;
	}

	public Ulimit[] getUlimits() {
		return ulimits;
	}

	public String getPidMode() {
		return pidMode;
	}

	public long getShmSize() {
		return shmSize;
	}

	public boolean isOomKillDisable() {
		return oomKillDisable;
	}

	public int getOomScoreAdj() {
		return oomScoreAdj;
	}

	public boolean isAutoRemove() {
		return autoRemove;
	}

	public int getPidsLimit() {
		return pidsLimit;
	}

	public Map<String, String> getTmpfs() {
		return tmpfs;
	}

	public boolean isReadonlyRootfs() {
		return readonlyRootfs;
	}

	public String getRuntime() {
		return runtime;
	}

	public Map<String, String> getStorageOpt() {
		return storageOpt;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String[] binds;
		private int blkioWeight;
		private BlkioWeightDevice[] blkioWeightDevice;
		private BlkioDeviceRate[] blkioDeviceReadBps;
		private BlkioDeviceRate[] blkioDeviceWriteBps;
		private BlkioDeviceRate[] blkioDeviceReadIOps;
		private BlkioDeviceRate[] blkioDeviceWriteIOps;
		private String containerIdFile;
		private LxcConfParameter[] lxcConf;
		private boolean privileged;
		private Map<String, PortBinding[]> portBindings;
		private String[] links;
		private boolean publishAllPorts;
		private String[] dns;
		private String[] dnsOptions;
		private String[] dnsSearch;
		private String[] extraHosts;
		private String[] groupAdd;
		private String[] volumesFrom;
		private String[] capAdd;
		private String[] capDrop;
		private String networkMode;
		private String[] securityOpt;
		private Device[] devices;
		private long memory;
		private long memorySwap;
		private int memorySwappiness;
		private long memoryReservation;
		private long kernelMemory;
		private long nanoCpus;
		private long cpuPeriod;
		private long cpuShares;
		private String cpusetCpus;
		private String cpusetMems;
		private long cpuQuota;
		private String cgroupParent;
		private RestartPolicy restartPolicy;
		private LogConfig logConfig;
		private String ipcMode;
		private Ulimit[] ulimits;
		private String pidMode;
		private long shmSize;
		private boolean oomKillDisable;
		private int oomScoreAdj;
		private boolean autoRemove;
		private int pidsLimit;
		private Map<String, String> tmpfs;
		private boolean readonlyRootfs;
		private String runtime;
		private Map<String, String> storageOpt;

		public Builder() {
		}

		public Builder binds(String[] binds) {
			this.binds = binds;
			return Builder.this;
		}

		public Builder blkioWeight(int blkioWeight) {
			this.blkioWeight = blkioWeight;
			return Builder.this;
		}

		public Builder blkioWeightDevice(BlkioWeightDevice[] blkioWeightDevice) {
			this.blkioWeightDevice = blkioWeightDevice;
			return Builder.this;
		}

		public Builder blkioDeviceReadBps(BlkioDeviceRate[] blkioDeviceReadBps) {
			this.blkioDeviceReadBps = blkioDeviceReadBps;
			return Builder.this;
		}

		public Builder blkioDeviceWriteBps(BlkioDeviceRate[] blkioDeviceWriteBps) {
			this.blkioDeviceWriteBps = blkioDeviceWriteBps;
			return Builder.this;
		}

		public Builder blkioDeviceReadIOps(BlkioDeviceRate[] blkioDeviceReadIOps) {
			this.blkioDeviceReadIOps = blkioDeviceReadIOps;
			return Builder.this;
		}

		public Builder blkioDeviceWriteIOps(BlkioDeviceRate[] blkioDeviceWriteIOps) {
			this.blkioDeviceWriteIOps = blkioDeviceWriteIOps;
			return Builder.this;
		}

		public Builder containerIdFile(String containerIdFile) {
			this.containerIdFile = containerIdFile;
			return Builder.this;
		}

		public Builder lxcConf(LxcConfParameter[] lxcConf) {
			this.lxcConf = lxcConf;
			return Builder.this;
		}

		public Builder privileged(boolean privileged) {
			this.privileged = privileged;
			return Builder.this;
		}

		public Builder portBindings(Map<String, PortBinding[]> portBindings) {
			this.portBindings = portBindings;
			return Builder.this;
		}

		public Builder links(String[] links) {
			this.links = links;
			return Builder.this;
		}

		public Builder publishAllPorts(boolean publishAllPorts) {
			this.publishAllPorts = publishAllPorts;
			return Builder.this;
		}

		public Builder dns(String[] dns) {
			this.dns = dns;
			return Builder.this;
		}

		public Builder dnsOptions(String[] dnsOptions) {
			this.dnsOptions = dnsOptions;
			return Builder.this;
		}

		public Builder dnsSearch(String[] dnsSearch) {
			this.dnsSearch = dnsSearch;
			return Builder.this;
		}

		public Builder extraHosts(String[] extraHosts) {
			this.extraHosts = extraHosts;
			return Builder.this;
		}

		public Builder groupAdd(String[] groupAdd) {
			this.groupAdd = groupAdd;
			return Builder.this;
		}

		public Builder volumesFrom(String[] volumesFrom) {
			this.volumesFrom = volumesFrom;
			return Builder.this;
		}

		public Builder capAdd(String[] capAdd) {
			this.capAdd = capAdd;
			return Builder.this;
		}

		public Builder capDrop(String[] capDrop) {
			this.capDrop = capDrop;
			return Builder.this;
		}

		public Builder networkMode(String networkMode) {
			this.networkMode = networkMode;
			return Builder.this;
		}

		public Builder securityOpt(String[] securityOpt) {
			this.securityOpt = securityOpt;
			return Builder.this;
		}

		public Builder devices(Device[] devices) {
			this.devices = devices;
			return Builder.this;
		}

		public Builder memory(long memory) {
			this.memory = memory;
			return Builder.this;
		}

		public Builder memorySwap(long memorySwap) {
			this.memorySwap = memorySwap;
			return Builder.this;
		}

		public Builder memorySwappiness(int memorySwappiness) {
			this.memorySwappiness = memorySwappiness;
			return Builder.this;
		}

		public Builder memoryReservation(long memoryReservation) {
			this.memoryReservation = memoryReservation;
			return Builder.this;
		}

		public Builder kernelMemory(long kernelMemory) {
			this.kernelMemory = kernelMemory;
			return Builder.this;
		}

		public Builder nanoCpus(long nanoCpus) {
			this.nanoCpus = nanoCpus;
			return Builder.this;
		}

		public Builder cpus(float f) {
			this.nanoCpus = (long) (f * 10E8);
			return Builder.this;
		}
		
		public Builder cpuPeriod(long cpuPeriod) {
			this.cpuPeriod = cpuPeriod;
			return Builder.this;
		}

		public Builder cpuShares(long cpuShares) {
			this.cpuShares = cpuShares;
			return Builder.this;
		}

		public Builder cpusetCpus(String cpusetCpus) {
			this.cpusetCpus = cpusetCpus;
			return Builder.this;
		}

		public Builder cpusetMems(String cpusetMems) {
			this.cpusetMems = cpusetMems;
			return Builder.this;
		}

		public Builder cpuQuota(long cpuQuota) {
			this.cpuQuota = cpuQuota;
			return Builder.this;
		}

		public Builder cgroupParent(String cgroupParent) {
			this.cgroupParent = cgroupParent;
			return Builder.this;
		}

		public Builder restartPolicy(RestartPolicy restartPolicy) {
			this.restartPolicy = restartPolicy;
			return Builder.this;
		}

		public Builder logConfig(LogConfig logConfig) {
			this.logConfig = logConfig;
			return Builder.this;
		}

		public Builder ipcMode(String ipcMode) {
			this.ipcMode = ipcMode;
			return Builder.this;
		}

		public Builder ulimits(Ulimit[] ulimits) {
			this.ulimits = ulimits;
			return Builder.this;
		}

		public Builder pidMode(String pidMode) {
			this.pidMode = pidMode;
			return Builder.this;
		}

		public Builder shmSize(long shmSize) {
			this.shmSize = shmSize;
			return Builder.this;
		}

		public Builder oomKillDisable(boolean oomKillDisable) {
			this.oomKillDisable = oomKillDisable;
			return Builder.this;
		}

		public Builder oomScoreAdj(int oomScoreAdj) {
			this.oomScoreAdj = oomScoreAdj;
			return Builder.this;
		}

		public Builder autoRemove(boolean autoRemove) {
			this.autoRemove = autoRemove;
			return Builder.this;
		}

		public Builder pidsLimit(int pidsLimit) {
			this.pidsLimit = pidsLimit;
			return Builder.this;
		}

		public Builder tmpfs(Map<String, String> tmpfs) {
			this.tmpfs = tmpfs;
			return Builder.this;
		}

		public Builder readonlyRootfs(boolean readonlyRootfs) {
			this.readonlyRootfs = readonlyRootfs;
			return Builder.this;
		}

		public Builder runtime(String runtime) {
			this.runtime = runtime;
			return Builder.this;
		}

		public Builder storageOpt(Map<String, String> storageOpt) {
			this.storageOpt = storageOpt;
			return Builder.this;
		}

		public HostConfig build() {

			return new HostConfig(this);
		}
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
