package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerLog {

	private List<String> stdout;
	private List<String> stderr;

	public List<String> getStdoutLogs() {
		return stdout;
	}

	public List<String> getStderrLogs() {
		return stderr;
	}

	private ContainerLog(Builder builder) {
		this.stdout = builder.stdout;
		this.stderr = builder.stderr;
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

		private List<String> stdout = new ArrayList<>();
		private List<String> stderr = new ArrayList<>();

		public Builder() {
		}

		Builder(List<String> stdout, List<String> stderr) {
			this.stdout = stdout;
			this.stderr = stderr;
		}

		public Builder stdout(List<String> stdout) {
			if (this.stdout == null) {
				this.stdout = new ArrayList<>();
			}
			this.stdout.addAll(stdout);
			return Builder.this;
		}

		public Builder stdout(String... stdout) {
			if (this.stdout == null) {
				this.stdout = new ArrayList<>();
			}
			this.stdout.addAll(Arrays.asList(stdout));
			return Builder.this;
		}

		public Builder stderr(List<String> stderr) {
			if (this.stderr == null) {
				this.stderr = new ArrayList<>();
			}
			this.stderr.addAll(stderr);
			return Builder.this;
		}

		public Builder stderr(String... stderr) {
			if (this.stderr == null) {
				this.stderr = new ArrayList<>();
			}
			this.stderr.addAll(Arrays.asList(stderr));
			return Builder.this;
		}

		public ContainerLog build() {

			return new ContainerLog(this);
		}
	}

}
