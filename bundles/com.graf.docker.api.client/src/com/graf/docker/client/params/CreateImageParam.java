package com.graf.docker.client.params;

public class CreateImageParam extends Param {

	protected CreateImageParam(String name, String value) {
		super(name, value);
	}

	private static CreateImageParam create(String name, String value) {
		return new CreateImageParam(name, value);
	}

	/**
	 * Name of the image to pull. The name may include a tag or digest.
	 * 
	 * @param image
	 * @return CreateImageParam
	 */
	public static CreateImageParam fromImage(String image) {
		return create("fromImage", image);
	}

	/**
	 * Source to import.
	 * 
	 * @param url
	 * @return CreateImageParam
	 */
	public static CreateImageParam fromSrc(String url) {
		return create("fromSrc", url);
	}

	/**
	 * Repository name given to an image when it is imported.
	 * 
	 * @param repoName
	 * @return CreateImageParam
	 */
	public static CreateImageParam repo(String repoName) {
		return create("repo", repoName);
	}

	/**
	 * Tag or digest. If empty when pulling an image, this causes all tags for the
	 * given image to be pulled.
	 * 
	 * 
	 * @param tag
	 * @return CreateImageParam
	 */
	public static CreateImageParam tag(String tag) {
		return create("tag", tag);
	}

	/**
	 * Set commit message for imported image.
	 * 
	 * 
	 * @param message
	 * @return CreateImageParam
	 */
	public static CreateImageParam message(String message) {
		return create("message", message);
	}

	/**
	 * Platform in the format os[/arch[/variant]]
	 * 
	 * @param platform
	 * @return CreateImageParam
	 */
	public static CreateImageParam platform(String platform) {
		return create("platform", platform);
	}
}
