package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ulimit {

	private String name;
	private long soft;
	private long hard;

	public String getName() {
		return name;
	}

	public long getSoft() {
		return soft;
	}

	public long getHard() {
		return hard;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private String name;
		private long soft;
		private long hard;

		public Builder() {
		}

		Builder(String name, long soft, long hard) {
			this.name = name;
			this.soft = soft;
			this.hard = hard;
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder soft(long soft) {
			this.soft = soft;
			return Builder.this;
		}

		public Builder hard(long hard) {
			this.hard = hard;
			return Builder.this;
		}

		public Ulimit build() {

			return new Ulimit(this);
		}
	}

	private Ulimit(Builder builder) {
		this.name = builder.name;
		this.soft = builder.soft;
		this.hard = builder.hard;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
