package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TmpfsOptions {

	private int sizeBytes;
	private int mode;

	private TmpfsOptions(Builder builder) {
		this.sizeBytes = builder.sizeBytes;
		this.mode = builder.mode;
	}

	public int getSizeBytes() {
		return sizeBytes;
	}

	public int getMode() {
		return mode;
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

		private int sizeBytes;
		private int mode;

		public Builder() {
		}

		public Builder sizeBytes(int sizeBytes) {
			this.sizeBytes = sizeBytes;
			return Builder.this;
		}

		public Builder mode(int mode) {
			this.mode = mode;
			return Builder.this;
		}

		public TmpfsOptions build() {
			return new TmpfsOptions(this);
		}
	}
}
