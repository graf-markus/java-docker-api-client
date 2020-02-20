package com.graf.docker.client.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContainerMount {

	private String type;
	private String name;
	private String source;
	private String destination;
	private String driver;
	private String mode;
	private boolean rw;
	private String propagation;

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getDriver() {
		return driver;
	}

	public String getMode() {
		return mode;
	}

	public boolean isRw() {
		return rw;
	}

	public String getPropagation() {
		return propagation;
	}
	
	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
}
