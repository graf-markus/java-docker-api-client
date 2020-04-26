package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ListImagesParam extends Param {

	protected ListImagesParam(String name, String value) {
		super(name, value);
	}

	/**
	 * Return all Images.
	 * 
	 * @return ListImagesParam
	 */
	public static ListImagesParam all() {
		return all(true);
	}

	/**
	 * Return all Images.
	 * 
	 * @param all
	 * @return ListImagesParam
	 */
	public static ListImagesParam all(boolean all) {
		return create("all", String.valueOf(all));
	}

	/**
	 * 
	 * @return ListImagesParam
	 */
	public static ListImagesParam showDigests() {
		return showDigests(true);
	}

	/**
	 * 
	 * @param show
	 * @return ListImagesParam
	 */
	public static ListImagesParam showDigests(boolean show) {
		return create("digests", String.valueOf(show));
	}

	/**
	 * Return all Images created before.
	 * 
	 * @param imageId
	 * @return ListImagesParam
	 */
	public static ListImagesParam imageCreatedBefore(String imageId) {
		return filter("before", imageId);
	}

	/**
	 * 
	 * @param dangling
	 * @return ListImagesParam
	 */
	public static ListImagesParam dangling() {
		return dangling(true);
	}

	/**
	 * 
	 * @param dangling
	 * @return ListImagesParam
	 */
	public static ListImagesParam dangling(boolean dangling) {
		return filter("dangling", String.valueOf(dangling));
	}

	/**
	 * 
	 * @param label
	 * @param value
	 * @return ListImagesParam
	 */
	public static ListImagesParam label(final String label, final String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}

	/**
	 * 
	 * @param label
	 * @return ListImagesParam
	 */
	public static ListImagesParam label(final String label) {
		return label(label, null);
	}

	/**
	 * 
	 * @param imageName
	 * @return ListImagesParam
	 */
	public static ListImagesParam reference(String imageName) {
		return filter("reference", imageName);
	}

	/**
	 * 
	 * @param imageId
	 * @return ListImagesParam
	 */
	public static ListImagesParam imageCreatedSince(String imageId) {
		return filter("since", imageId);
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private static ListImagesParam filter(String key, String value) {
		return new ListImagesFilterParam(key, value);
	}

	private static ListImagesParam create(String name, String value) {
		return new ListImagesParam(name, value);
	}
}

class ListImagesFilterParam extends ListImagesParam implements FilterParam {

	public ListImagesFilterParam(String name, String value) {
		super(name, value);
	}
}
