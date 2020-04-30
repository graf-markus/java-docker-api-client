package com.graf.docker.client.models;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegistryServiceConfig {

	private List<String> allowNondistributableArtifactsCIDRs;
	private List<String> allowNondistributableArtifactsHostnames;
	private List<String> insecureRegistryCIDRs;
	private Map<String, IndexInfo> indexConfigs;
	private List<String> mirrors;

	public List<String> getAllowNondistributableArtifactsCIDRs() {
		return allowNondistributableArtifactsCIDRs;
	}

	public List<String> getAllowNondistributableArtifactsHostnames() {
		return allowNondistributableArtifactsHostnames;
	}

	public List<String> getInsecureRegistryCIDRs() {
		return insecureRegistryCIDRs;
	}

	public Map<String, IndexInfo> getIndexConfigs() {
		return indexConfigs;
	}

	public List<String> getMirrors() {
		return mirrors;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
