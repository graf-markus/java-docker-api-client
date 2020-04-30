package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class AuthConfig {

	@SerializedName("username")
	private String username;
	@SerializedName("password")
	private String password;
	@SerializedName("email")
	private String email;
	@SerializedName("serveraddress")
	private String serveraddress;

	private AuthConfig(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.email = builder.email;
		this.serveraddress = builder.serveraddress;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getServeraddress() {
		return serveraddress;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static class Builder {

		private String username;
		private String password;
		private String email;
		private String serveraddress;

		public Builder() {
		}

		public Builder username(String username) {
			this.username = username;
			return Builder.this;
		}

		public Builder password(String password) {
			this.password = password;
			return Builder.this;
		}

		public Builder email(String email) {
			this.email = email;
			return Builder.this;
		}

		public Builder serveraddress(String serveraddress) {
			this.serveraddress = serveraddress;
			return Builder.this;
		}

		public AuthConfig build() {

			return new AuthConfig(this);
		}
	}

}
