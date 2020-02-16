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

	private ContainerFileInfo(Builder builder) {
		this.name = builder.name;
		this.size = builder.size;
		this.mode = builder.mode;
		this.mtime = builder.mtime;
		this.linkTarget = builder.linkTarget;
	}

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

	public static class Builder {

		private String name;
		private long size;
		private long mode;
		private Date mtime;
		private String linkTarget;

		public Builder() {
		}

		Builder(String name, long size, long mode, Date mtime, String linkTarget) {
			this.name = name;
			this.size = size;
			this.mode = mode;
			this.mtime = mtime;
			this.linkTarget = linkTarget;
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder size(long size) {
			this.size = size;
			return Builder.this;
		}

		public Builder mode(long mode) {
			this.mode = mode;
			return Builder.this;
		}

		public Builder mtime(Date mtime) {
			this.mtime = mtime;
			return Builder.this;
		}

		public Builder linkTarget(String linkTarget) {
			this.linkTarget = linkTarget;
			return Builder.this;
		}

		public ContainerFileInfo build() {

			return new ContainerFileInfo(this);
		}
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
