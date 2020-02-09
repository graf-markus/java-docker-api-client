package com.graf.docker.client.params;

import java.util.Objects;

public abstract class Param {
	private final String name;
	private final String value;

	Param(String name, String value) {
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

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Param that = (Param) obj;

		return Objects.equals(name, that.name) && Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}
}