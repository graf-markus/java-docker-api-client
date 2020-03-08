package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class HostConfig {

	private int cpuShares;
	private long memory;
	private String cgroupParent;
	private List<BlkioWeightDevice> blkioWeightDevice;
	private List<ThrottleDevice> blkioDeviceReadBps;
	private List<ThrottleDevice> blkioDeviceWriteBps;
	private List<ThrottleDevice> blkioDeviceReadIOps;
	private List<ThrottleDevice> blkioDeviceWriteIOps;
	private long cpuPeriod;
	private long cpuQuota;
	private long cpuRealtimePeriod;
	private long cpuRealtimeRuntime;
	private String cpusetCpus;
	private String cpusetMems;
	private List<DeviceMapping> devices;
	private List<String> deviceCgroupRules;
	private List<DeviceRequest> deviceRequests;
	private long kernelMemory;
	@SerializedName("KernelMemoryTCP")
	private long kernelMemoryTcp;
	private long memoryReservation;
	private long memorySwap;
	private long memorySwappiness;
	private long nanoCpus;
	private boolean oomKillDisable;
	private boolean init;
	private long pidsLimit;
	private List<Ulimit> ulimits;
	@SerializedName("IOMaximumBandwidth")
	private long ioMaximumBandwidth;
	private List<String> binds;
	@SerializedName("ContainerIDFile")
	private String containerIdFile;
	private LogConfig logConfig;
	private String networkMode;
	private PortMap portBindings;
	private RestartPolicy restartPolicy;
	private boolean autoRemove;
	private String volumeDriver;
	private List<String> volumesFrom;
	private List<Mount> mounts;
	private List<String> capabilities;
	private List<String> capAdd;
	private List<String> capDrop;
	private List<String> dns;
	private List<String> dnsOptions;
	private List<String> dnsSearch;
	private List<String> extraHosts;
	private List<String> groupAdd;
	private String ipcMode;
	private String cgroup;
	private List<String> links;
	private int oomScoreAdj;
	private String pidMode;
	private boolean privileged;
	private boolean publishAllPorts;
	private boolean readonlyRootfs;
	private List<String> securityOpt;
	private Map<String, String> storageOpt;
	private Map<String, String> tmpfs;
	@SerializedName("UTSMode")
	private String utsMode;
	private String usernsMode;
	private int shmSize;
	private Map<String, String> sysctls;
	private String runtime;
	private List<String> maskedPaths;
	private List<String> readonlyPath;

	private HostConfig(Builder builder) {
		this.cpuShares = builder.cpuShares;
		this.memory = builder.memory;
		this.cgroupParent = builder.cgroupParent;
		this.blkioWeightDevice = builder.blkioWeightDevice;
		this.blkioDeviceReadBps = builder.blkioDeviceReadBps;
		this.blkioDeviceWriteBps = builder.blkioDeviceWriteBps;
		this.blkioDeviceReadIOps = builder.blkioDeviceReadIOps;
		this.blkioDeviceWriteIOps = builder.blkioDeviceWriteIOps;
		this.cpuPeriod = builder.cpuPeriod;
		this.cpuQuota = builder.cpuQuota;
		this.cpuRealtimePeriod = builder.cpuRealtimePeriod;
		this.cpuRealtimeRuntime = builder.cpuRealtimeRuntime;
		this.cpusetCpus = builder.cpusetCpus;
		this.cpusetMems = builder.cpusetMems;
		this.devices = builder.devices;
		this.deviceCgroupRules = builder.deviceCgroupRules;
		this.deviceRequests = builder.deviceRequests;
		this.kernelMemory = builder.kernelMemory;
		this.kernelMemoryTcp = builder.kernelMemoryTcp;
		this.memoryReservation = builder.memoryReservation;
		this.memorySwap = builder.memorySwap;
		this.memorySwappiness = builder.memorySwappiness;
		this.nanoCpus = builder.nanoCpus;
		this.oomKillDisable = builder.oomKillDisable;
		this.init = builder.init;
		this.pidsLimit = builder.pidsLimit;
		this.ulimits = builder.ulimits;
		this.ioMaximumBandwidth = builder.ioMaximumBandwidth;
		this.binds = builder.binds;
		this.containerIdFile = builder.containerIdFile;
		this.logConfig = builder.logConfig;
		this.networkMode = builder.networkMode;
		this.portBindings = builder.portBindings;
		this.restartPolicy = builder.restartPolicy;
		this.autoRemove = builder.autoRemove;
		this.volumeDriver = builder.volumeDriver;
		this.volumesFrom = builder.volumesFrom;
		this.mounts = builder.mounts;
		this.capabilities = builder.capabilities;
		this.capAdd = builder.capAdd;
		this.capDrop = builder.capDrop;
		this.dns = builder.dns;
		this.dnsOptions = builder.dnsOptions;
		this.dnsSearch = builder.dnsSearch;
		this.extraHosts = builder.extraHosts;
		this.groupAdd = builder.groupAdd;
		this.ipcMode = builder.ipcMode;
		this.cgroup = builder.cgroup;
		this.links = builder.links;
		this.oomScoreAdj = builder.oomScoreAdj;
		this.pidMode = builder.pidMode;
		this.privileged = builder.privileged;
		this.publishAllPorts = builder.publishAllPorts;
		this.readonlyRootfs = builder.readonlyRootfs;
		this.securityOpt = builder.securityOpt;
		this.storageOpt = builder.storageOpt;
		this.tmpfs = builder.tmpfs;
		this.utsMode = builder.utsMode;
		this.usernsMode = builder.usernsMode;
		this.shmSize = builder.shmSize;
		this.sysctls = builder.sysctls;
		this.runtime = builder.runtime;
		this.maskedPaths = builder.maskedPaths;
		this.readonlyPath = builder.readonlyPath;
	}

	public int getCpuShares() {
		return cpuShares;
	}

	public long getMemory() {
		return memory;
	}

	public String getCgroupParent() {
		return cgroupParent;
	}

	public List<BlkioWeightDevice> getBlkioWeightDevice() {
		return blkioWeightDevice;
	}

	public List<ThrottleDevice> getBlkioDeviceReadBps() {
		return blkioDeviceReadBps;
	}

	public List<ThrottleDevice> getBlkioDeviceWriteBps() {
		return blkioDeviceWriteBps;
	}

	public List<ThrottleDevice> getBlkioDeviceReadIOps() {
		return blkioDeviceReadIOps;
	}

	public List<ThrottleDevice> getBlkioDeviceWriteIOps() {
		return blkioDeviceWriteIOps;
	}

	public long getCpuPeriod() {
		return cpuPeriod;
	}

	public long getCpuQuota() {
		return cpuQuota;
	}

	public long getCpuRealtimePeriod() {
		return cpuRealtimePeriod;
	}

	public long getCpuRealtimeRuntime() {
		return cpuRealtimeRuntime;
	}

	public String getCpusetCpus() {
		return cpusetCpus;
	}

	public String getCpusetMems() {
		return cpusetMems;
	}

	public List<DeviceMapping> getDevices() {
		return devices;
	}

	public List<String> getDeviceCgroupRules() {
		return deviceCgroupRules;
	}

	public List<DeviceRequest> getDeviceRequests() {
		return deviceRequests;
	}

	public long getKernelMemory() {
		return kernelMemory;
	}

	public long getKernelMemoryTcp() {
		return kernelMemoryTcp;
	}

	public long getMemoryReservation() {
		return memoryReservation;
	}

	public long getMemorySwap() {
		return memorySwap;
	}

	public long getMemorySwappiness() {
		return memorySwappiness;
	}

	public long getNanoCpus() {
		return nanoCpus;
	}

	public boolean isOomKillDisable() {
		return oomKillDisable;
	}

	public boolean isInit() {
		return init;
	}

	public long getPidsLimit() {
		return pidsLimit;
	}

	public List<Ulimit> getUlimits() {
		return ulimits;
	}

	public long getIoMaximumBandwidth() {
		return ioMaximumBandwidth;
	}

	public List<String> getBinds() {
		return binds;
	}

	public String getContainerIdFile() {
		return containerIdFile;
	}

	public LogConfig getLogConfig() {
		return logConfig;
	}

	public String getNetworkMode() {
		return networkMode;
	}

	public PortMap getPortBindings() {
		return portBindings;
	}

	public RestartPolicy getRestartPolicy() {
		return restartPolicy;
	}

	public boolean isAutoRemove() {
		return autoRemove;
	}

	public String getVolumeDriver() {
		return volumeDriver;
	}

	public List<String> getVolumesFrom() {
		return volumesFrom;
	}

	public List<Mount> getMounts() {
		return mounts;
	}

	public List<String> getCapabilities() {
		return capabilities;
	}

	public List<String> getCapAdd() {
		return capAdd;
	}

	public List<String> getCapDrop() {
		return capDrop;
	}

	public List<String> getDns() {
		return dns;
	}

	public List<String> getDnsOptions() {
		return dnsOptions;
	}

	public List<String> getDnsSearch() {
		return dnsSearch;
	}

	public List<String> getExtraHosts() {
		return extraHosts;
	}

	public List<String> getGroupAdd() {
		return groupAdd;
	}

	public String getIpcMode() {
		return ipcMode;
	}

	public String getCgroup() {
		return cgroup;
	}

	public List<String> getLinks() {
		return links;
	}

	public int getOomScoreAdj() {
		return oomScoreAdj;
	}

	public String getPidMode() {
		return pidMode;
	}

	public boolean isPrivileged() {
		return privileged;
	}

	public boolean isPublishAllPorts() {
		return publishAllPorts;
	}

	public boolean isReadonlyRootfs() {
		return readonlyRootfs;
	}

	public List<String> getSecurityOpt() {
		return securityOpt;
	}

	public Map<String, String> getStorageOpt() {
		return storageOpt;
	}

	public Map<String, String> getTmpfs() {
		return tmpfs;
	}

	public String getUtsMode() {
		return utsMode;
	}

	public String getUsernsMode() {
		return usernsMode;
	}

	public int getShmSize() {
		return shmSize;
	}

	public Map<String, String> getSysctls() {
		return sysctls;
	}

	public String getRuntime() {
		return runtime;
	}

	public List<String> getMaskedPaths() {
		return maskedPaths;
	}

	public List<String> getReadonlyPath() {
		return readonlyPath;
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

		private int cpuShares;
		private long memory;
		private String cgroupParent;
		private List<BlkioWeightDevice> blkioWeightDevice = new ArrayList<BlkioWeightDevice>();
		private List<ThrottleDevice> blkioDeviceReadBps = new ArrayList<ThrottleDevice>();
		private List<ThrottleDevice> blkioDeviceWriteBps = new ArrayList<ThrottleDevice>();
		private List<ThrottleDevice> blkioDeviceReadIOps = new ArrayList<ThrottleDevice>();
		private List<ThrottleDevice> blkioDeviceWriteIOps = new ArrayList<ThrottleDevice>();
		private long cpuPeriod;
		private long cpuQuota;
		private long cpuRealtimePeriod;
		private long cpuRealtimeRuntime;
		private String cpusetCpus;
		private String cpusetMems;
		private List<DeviceMapping> devices = new ArrayList<DeviceMapping>();
		private List<String> deviceCgroupRules = new ArrayList<String>();
		private List<DeviceRequest> deviceRequests = new ArrayList<DeviceRequest>();
		private long kernelMemory;
		private long kernelMemoryTcp;
		private long memoryReservation;
		private long memorySwap;
		private long memorySwappiness;
		private long nanoCpus;
		private boolean oomKillDisable;
		private boolean init;
		private long pidsLimit;
		private List<Ulimit> ulimits = new ArrayList<Ulimit>();
		private long ioMaximumBandwidth;
		private List<String> binds = new ArrayList<String>();
		private String containerIdFile;
		private LogConfig logConfig;
		private String networkMode;
		private PortMap portBindings;
		private RestartPolicy restartPolicy;
		private boolean autoRemove;
		private String volumeDriver;
		private List<String> volumesFrom = new ArrayList<String>();
		private List<Mount> mounts = new ArrayList<Mount>();
		private List<String> capabilities = new ArrayList<String>();
		private List<String> capAdd = new ArrayList<String>();
		private List<String> capDrop = new ArrayList<String>();
		private List<String> dns = new ArrayList<String>();
		private List<String> dnsOptions = new ArrayList<String>();
		private List<String> dnsSearch = new ArrayList<String>();
		private List<String> extraHosts = new ArrayList<String>();
		private List<String> groupAdd = new ArrayList<String>();
		private String ipcMode;
		private String cgroup;
		private List<String> links = new ArrayList<String>();
		private int oomScoreAdj;
		private String pidMode;
		private boolean privileged;
		private boolean publishAllPorts;
		private boolean readonlyRootfs;
		private List<String> securityOpt = new ArrayList<String>();
		private Map<String, String> storageOpt;
		private Map<String, String> tmpfs;
		private String utsMode;
		private String usernsMode;
		private int shmSize;
		private Map<String, String> sysctls;
		private String runtime;
		private List<String> maskedPaths = new ArrayList<String>();
		private List<String> readonlyPath = new ArrayList<String>();

		public Builder() {
		}

		public Builder cpuShares(int cpuShares) {
			this.cpuShares = cpuShares;
			return Builder.this;
		}

		public Builder memory(long memory) {
			this.memory = memory;
			return Builder.this;
		}

		public Builder cgroupParent(String cgroupParent) {
			this.cgroupParent = cgroupParent;
			return Builder.this;
		}

		public Builder blkioWeightDevice(List<BlkioWeightDevice> blkioWeightDevice) {
			this.blkioWeightDevice = blkioWeightDevice;
			return Builder.this;
		}

		public Builder addBlkioWeightDevice(BlkioWeightDevice blkioWeightDevice) {
			this.blkioWeightDevice.add(blkioWeightDevice);
			return Builder.this;
		}

		public Builder blkioDeviceReadBps(List<ThrottleDevice> blkioDeviceReadBps) {
			this.blkioDeviceReadBps = blkioDeviceReadBps;
			return Builder.this;
		}

		public Builder addBlkioDeviceReadBps(ThrottleDevice blkioDeviceReadBps) {
			this.blkioDeviceReadBps.add(blkioDeviceReadBps);
			return Builder.this;
		}

		public Builder blkioDeviceWriteBps(List<ThrottleDevice> blkioDeviceWriteBps) {
			this.blkioDeviceWriteBps = blkioDeviceWriteBps;
			return Builder.this;
		}

		public Builder addBlkioDeviceWriteBps(ThrottleDevice blkioDeviceWriteBps) {
			this.blkioDeviceWriteBps.add(blkioDeviceWriteBps);
			return Builder.this;
		}

		public Builder blkioDeviceReadIOps(List<ThrottleDevice> blkioDeviceReadIOps) {
			this.blkioDeviceReadIOps = blkioDeviceReadIOps;
			return Builder.this;
		}

		public Builder addBlkioDeviceReadIOps(ThrottleDevice blkioDeviceReadIOps) {
			this.blkioDeviceReadIOps.add(blkioDeviceReadIOps);
			return Builder.this;
		}

		public Builder blkioDeviceWriteIOps(List<ThrottleDevice> blkioDeviceWriteIOps) {
			this.blkioDeviceWriteIOps = blkioDeviceWriteIOps;
			return Builder.this;
		}

		public Builder addBlkioDeviceWriteIOps(ThrottleDevice blkioDeviceWriteIOps) {
			this.blkioDeviceWriteIOps.add(blkioDeviceWriteIOps);
			return Builder.this;
		}

		public Builder cpuPeriod(long cpuPeriod) {
			this.cpuPeriod = cpuPeriod;
			return Builder.this;
		}

		public Builder cpuQuota(long cpuQuota) {
			this.cpuQuota = cpuQuota;
			return Builder.this;
		}

		public Builder cpuRealtimePeriod(long cpuRealtimePeriod) {
			this.cpuRealtimePeriod = cpuRealtimePeriod;
			return Builder.this;
		}

		public Builder cpuRealtimeRuntime(long cpuRealtimeRuntime) {
			this.cpuRealtimeRuntime = cpuRealtimeRuntime;
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

		public Builder devices(List<DeviceMapping> devices) {
			this.devices = devices;
			return Builder.this;
		}

		public Builder addDevices(DeviceMapping devices) {
			this.devices.add(devices);
			return Builder.this;
		}

		public Builder deviceCgroupRules(List<String> deviceCgroupRules) {
			this.deviceCgroupRules = deviceCgroupRules;
			return Builder.this;
		}

		public Builder addDeviceCgroupRules(String deviceCgroupRules) {
			this.deviceCgroupRules.add(deviceCgroupRules);
			return Builder.this;
		}

		public Builder deviceRequests(List<DeviceRequest> deviceRequests) {
			this.deviceRequests = deviceRequests;
			return Builder.this;
		}

		public Builder addDeviceRequests(DeviceRequest deviceRequests) {
			this.deviceRequests.add(deviceRequests);
			return Builder.this;
		}

		public Builder kernelMemory(long kernelMemory) {
			this.kernelMemory = kernelMemory;
			return Builder.this;
		}

		public Builder kernelMemoryTcp(long kernelMemoryTcp) {
			this.kernelMemoryTcp = kernelMemoryTcp;
			return Builder.this;
		}

		public Builder memoryReservation(long memoryReservation) {
			this.memoryReservation = memoryReservation;
			return Builder.this;
		}

		public Builder memorySwap(long memorySwap) {
			this.memorySwap = memorySwap;
			return Builder.this;
		}

		public Builder memorySwappiness(long memorySwappiness) {
			this.memorySwappiness = memorySwappiness;
			return Builder.this;
		}

		public Builder nanoCpus(long nanoCpus) {
			this.nanoCpus = nanoCpus;
			return Builder.this;
		}

		public Builder oomKillDisable(boolean oomKillDisable) {
			this.oomKillDisable = oomKillDisable;
			return Builder.this;
		}

		public Builder init(boolean init) {
			this.init = init;
			return Builder.this;
		}

		public Builder pidsLimit(long pidsLimit) {
			this.pidsLimit = pidsLimit;
			return Builder.this;
		}

		public Builder ulimits(List<Ulimit> ulimits) {
			this.ulimits = ulimits;
			return Builder.this;
		}

		public Builder addUlimits(Ulimit ulimits) {
			this.ulimits.add(ulimits);
			return Builder.this;
		}

		public Builder ioMaximumBandwidth(long ioMaximumBandwidth) {
			this.ioMaximumBandwidth = ioMaximumBandwidth;
			return Builder.this;
		}

		public Builder binds(List<String> binds) {
			this.binds = binds;
			return Builder.this;
		}

		public Builder addBinds(String binds) {
			this.binds.add(binds);
			return Builder.this;
		}

		public Builder containerIdFile(String containerIdFile) {
			this.containerIdFile = containerIdFile;
			return Builder.this;
		}

		public Builder logConfig(LogConfig logConfig) {
			this.logConfig = logConfig;
			return Builder.this;
		}

		public Builder networkMode(String networkMode) {
			this.networkMode = networkMode;
			return Builder.this;
		}

		public Builder portBindings(PortMap portBindings) {
			this.portBindings = portBindings;
			return Builder.this;
		}

		public Builder restartPolicy(RestartPolicy restartPolicy) {
			this.restartPolicy = restartPolicy;
			return Builder.this;
		}

		public Builder autoRemove(boolean autoRemove) {
			this.autoRemove = autoRemove;
			return Builder.this;
		}

		public Builder volumeDriver(String volumeDriver) {
			this.volumeDriver = volumeDriver;
			return Builder.this;
		}

		public Builder volumesFrom(List<String> volumesFrom) {
			this.volumesFrom = volumesFrom;
			return Builder.this;
		}

		public Builder addVolumesFrom(String volumesFrom) {
			this.volumesFrom.add(volumesFrom);
			return Builder.this;
		}

		public Builder mounts(List<Mount> mounts) {
			this.mounts = mounts;
			return Builder.this;
		}

		public Builder addMounts(Mount mounts) {
			this.mounts.add(mounts);
			return Builder.this;
		}

		public Builder capabilities(List<String> capabilities) {
			this.capabilities = capabilities;
			return Builder.this;
		}

		public Builder addCapabilities(String capabilities) {
			this.capabilities.add(capabilities);
			return Builder.this;
		}

		public Builder capAdd(List<String> capAdd) {
			this.capAdd = capAdd;
			return Builder.this;
		}

		public Builder addCapAdd(String capAdd) {
			this.capAdd.add(capAdd);
			return Builder.this;
		}

		public Builder capDrop(List<String> capDrop) {
			this.capDrop = capDrop;
			return Builder.this;
		}

		public Builder addCapDrop(String capDrop) {
			this.capDrop.add(capDrop);
			return Builder.this;
		}

		public Builder dns(List<String> dns) {
			this.dns = dns;
			return Builder.this;
		}

		public Builder addDns(String dns) {
			this.dns.add(dns);
			return Builder.this;
		}

		public Builder dnsOptions(List<String> dnsOptions) {
			this.dnsOptions = dnsOptions;
			return Builder.this;
		}

		public Builder addDnsOptions(String dnsOptions) {
			this.dnsOptions.add(dnsOptions);
			return Builder.this;
		}

		public Builder dnsSearch(List<String> dnsSearch) {
			this.dnsSearch = dnsSearch;
			return Builder.this;
		}

		public Builder addDnsSearch(String dnsSearch) {
			this.dnsSearch.add(dnsSearch);
			return Builder.this;
		}

		public Builder extraHosts(List<String> extraHosts) {
			this.extraHosts = extraHosts;
			return Builder.this;
		}

		public Builder addExtraHosts(String extraHosts) {
			this.extraHosts.add(extraHosts);
			return Builder.this;
		}

		public Builder groupAdd(List<String> groupAdd) {
			this.groupAdd = groupAdd;
			return Builder.this;
		}

		public Builder addGroupAdd(String groupAdd) {
			this.groupAdd.add(groupAdd);
			return Builder.this;
		}

		public Builder ipcMode(String ipcMode) {
			this.ipcMode = ipcMode;
			return Builder.this;
		}

		public Builder cgroup(String cgroup) {
			this.cgroup = cgroup;
			return Builder.this;
		}

		public Builder links(List<String> links) {
			this.links = links;
			return Builder.this;
		}

		public Builder addLinks(String links) {
			this.links.add(links);
			return Builder.this;
		}

		public Builder oomScoreAdj(int oomScoreAdj) {
			this.oomScoreAdj = oomScoreAdj;
			return Builder.this;
		}

		public Builder pidMode(String pidMode) {
			this.pidMode = pidMode;
			return Builder.this;
		}

		public Builder privileged(boolean privileged) {
			this.privileged = privileged;
			return Builder.this;
		}

		public Builder publishAllPorts(boolean publishAllPorts) {
			this.publishAllPorts = publishAllPorts;
			return Builder.this;
		}

		public Builder readonlyRootfs(boolean readonlyRootfs) {
			this.readonlyRootfs = readonlyRootfs;
			return Builder.this;
		}

		public Builder securityOpt(List<String> securityOpt) {
			this.securityOpt = securityOpt;
			return Builder.this;
		}

		public Builder addSecurityOpt(String securityOpt) {
			this.securityOpt.add(securityOpt);
			return Builder.this;
		}

		public Builder storageOpt(Map<String, String> storageOpt) {
			this.storageOpt = storageOpt;
			return Builder.this;
		}

		public Builder tmpfs(Map<String, String> tmpfs) {
			this.tmpfs = tmpfs;
			return Builder.this;
		}

		public Builder utsMode(String utsMode) {
			this.utsMode = utsMode;
			return Builder.this;
		}

		public Builder usernsMode(String usernsMode) {
			this.usernsMode = usernsMode;
			return Builder.this;
		}

		public Builder shmSize(int shmSize) {
			this.shmSize = shmSize;
			return Builder.this;
		}

		public Builder sysctls(Map<String, String> sysctls) {
			this.sysctls = sysctls;
			return Builder.this;
		}

		public Builder runtime(String runtime) {
			this.runtime = runtime;
			return Builder.this;
		}

		public Builder maskedPaths(List<String> maskedPaths) {
			this.maskedPaths = maskedPaths;
			return Builder.this;
		}

		public Builder addMaskedPaths(String maskedPaths) {
			this.maskedPaths.add(maskedPaths);
			return Builder.this;
		}

		public Builder readonlyPath(List<String> readonlyPath) {
			this.readonlyPath = readonlyPath;
			return Builder.this;
		}

		public Builder addReadonlyPath(String readonlyPath) {
			this.readonlyPath.add(readonlyPath);
			return Builder.this;
		}
		
		//------------------------
		
		public Builder cpus(float cpus) {
			return nanoCpus((long) (cpus * 1E9));
		}

		public HostConfig build() {

			return new HostConfig(this);
		}
	}
}