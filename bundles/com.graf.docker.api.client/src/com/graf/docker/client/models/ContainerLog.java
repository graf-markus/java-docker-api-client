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

		private List<String> stdout = new ArrayList<String>();
		private List<String> stderr = new ArrayList<String>();

		public Builder() {
		}

		Builder(List<String> stdout, List<String> stderr) {
			this.stdout = stdout;
			this.stderr = stderr;
		}

		public Builder stdout(List<String> stdout) {
			this.stdout.addAll(stdout);
			return Builder.this;
		}

		public Builder stdout(String stdout) {
			this.stdout.add(stdout);
			return Builder.this;
		}

		public Builder stdout(String... stdout) {
			this.stdout.addAll(Arrays.asList(stdout));
			return Builder.this;
		}

		public Builder stderr(List<String> stderr) {
			this.stderr.addAll(stderr);
			return Builder.this;
		}

		public Builder stderr(String stderr) {
			this.stderr.add(stderr);
			return Builder.this;
		}

		public Builder stderr(String... stderr) {
			this.stderr.addAll(Arrays.asList(stderr));
			return Builder.this;
		}

		public ContainerLog build() {

			return new ContainerLog(this);
		}
	}

}
