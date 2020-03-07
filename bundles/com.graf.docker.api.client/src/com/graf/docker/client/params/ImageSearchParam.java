package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ImageSearchParam extends Param {

	protected ImageSearchParam(String name, String value) {
		super(name, value);
	}

	private static ImageSearchParam create(final String name, final String value) {
		return new ImageSearchParam(name, value);
	}

	private static ImageSearchParam filter(final String key, final String value) {
		return new ImageSearchFilterParam(key, value);
	}

	/**
	 * Maximum number of results to return
	 * 
	 * @param limit
	 */
	public static ImageSearchParam withLimit(int limit) {
		return create("limit", String.valueOf(limit));
	}

	public static ImageSearchParam isAutomated(boolean automated) {
		return filter("is-automated", String.valueOf(automated));
	}
	
	public static ImageSearchParam isOfficial(boolean official) {
		return filter("is-official", String.valueOf(official));
	}
	
	public static ImageSearchParam stars(int starsCount) {
		return filter("stars", String.valueOf(starsCount));
	}
	
}

class ImageSearchFilterParam extends ImageSearchParam implements FilterParam {

	public ImageSearchFilterParam(String name, String value) {
		super(name, value);
	}
}