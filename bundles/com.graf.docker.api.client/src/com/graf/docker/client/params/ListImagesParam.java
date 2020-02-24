package com.graf.docker.client.params;

public class ListImagesParam extends Param {

	public ListImagesParam(String name, String value) {
		super(name, value);
	}
	
	public static ListImagesParam allImages() {
		return allImages(true);
	}
	
	public static ListImagesParam allImages(boolean all) {
		return new ListImagesParam("all", String.valueOf(all));
	}
	
	public static ListImagesParam showDigests() {
		return showDigests(true);
	}
	
	public static ListImagesParam showDigests(boolean show) {
		return new ListImagesParam("digests", String.valueOf(show));
	}
}
