package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ListVolumesParam extends Param {

	protected ListVolumesParam(String name, String value) {
		super(name, value);
	}

	/**
	 * 
	 * @param dangling
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam dangling() {
		return dangling(true);
	}

	/**
	 * 
	 * @param dangling
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam dangling(boolean dangling) {
		return filter("dangling", String.valueOf(dangling));
	}

	/**
	 * 
	 * @param driver
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam driver(String driver) {
		return filter("driver", driver);
	}

	/**
	 * 
	 * @param name
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam name(String name) {
		return filter("name", name);
	}

	/**
	 * Show Volumes with a label value.
	 *
	 * @param label The label to filter on
	 * @param value The value of the label
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam label(String label, String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + ":" + value);
	}

	/**
	 * Show Volumes with a label.
	 *
	 * @param label The label to filter on
	 * @return ListVolumesParam
	 */
	public static ListVolumesParam label(String label) {
		return label(label, null);
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private static ListVolumesParam filter(String key, String value) {
		return new ListVolumesFilterParam(key, value);
	}
}

class ListVolumesFilterParam extends ListVolumesParam implements FilterParam {

	public ListVolumesFilterParam(String name, String value) {
		super(name, value);
	}
}