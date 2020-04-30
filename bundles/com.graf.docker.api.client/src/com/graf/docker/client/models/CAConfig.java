package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class CAConfig {

	private long nodeCertExpiry;
	private List<ExternalCA> externalCAs;
	@SerializedName("SigningCACert")
	private String signingCaCert;
	@SerializedName("SigningCAKey")
	private String signingCaKey;
	private long forceRotate;

	public long getNodeCertExpiry() {
		return nodeCertExpiry;
	}

	public List<ExternalCA> getExternalCAs() {
		return externalCAs;
	}

	public String getSigningCaCert() {
		return signingCaCert;
	}

	public String getSigningCaKey() {
		return signingCaKey;
	}

	public long getForceRotate() {
		return forceRotate;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
