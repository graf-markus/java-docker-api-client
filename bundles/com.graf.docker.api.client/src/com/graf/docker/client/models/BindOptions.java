package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BindOptions {

	private String propagation;
	private boolean nonRecursive;

	private BindOptions(Builder builder) {
		this.propagation = builder.propagation;
		this.nonRecursive = builder.nonRecursive;
	}

	public String getPropagation() {
		return propagation;
	}

	public boolean isNonRecursive() {
		return nonRecursive;
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

		private String propagation;
		private boolean nonRecursive;

		public Builder() {
		}

		public Builder propagation(String propagation) {
			this.propagation = propagation;
			return Builder.this;
		}

		public Builder nonRecursive(boolean nonRecursive) {
			this.nonRecursive = nonRecursive;
			return Builder.this;
		}

		public BindOptions build() {

			return new BindOptions(this);
		}
	}
}
