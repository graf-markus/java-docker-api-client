package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IndexInfo {

	private String name;
	private List<String> mirrors;
	private boolean secure;
	private boolean official;

	public String getName() {
		return name;
	}

	public List<String> getMirrors() {
		return mirrors;
	}

	public boolean isSecure() {
		return secure;
	}

	public boolean isOfficial() {
		return official;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
