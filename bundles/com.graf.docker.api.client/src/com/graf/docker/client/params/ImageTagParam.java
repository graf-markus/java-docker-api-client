package com.graf.docker.client.params;

public class ImageTagParam extends Param {

	protected ImageTagParam(String name, String value) {
		super(name, value);
	}

	private static ImageTagParam create(String name, String value) {
		return new ImageTagParam(name, value);
	}

	/**
	 * The repository to tag in. For example, someuser/someimage.
	 * 
	 * @param repo
	 * @return ImageTagParam
	 */
	public static ImageTagParam repo(String repo) {
		return create("repo", repo);
	}

	/**
	 * The name of the new tag.
	 * 
	 * @param tag
	 * @return ImageTagParam
	 */
	public static ImageTagParam newTag(String tag) {
		return create("tag", tag);
	}
}
