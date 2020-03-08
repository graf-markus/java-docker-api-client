package com.graf.docker.client.models;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ContainerFileInfo {

	@SerializedName("name")
	private String name;
	@SerializedName("size")
	private long size;
	@SerializedName("mode")
	private long mode;
	@SerializedName("mtime")
	private Date mtime;
	@SerializedName("linkTarget")
	private String linkTarget;

	public String getName() {
		return name;
	}

	public long getSize() {
		return size;
	}

	public long getMode() {
		return mode;
	}

	public Date getMtime() {
		return mtime;
	}

	public String getLinkTarget() {
		return linkTarget;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
