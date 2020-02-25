package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ListImagesParam extends Param {

	public ListImagesParam(String name, String value) {
		super(name, value);
	}

	public static ListImagesParam allImages() {
		return allImages(true);
	}

	public static ListImagesParam allImages(boolean all) {
		return create("all", String.valueOf(all));
	}

	public static ListImagesParam showDigests() {
		return showDigests(true);
	}

	public static ListImagesParam showDigests(boolean show) {
		return create("digests", String.valueOf(show));
	}

	public static ListImagesParam imageCreatedBefore(String imageId) {
		return filter("before", imageId);
	}

	public static ListImagesParam withDangling(boolean dangling) {
		return filter("dangling", String.valueOf(dangling));
	}

	public static ListImagesParam withLabel(final String label, final String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}

	public static ListImagesParam withLabel(final String label) {
		return withLabel(label, null);
	}

	public static ListImagesParam withReference(String imageName) {
		return filter("reference", imageName);
	}
	
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
