package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ImageSearchResponseItem {

	@SerializedName("description")
	private String description;
	@SerializedName("is_official")
	private boolean is_official;
	@SerializedName("is_automated")
	private boolean is_automated;
	@SerializedName("name")
	private String name;
	@SerializedName("start_count")
	private int start_count;

	public String getDescription() {
		return description;
	}

	public boolean isOfficial() {
		return is_official;
	}

	public boolean isAutomated() {
		return is_automated;
	}

	public String getName() {
		return name;
	}

	public int getStart_count() {
		return start_count;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
