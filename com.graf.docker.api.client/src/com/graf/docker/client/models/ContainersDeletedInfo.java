package com.graf.docker.client.models;

public class ContainersDeletedInfo {

	private String[] containersDeleted;
	private int spaceReclaimed;

	public String[] getContainersDeleted() {
		return containersDeleted;
	}

	public int getSpaceReclaimed() {
		return spaceReclaimed;
	}
}
