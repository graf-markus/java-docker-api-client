package com.graf.docker.client.params;

public class CommitImageParam extends Param {

	protected CommitImageParam(String name, String value) {
		super(name, value);
	}

	private static CommitImageParam create(String name, String value) {
		return new CommitImageParam(name, value);
	}

	/**
	 * The ID or name of the Container to commit.
	 * 
	 * @param container
	 * @return CommitImageParam
	 */
	public static CommitImageParam container(String container) {
		return create("container", container);
	}

	/**
	 * Repository name for the created Image.
	 * 
	 * @param repo
	 * @return CommitImageParam
	 */
	public static CommitImageParam repo(String repo) {
		return create("repo", repo);
	}

	/**
	 * Tag name for the create Image.
	 * 
	 * @param tag
	 * @return CommitImageParam
	 */
	public static CommitImageParam tag(String tag) {
		return create("tag", tag);
	}

	/**
	 * Commit message.
	 * 
	 * @param comment
	 * @return CommitImageParam
	 */
	public static CommitImageParam comment(String comment) {
		return create("comment", comment);
	}

	/**
	 * Author of the image (e.g., John Hannibal Smith <hannibal@a-team.com>)
	 * 
	 * @param author
	 * @return CommitImageParam
	 */
	public static CommitImageParam author(String author) {
		return create("author", author);
	}

	/**
	 * Whether to pause the container before committing.
	 * 
	 * @param pause
	 * @return CommitImageParam
	 */
	public static CommitImageParam pause() {
		return pause(true);
	}

	/**
	 * Whether to pause the container before committing.
	 * 
	 * @param pause
	 * @return CommitImageParam
	 */
	public static CommitImageParam pause(boolean pause) {
		return create("pause", String.valueOf(pause));
	}

	/**
	 * Dockerfile instructions to apply while committing
	 * 
	 * @param path
	 * @return CommitImageParam
	 */
	public static CommitImageParam changes(String path) {
		return create("changes", path);
	}
}
