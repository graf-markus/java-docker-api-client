package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RestartPolicy {

	private String name;
	private int maxRetryCount;

	private RestartPolicy(Builder builder) {
		this.name = builder.name;
		this.maxRetryCount = builder.maxREtryCount;
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
		private int maxREtryCount;

		public Builder() {
		}

		Builder(String name, int maxREtryCount) {
			this.name = name;
			this.maxREtryCount = maxREtryCount;
		}

		public Builder name(String name) {
			this.name = name;
			return Builder.this;
		}

		public Builder maxREtryCount(int maxREtryCount) {
			this.maxREtryCount = maxREtryCount;
			return Builder.this;
		}

		public RestartPolicy build() {

			return new RestartPolicy(this);
		}
	}
}