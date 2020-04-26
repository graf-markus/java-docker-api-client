package com.graf.docker.client.params;

public class RemoveContainersParam extends Param {

	protected RemoveContainersParam(String name, String value) {
		super(name, value);
	}

	private static RemoveContainersParam create(String name, String value) {
		return new RemoveContainersParam(name, value);
	}

	/**
	 * Remove the volumes associated with the Container.
	 * 
	 * @return RemoveContainerParams
	 */
	public static RemoveContainersParam removeVolumes() {
		return removeVolumes(true);
	}

	/**
	 * Remove the volumes associated with the Container.
	 * 
	 * @param removeVolumes
	 * @return RemoveContainerParams
	 */
	public static RemoveContainersParam removeVolumes(boolean removeVolumes) {
		return create("v", String.valueOf(removeVolumes));
	}

	/**
	 * Force to remove container. If the Container is running it is killed before.
	 * 
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam force() {
		return force(true);
	}

	/**
	 * Force to remove container. If the Container is running it is killed before.
	 * 
	 * @param force
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam force(boolean force) {
		return create("force", String.valueOf(force));
	}

	/**
	 * Remove the specified link associated with the Container.
	 * 
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam removeLink() {
		return removeLink(true);
	}

	/**
	 * Remove the specified link associated with the Container.
	 * 
	 * @param removeLinks
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam removeLink(boolean removeLinks) {
		return create("link", String.valueOf(removeLinks));
	}
}
