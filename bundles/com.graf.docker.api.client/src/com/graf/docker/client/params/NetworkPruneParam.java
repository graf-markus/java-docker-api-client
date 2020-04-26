package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class NetworkPruneParam extends Param {

	protected NetworkPruneParam(String name, String value) {
		super(name, value);
	}

	/**
	 * 
	 * @param timestamp
	 * @return NetworkPruneParam
	 */
	public static NetworkPruneParam until(String timestamp) {
		return filter("until", timestamp);
	}

	/**
	 * 
	 * @param label
	 * @param value
	 * @return NetworkPruneParam
	 */
	public static NetworkPruneParam label(String label, String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}

	/**
	 * 
	 * @param label
	 * @return NetworkPruneParam
	 */
	public static NetworkPruneParam label(String label) {
		return label(label, null);
	}

	/**
	 * 
	 * @param label
	 * @param value
	 * @return NetworkPruneParam
	 */
	public static NetworkPruneParam notLabel(String label, String value) {
		return filter("label", label + "!=" + value);
	}

	private static NetworkPruneParam filter(String key, String value) {
		return new NetworkPruneFilterParam(key, value);
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}
}

class NetworkPruneFilterParam extends NetworkPruneParam implements FilterParam {
	public NetworkPruneFilterParam(String name, String value) {
		super(name, value);
	}
}