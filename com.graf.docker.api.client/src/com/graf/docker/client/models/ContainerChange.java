package com.graf.docker.client.models;

public class ContainerChange {
	
	public static final int MODIFIED = 0;
	public static final int ADDED = 1;
	public static final int DELETED = 2;
	
	private String path;
	private int kind;

	public String getPath() {
		return path;
	}

	public int getKind() {
		return kind;
	}
}
