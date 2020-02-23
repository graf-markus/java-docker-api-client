package com.graf.docker.client.params;

public class ListContainersParam extends Param {

	public ListContainersParam(String name, String value) {
		super(name, value);
	}

	/**
	 * Create a custom parameter.
	 *
	 * @param name  custom name
	 * @param value custom value
	 * @return ListContainersParam
	 */
	public static ListContainersParam create(final String name, final String value) {
		return new ListContainersParam(name, value);
	}

	/**
	 * Create a "filters" query param from a key/value pair.
	 *
	 * @param key   Type of filter
	 * @param value Value of filter
	 * @return ListContainersParam
	 */
	public static ListContainersParam filter(final String key, final String value) {
		return new ListContainersFilterParam(key, value);
	}

	/**
	 * Show all containers. Only running containers are shown by default
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam allContainers() {
		return allContainers(true);
	}

	/**
	 * Show all containers. Only running containers are shown by default
	 *
	 * @param all Whether to show all containers
	 * @return ListContainersParam
	 */
	public static ListContainersParam allContainers(final boolean all) {
		return create("all", String.valueOf(all));
	}

	/**
	 * Show <code>limit</code> last created containers, include non-running ones.
	 *
	 * @param limit Limit for number of containers to list
	 * @return ListContainersParam
	 */
	public static ListContainersParam limitContainers(final Integer limit) {
		return create("limit", String.valueOf(limit));
	}

	/**
	 * Show only containers created since id, include non-running ones.
	 *
	 * @param id container ID
	 * @return ListContainersParam
	 */
	public static ListContainersParam containersCreatedSince(final String id) {
		return create("since", id);
	}

	/**
	 * Show only containers created before id, include non-running ones.
	 *
	 * @param id container ID
	 * @return ListContainersParam
	 */
	public static ListContainersParam containersCreatedBefore(final String id) {
		return create("before", String.valueOf(id));
	}

	/**
	 * Show the containers sizes.
	 *
	 * @param size Whether to show container sizes
	 * @return ListContainersParam
	 */
	public static ListContainersParam withContainerSizes(final Boolean size) {
		return create("size", String.valueOf(size));
	}

	/**
	 * Show exited containers with given exit status.
	 *
	 * @param exitStatus Integer exit status
	 * @return ListContainersParam
	 */
	public static ListContainersParam withExitStatus(final int exitStatus) {
		return filter("exited", String.valueOf(exitStatus));
	}

	/**
	 * Show created containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam withStatusCreated() {
		return filter("status", "created");
	}

	/**
	 * Show restarting containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam withStatusRestarting() {
		return filter("status", "restarting");
	}

	/**
	 * Show running containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam withStatusRunning() {
		return filter("status", "running");
	}

	/**
	 * Show paused containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam withStatusPaused() {
		return filter("status", "paused");
	}

	/**
	 * Show exited containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam withStatusExited() {
		return filter("status", "exited");
	}

	/**
	 * Show containers with a label value.
	 *
	 * @param label The label to filter on
	 * @param value The value of the label
	 * @return ListContainersParam
	 */
	public static ListContainersParam withLabel(final String label, final String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}

	/**
	 * Show containers with a label.
	 *
	 * @param label The label to filter on
	 * @return ListContainersParam
	 */
	public static ListContainersParam withLabel(final String label) {
		return withLabel(label, null);
	}

	/**
	 * Show containers with specified image.
	 * 
	 * @param imageName
	 * @return
	 */
	public static ListContainersParam withImage(final String imageName) {
		return filter("ancestor", imageName);
	}

	/**
	 * Show containers with specified name.
	 * 
	 * @param name
	 * @return
	 */
	public static ListContainersParam withName(final String name) {
		return filter("name", name);
	}

	/**
	 * Show containers with specified id.
	 * 
	 * @param containerId
	 * @return
	 */
	public static ListContainersParam withId(final String containerId) {
		return filter("id", containerId);
	}

	/**
	 * Show containers which are Tasks.
	 * 
	 * @param isTask
	 * @return
	 */
	public static ListContainersParam isContainerTask(final boolean isTask) {
		return filter("is-task", String.valueOf(isTask));
	}

	/**
	 * Show containers with specified HealthStatus.
	 * 
	 * @param status
	 * @return
	 */
	public static ListContainersParam withHealth(final HealthStatus status) {
		return filter("health", status.toString().toLowerCase());
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public enum HealthStatus {
		STARTING, HEALTHY, UNHEALTHY, NONE
	}
}

class ListContainersFilterParam extends ListContainersParam {

	public ListContainersFilterParam(String name, String value) {
		super(name, value);
	}
}
