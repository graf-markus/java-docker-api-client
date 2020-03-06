package com.graf.docker.client.models;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ImageHistory {

	private String id;
	private int created;
	private String createdBy;
	private List<String> tags;
	private int size;
	private String comment;

	public String getId() {
		return id;
	}

	public int getCreated() {
		return created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public List<String> getTags() {
		return tags;
	}

	public int getSize() {
		return size;
	}

	public String getComment() {
		return comment;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

}
