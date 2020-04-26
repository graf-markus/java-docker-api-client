package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ImageSearchParam extends Param {

	protected ImageSearchParam(String name, String value) {
		super(name, value);
	}

	private static ImageSearchParam create(String name, String value) {
		return new ImageSearchParam(name, value);
	}

	private static ImageSearchParam filter(String key, String value) {
		return new ImageSearchFilterParam(key, value);
	}

	/**
	 * Maximum number of results to return
	 * 
	 * @param limit
	 * @retrun ImageSearchParam
	 */
	public static ImageSearchParam limit(int limit) {
		return create("limit", String.valueOf(limit));
	}

	/**
	 * 
	 * @param automated
	 * @return ImageSearchParam
	 */
	public static ImageSearchParam isAutomated(boolean automated) {
		return filter("is-automated", String.valueOf(automated));
	}

	/**
	 * 
	 * @param automated
	 * @return ImageSearchParam
	 */
	public static ImageSearchParam isAutomated() {
		return isAutomated(true);
	}

	/**
	 * Only return official images
	 * 
	 * @param official
	 * @return ImageSearchParam
	 */
	public static ImageSearchParam isOfficial(boolean official) {
		return filter("is-official", String.valueOf(official));
	}

	/**
	 * Only return official images
	 * 
	 * @param official
	 * @return ImageSearchParam
	 */
	public static ImageSearchParam isOfficial() {
		return isOfficial(true);
	}

	/**
	 * Only return images with given stars
	 * 
	 * @param starsCount
	 * @return ImageSearchParam
	 */
	public static ImageSearchParam stars(int starsCount) {
		return filter("stars", String.valueOf(starsCount));
	}

}

class ImageSearchFilterParam extends ImageSearchParam implements FilterParam {

	public ImageSearchFilterParam(String name, String value) {
		super(name, value);
	}
}