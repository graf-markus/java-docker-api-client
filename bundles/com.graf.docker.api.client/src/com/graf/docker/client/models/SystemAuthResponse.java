package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SystemAuthResponse {

	private String status;
	private String identityToken;

	public String getStatus() {
		return status;
	}

	public String getIdentityToken() {
		return identityToken;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
