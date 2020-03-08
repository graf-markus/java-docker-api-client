package com.graf.docker.client.models;

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

	private Mount(Builder builder) {
		this.target = builder.target;
		this.source = builder.source;
		this.type = builder.type;
		this.readOnly = builder.readOnly;
		this.consistency = builder.consistency;
		this.bindOptions = builder.bindOptions;
		this.volumeOptions = builder.volumeOptions;
		this.tmpfsOptions = builder.tmpfsOptions;
	}

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

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String target;
		private String source;
		private String type;
		private boolean readOnly;
		private String consistency;
		private BindOptions bindOptions;
		private VolumeOptions volumeOptions;
		private TmpfsOptions tmpfsOptions;

		public Builder() {
		}

		public Builder target(String target) {
			this.target = target;
			return Builder.this;
		}

		public Builder source(String source) {
			this.source = source;
			return Builder.this;
		}

		public Builder type(String type) {
			this.type = type;
			return Builder.this;
		}

		public Builder readOnly(boolean readOnly) {
			this.readOnly = readOnly;
			return Builder.this;
		}

		public Builder consistency(String consistency) {
			this.consistency = consistency;
			return Builder.this;
		}

		public Builder bindOptions(BindOptions bindOptions) {
			this.bindOptions = bindOptions;
			return Builder.this;
		}

		public Builder volumeOptions(VolumeOptions volumeOptions) {
			this.volumeOptions = volumeOptions;
			return Builder.this;
		}

		public Builder tmpfsOptions(TmpfsOptions tmpfsOptions) {
			this.tmpfsOptions = tmpfsOptions;
			return Builder.this;
		}

		public Mount build() {

			return new Mount(this);
		}
	}
}