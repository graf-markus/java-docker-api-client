package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class HostConfig {

	private int cpuShares;
	private long memory;
	private String cgroupParent;
	private BlkioWeightDevice[] blkioWeightDevice;
	private ThrottleDevice[] blkioDeviceReadBps;
	private ThrottleDevice[] blkioDeviceWriteBps;
	private ThrottleDevice[] blkioDeviceReadIOps;
	private ThrottleDevice[] blkioDeviceWriteIOps;
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
	private Ulimit[] ulimits;
	@SerializedName("IOMaximumBandwidth")
	private long ioMaximumBandwidth;
	private List<String> binds;
	@SerializedName("ContainerIDFile")
	private String containerIdFile;
	private LogConfig logConfig;
	private String networkMode;
	private PortMap portBindings;
	
	private int blkioWeight;
	private LxcConfParameter[] lxcConf;
	private boolean privileged;
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
	private String[] securityOpt;
	private RestartPolicy restartPolicy;
	private String ipcMode;
	private String pidMode;
	private long shmSize;
	private int oomScoreAdj;
	private boolean autoRemove;
	private Map<String, String> tmpfs;
	private boolean readonlyRootfs;
	private String runtime;
	private Map<String, String> storageOpt;

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}