package com.graf.docker.client.models;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ExternalCA {

	private String protocol;
	private String URL;
	private Map<String, String> options;
	@SerializedName("CACert")
	private String caCert;

	public String getProtocol() {
		return protocol;
	}

	public String getURL() {
		return URL;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public String getCaCert() {
		return caCert;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
