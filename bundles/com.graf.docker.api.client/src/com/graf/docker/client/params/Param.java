package com.graf.docker.client.params;

public class Param {
	private final String name;
	private final String value;

	public Param(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Parameter name.
	 *
	 * @return name of parameter
	 */
	public String name() {
		return name;
	}

	/**
	 * Parameter value.
	 *
	 * @return value of parameter
	 */
	public String value() {
		return value;
	}
}