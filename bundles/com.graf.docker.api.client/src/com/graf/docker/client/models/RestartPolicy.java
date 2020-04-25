package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class RestartPolicy {

	private String name;
	@SerializedName("MaximumRetryCount")
	private int maxRetryCount;

	private RestartPolicy(Builder builder) {
		this.name = builder.name;
		this.maxRetryCount = builder.maxRetryCount;
	}

	public String getName() {
		return name;
	}

	public int getMaxRetryCount() {
		return maxRetryCount;
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

		private String name;
		private int maxRetryCount;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder maxRetryCount(int maxREtryCount) {
			this.maxRetryCount = maxREtryCount;
			return Builder.this;
		}

		public RestartPolicy build() {

			return new RestartPolicy(this);
		}
	}

	public static class RestartPolicyName {
		public static String RESTART_POLICY_EMPTY = "";
		public static String RESTART_POLICY_ALWAYS = "always";
		public static String RESTART_POLICY_UNLESS_STOPPED = "unless-stopped";
		public static String RESTART_POLICY_ON_FAILURE = "on-failure";
	}
}