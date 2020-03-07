package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Mount {

	private String target;
	private String source;
	private String type;
	private boolean readOnly;
	private String consistency;
	private BindOptions bindOptions;
	private VolumeOptions volumeOptions;
	private TmpfsOptions tmpfsOptions;

	public String getTarget() {
		return target;
	}

	public String getSource() {
		return source;
	}

	public String getType() {
		return type;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public String getConsistency() {
		return consistency;
	}

	public BindOptions getBindOptions() {
		return bindOptions;
	}

	public VolumeOptions getVolumeOptions() {
		return volumeOptions;
	}

	public TmpfsOptions getTmpfsOptions() {
		return tmpfsOptions;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}

class BindOptions {

	private String propagation;
	private boolean nonRecursive;

	public String getPropagation() {
		return propagation;
	}

	public boolean isNonRecursive() {
		return nonRecursive;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}

class VolumeOptions {

	private boolean noCopy;
	private Map<String, String> labels;
	private DriverConfig driverConfig;

	public boolean isNoCopy() {
		return noCopy;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public DriverConfig getDriverConfig() {
		return driverConfig;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}

class TmpfsOptions {

	private int sizeBytes;
	private int mode;

	public int getSizeBytes() {
		return sizeBytes;
	}

	public int getMode() {
		return mode;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}

class DriverConfig {
	private String name;
	private Map<String, String> options;

	public String getName() {
		return name;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
