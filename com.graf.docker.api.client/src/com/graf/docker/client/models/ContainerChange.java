package com.graf.docker.client.models;

public class ContainerChange {

	private String path;
	private ChangeKind kind;

	public String getPath() {
		return path;
	}

	public ChangeKind getKind() {
		return kind;
	}

	public enum ChangeKind {
		MODIFIED(0), ADDED(1), DELETED(2);

		ChangeKind(int i) {

		}
	}
}
