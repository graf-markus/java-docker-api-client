package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ClearCacheParam extends Param {

	protected ClearCacheParam(String name, String value) {
		super(name, value);
	}

	/**
	 * Remove all types of build cache.
	 * 
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam all() {
		return all(true);
	}

	/**
	 * Remove all types of build cache.
	 * 
	 * @param all
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam all(boolean all) {
		return create("all", String.valueOf(all));
	}

	/**
	 * 
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam inUse() {
		return inUse(true);
	}

	/**
	 * 
	 * @param inuse
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam inUse(boolean inuse) {
		return create("inuse", String.valueOf(inuse));
	}

	/**
	 * 
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam shared() {
		return shared(true);
	}

	/**
	 * 
	 * @param shared
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam shared(boolean shared) {
		return create("shared", String.valueOf(shared));
	}

	/**
	 * 
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam isPrivate() {
		return isPrivate(true);
	}

	/**
	 * 
	 * @param isPrivate
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam isPrivate(boolean isPrivate) {
		return create("private", String.valueOf(isPrivate));
	}

	/**
	 * 
	 * @param storage
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam keepStorage(int storage) {
		return create("keep-storage", String.valueOf(storage));
	}

	/**
	 * 
	 * @param id
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam id(String id) {
		return filter("id", String.valueOf(id));
	}

	/**
	 * 
	 * @param id
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam parent(String id) {
		return filter("parent", String.valueOf(id));
	}

	/**
	 * 
	 * @param type
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam type(String type) {
		return filter("type", type);
	}

	/**
	 * 
	 * @param des
	 * @return ClearCacheParam
	 */
	public static ClearCacheParam description(String des) {
		return filter("description", des);
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
