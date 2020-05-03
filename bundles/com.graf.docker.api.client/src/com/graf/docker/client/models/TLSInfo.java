package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TLSInfo {

	private String trustRoot;
	private String certIssuerSubject;
	private String certIssuerPublicKey;

	public String getTrustRoot() {
		return trustRoot;
	}

	public String getCertIssuerSubject() {
		return certIssuerSubject;
	}

	public String getCertIssuerPublicKey() {
		return certIssuerPublicKey;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
