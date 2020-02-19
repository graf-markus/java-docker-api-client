package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerUpdate {

	private List<String> warnings;

	private ContainerUpdate(Builder builder) {
		this.warnings = builder.warnings;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public static class Builder {

		private List<String> warnings = new ArrayList<String>();

		public Builder() {
		}

		Builder(List<String> warnings) {
			this.warnings = warnings;
		}

		public Builder warnings(List<String> warnings) {
			this.warnings = warnings;
			return Builder.this;
		}

		public Builder addWarnings(String warnings) {
			this.warnings.add(warnings);
			return Builder.this;
		}

		public ContainerUpdate build() {

			return new ContainerUpdate(this);
		}
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
