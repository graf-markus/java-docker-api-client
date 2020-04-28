package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class RemoveVolumesParam extends Param {

	protected RemoveVolumesParam(String name, String value) {
		super(name, value);
	}

	public static RemoveVolumesParam label(String label, String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}
	
	public static RemoveVolumesParam label(String label) {
		return label(label, null);
	}
	
	public static RemoveVolumesParam notLabel(String label, String value) {
		return filter("label", label + "!=" + value);
	}
	
	private static RemoveVolumesParam filter(String key, String value) {
		return new RemoveVolumesFilterParam(key, value);
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}
}

class RemoveVolumesFilterParam extends RemoveVolumesParam implements FilterParam {

	public RemoveVolumesFilterParam(String name, String value) {
		super(name, value);
	}
}