package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExecStartConfig {

	private boolean detach;
	private boolean tty;

	public boolean isDetach() {
		return detach;
	}

	public boolean isTty() {
		return tty;
	}

	private ExecStartConfig(Builder builder) {
		this.detach = builder.detach;
		this.tty = builder.tty;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private boolean detach;
		private boolean tty;

		public Builder() {
		}

		public Builder detach(boolean detach) {
			this.detach = detach;
			return Builder.this;
		}

		public Builder tty(boolean tty) {
			this.tty = tty;
			return Builder.this;
		}

		public ExecStartConfig build() {

			return new ExecStartConfig(this);
		}
	}
}
