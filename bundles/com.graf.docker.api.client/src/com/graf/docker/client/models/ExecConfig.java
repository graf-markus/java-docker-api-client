package com.graf.docker.client.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExecConfig {

	private boolean attachStdin;
	private boolean attachStdout;
	private boolean attachStderr;
	private String detachKeys;
	private boolean tty;
	private List<String> env;
	private List<String> cmd;
	private boolean privileged;
	private String user;
	private String workingDir;

	private ExecConfig(Builder builder) {
		this.attachStdin = builder.attachStdin;
		this.attachStdout = builder.attachStdout;
		this.attachStderr = builder.attachStderr;
		this.detachKeys = builder.detachKeys;
		this.tty = builder.tty;
		this.env = builder.env;
		this.cmd = builder.cmd;
		this.privileged = builder.privileged;
		this.user = builder.user;
		this.workingDir = builder.workingDir;
	}

	public boolean isAttachStdin() {
		return attachStdin;
	}

	public boolean isAttachStdout() {
		return attachStdout;
	}

	public boolean isAttachStderr() {
		return attachStderr;
	}

	public String getDetachKeys() {
		return detachKeys;
	}

	public boolean isTty() {
		return tty;
	}

	public List<String> getEnv() {
		return env;
	}

	public List<String> getCmd() {
		return cmd;
	}

	public boolean isPrivileged() {
		return privileged;
	}

	public String getUser() {
		return user;
	}

	public String getWorkingDir() {
		return workingDir;
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

		private boolean attachStdin;
		private boolean attachStdout = true;
		private boolean attachStderr;
		private String detachKeys;
		private boolean tty;
		private List<String> env;
		private List<String> cmd;
		private boolean privileged;
		private String user;
		private String workingDir;

		public Builder() {
		}

		public Builder attachStdin(boolean attachStdin) {
			this.attachStdin = attachStdin;
			return Builder.this;
		}

		public Builder attachStdout(boolean attachStdout) {
			this.attachStdout = attachStdout;
			return Builder.this;
		}

		public Builder attachStderr(boolean attachstderr) {
			this.attachStderr = attachstderr;
			return Builder.this;
		}

		public Builder detachKeys(String detachKeys) {
			this.detachKeys = detachKeys;
			return Builder.this;
		}

		public Builder tty(boolean tty) {
			this.tty = tty;
			return Builder.this;
		}

		public Builder env(List<String> env) {
			if (this.env == null) {
				this.env = new ArrayList<>();
			}
			this.env = env;
			return Builder.this;
		}

		public Builder env(String... env) {
			if (this.env == null) {
				this.env = new ArrayList<>();
			}
			this.env.addAll(Arrays.asList(env));
			return Builder.this;
		}

		public Builder cmd(List<String> cmd) {
			if (this.cmd == null) {
				this.cmd = new ArrayList<>();
			}
			this.cmd = cmd;
			return Builder.this;
		}

		public Builder cmd(String... cmd) {
			if (this.cmd == null) {
				this.cmd = new ArrayList<>();
			}
			this.cmd.addAll(Arrays.asList(cmd));
			return Builder.this;
		}

		public Builder privileged(boolean privileged) {
			this.privileged = privileged;
			return Builder.this;
		}

		public Builder user(String user) {
			this.user = user;
			return Builder.this;
		}

		public Builder workingDir(String workingDir) {
			this.workingDir = workingDir;
			return Builder.this;
		}

		public ExecConfig build() {

			return new ExecConfig(this);
		}
	}
}
