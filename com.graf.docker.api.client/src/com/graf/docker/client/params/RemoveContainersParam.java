package com.graf.docker.client.params;

public class RemoveContainersParam extends Param {

	public RemoveContainersParam(String name, String value) {
		super(name, value);
	}
	
	private static RemoveContainersParam create(final String name, final String value) {
		return new RemoveContainersParam(name, value);
	}
	
	/**
	 * Remove the volumes associated with the container.
	 * @return RemoveContainerParams
	 */
	public static RemoveContainersParam removeVolumes() {
		return removeVolumes(true);
	}
	
	/**
	 * Remove the volumes associated with the container.
	 * @param removeVolumes
	 * @return RemoveContainerParams
	 */
	public static RemoveContainersParam removeVolumes(final boolean removeVolumes) {
		return create("v", String.valueOf(removeVolumes));
	}
	
	/**
	 * Force to remove container. If the container is running it is killed before.
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam force() {
		return force(true);
	}
	
	/**
	 * Force to remove container. If the container is running it is killed before.
	 * @param force
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam force(final boolean force) {
		return create("force", String.valueOf(force));
	}
	
	/**
	 * Remove the specified link associated with the container.
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam removeLink() {
		return removeLink(true);
	}
	
	/**
	 * Remove the specified link associated with the container.
	 * @param removeLinks
	 * @return RemoveContainersParam
	 */
	public static RemoveContainersParam removeLink(final boolean removeLinks) {
		return create("link", String.valueOf(removeLinks));
	}
}
