package com.graf.docker.client.params;

public class CreateImageParam extends Param {

	public CreateImageParam(String name, String value) {
		super(name, value);
	}

	private static CreateImageParam create(String name, String value) {
		return new CreateImageParam(name, value);
	}

	/**
	 * Name of the image to pull. The name may include a tag or digest.
	 * 
	 * @param image
	 * @return
	 */
	public static CreateImageParam fromImage(String image) {
		return create("fromImage", image);
	}

	/**
	 * Source to import.
	 * 
	 * @param url
	 * @return
	 */
	public static CreateImageParam fromSrc(String url) {
		return create("fromSrc", url);
	}

	/**
	 * Repository name given to an image when it is imported.
	 * 
	 * @param repoName
	 * @return
	 */
	public static CreateImageParam withRepo(String repoName) {
		return create("repo", repoName);
	}

	/**
	 * Tag or digest. If empty when pulling an image, this causes all tags for the
	 * given image to be pulled.
	 * 
	 * 
	 * @param tag
	 * @return
	 */
	public static CreateImageParam withTag(String tag) {
		return create("tag", tag);
	}

	/**
	 * Set commit message for imported image.
	 * 
	 * 
	 * @param message
	 * @return
	 */
	public static CreateImageParam withMessage(String message) {
		return create("message", message);
	}

	/**
	 * Platform in the format os[/arch[/variant]]
	 * 
	 * @param platform
	 * @return
	 */
	public static CreateImageParam withPlatform(String platform) {
		return create("platform", platform);
	}
}
