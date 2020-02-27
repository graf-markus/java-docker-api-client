package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ClearCacheParam extends Param {

	public ClearCacheParam(String name, String value) {
		super(name, value);
	}
	
	public static ClearCacheParam all() {
		return all(true);
	}

	public static ClearCacheParam all(boolean all) {
		return create("all", String.valueOf(all));
	}
	
	public static ClearCacheParam inUse() {
		return inUse(true);
	}

	public static ClearCacheParam inUse(boolean inuse) {
		return create("inuse", String.valueOf(inuse));
	}
	
	public static ClearCacheParam shared() {
		return shared(true);
	}

	public static ClearCacheParam shared(boolean shared) {
		return create("shared", String.valueOf(shared));
	}
	
	public static ClearCacheParam isPrivate() {
		return isPrivate(true);
	}

	public static ClearCacheParam isPrivate(boolean isPrivate) {
		return create("private", String.valueOf(isPrivate));
	}
	
	public static ClearCacheParam keepStorage(int storage) {
		return create("keep-storage", String.valueOf(storage));
	}
	
	public static ClearCacheParam withId(String id) {
		return filter("id", String.valueOf(id));
	}
	
	public static ClearCacheParam withParent(String id) {
		return filter("parent", String.valueOf(id));
	}
	
	public static ClearCacheParam withType(String type) {
		return filter("type", type);
	}
	
	public static ClearCacheParam withDescription(String des) {
		return filter("description", des);
	}
	
	
	
	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private static ClearCacheParam filter(String key, String value) {
		return new ClearCacheFilterParam(key, value);
	}

	private static ClearCacheParam create(String name, String value) {
		return new ClearCacheParam(name, value);
	}
}

class ClearCacheFilterParam extends ClearCacheParam implements FilterParam {

	public ClearCacheFilterParam(String name, String value) {
		super(name, value);
	}
}
