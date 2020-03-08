package com.graf.docker.client.models;

public class ContainerChangeResponseItem {
	
	public static final int MODIFIED = 0;
	public static final int ADDED = 1;
	public static final int DELETED = 2;
	
	private String path;
	private byte kind;

	public String getPath() {
		return path;
	}

	public byte getKind() {
		return kind;
	}
}
