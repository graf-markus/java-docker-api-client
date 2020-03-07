package com.graf.docker.client.params;

public class ImageDeleteParam extends Param {

	private ImageDeleteParam(String name, String value) {
		super(name, value);
	}

	private static ImageDeleteParam create(String name, String value) {
		return new ImageDeleteParam(name, value);
	}

	/**
	 * Remove the image even if it is being used by stopped containers or has other
	 * tags
	 * 
	 * @return
	 */
	public static ImageDeleteParam force() {
		return force(true);
	}

	/**
	 * Remove the image even if it is being used by stopped containers or has other
	 * tags
	 * 
	 * @param force
	 * @return
	 */
	public static ImageDeleteParam force(boolean force) {
		return create("force", String.valueOf(force));
	}

	/**
	 * Do not delete untagged parent images
	 * 
	 * @return
	 */
	public static ImageDeleteParam noprune() {
		return noprune(true);
	}

	/**
	 * Do not delete untagged parent images
	 * 
	 * @param noPrune
	 * @return
	 */
	public static ImageDeleteParam noprune(boolean noPrune) {
		return create("noprune", String.valueOf(noPrune));
	}
}
