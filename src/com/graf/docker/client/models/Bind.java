package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Bind {

	private String to;
	private String from;
	private boolean readOnly;
	private boolean noCopy;
	private boolean selinuxLabeling;

	public String getTo() {
		return to;
	}

	public String getFrom() {
		return from;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public boolean isNoCopy() {
		return noCopy;
	}

	public boolean isSelinuxLabeling() {
		return selinuxLabeling;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {

		private String to;
		private String from;
		private boolean readOnly;
		private boolean noCopy;
		private boolean selinuxLabeling;

		public Builder() {
		}

		Builder(String to, String from, boolean readOnly, boolean noCopy, boolean selinuxLabeling) {
			this.to = to;
			this.from = from;
			this.readOnly = readOnly;
			this.noCopy = noCopy;
			this.selinuxLabeling = selinuxLabeling;
		}

		public Builder to(String to) {
			this.to = to;
			return Builder.this;
		}

		public Builder from(String from) {
			this.from = from;
			return Builder.this;
		}

		public Builder readOnly(boolean readOnly) {
			this.readOnly = readOnly;
			return Builder.this;
		}

		public Builder noCopy(boolean noCopy) {
			this.noCopy = noCopy;
			return Builder.this;
		}

		public Builder selinuxLabeling(boolean selinuxLabeling) {
			this.selinuxLabeling = selinuxLabeling;
			return Builder.this;
		}

		public Bind build() {

			return new Bind(this);
		}
	}

	private Bind(Builder builder) {
		this.to = builder.to;
		this.from = builder.from;
		this.readOnly = builder.readOnly;
		this.noCopy = builder.noCopy;
		this.selinuxLabeling = builder.selinuxLabeling;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
