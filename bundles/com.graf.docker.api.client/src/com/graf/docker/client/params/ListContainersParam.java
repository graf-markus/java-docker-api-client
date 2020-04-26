package com.graf.docker.client.params;

import com.graf.docker.client.interfaces.FilterParam;

public class ListContainersParam extends Param {

	protected ListContainersParam(String name, String value) {
		super(name, value);
	}

	/**
	 * Create a custom parameter.
	 *
	 * @param name  custom name
	 * @param value custom value
	 * @return ListContainersParam
	 */
	public static ListContainersParam create(String name, String value) {
		return new ListContainersParam(name, value);
	}

	/**
	 * Create a "filters" query param from a key/value pair.
	 *
	 * @param key   Type of filter
	 * @param value Value of filter
	 * @return ListContainersParam
	 */
	public static ListContainersParam filter(String key, String value) {
		return new ListContainersFilterParam(key, value);
	}

	/**
	 * Show all containers. Only running containers are shown by default
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam all() {
		return all(true);
	}

	/**
	 * Show all containers. Only running containers are shown by default
	 *
	 * @param all Whether to show all containers
	 * @return ListContainersParam
	 */
	public static ListContainersParam all(boolean all) {
		return create("all", String.valueOf(all));
	}

	/**
	 * Show <code>limit</code> last created containers, include non-running ones.
	 *
	 * @param limit Limit for number of containers to list
	 * @return ListContainersParam
	 */
	public static ListContainersParam limitContainers(int limit) {
		return create("limit", String.valueOf(limit));
	}

	/**
	 * Show only containers created since id, include non-running ones.
	 *
	 * @param id container ID
	 * @return ListContainersParam
	 */
	public static ListContainersParam containersCreatedSince(String id) {
		return create("since", id);
	}

	/**
	 * Show only containers created before id, include non-running ones.
	 *
	 * @param id container ID
	 * @return ListContainersParam
	 */
	public static ListContainersParam containersCreatedBefore(String id) {
		return create("before", String.valueOf(id));
	}

	/**
	 * Show the containers sizes.
	 *
	 * @param size Whether to show container sizes
	 * @return ListContainersParam
	 */
	public static ListContainersParam containerSizes(Boolean size) {
		return create("size", String.valueOf(size));
	}

	/**
	 * Show exited containers with given exit status.
	 *
	 * @param exitStatus Integer exit status
	 * @return ListContainersParam
	 */
	public static ListContainersParam exitStatus(int exitStatus) {
		return filter("exited", String.valueOf(exitStatus));
	}

	/**
	 * Show created containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam statusCreated() {
		return filter("status", "created");
	}

	/**
	 * Show restarting containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam statusRestarting() {
		return filter("status", "restarting");
	}

	/**
	 * Show running containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam statusRunning() {
		return filter("status", "running");
	}

	/**
	 * Show paused containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam statusPaused() {
		return filter("status", "paused");
	}

	/**
	 * Show exited containers.
	 *
	 * @return ListContainersParam
	 */
	public static ListContainersParam statusExited() {
		return filter("status", "exited");
	}

	/**
	 * Show containers with a label value.
	 *
	 * @param label The label to filter on
	 * @param value The value of the label
	 * @return ListContainersParam
	 */
	public static ListContainersParam label(String label, String value) {
		return isNullOrEmpty(value) ? filter("label", label) : filter("label", label + "=" + value);
	}

	/**
	 * Show containers with a label.
	 *
	 * @param label The label to filter on
	 * @return ListContainersParam
	 */
	public static ListContainersParam label(String label) {
		return label(label, null);
	}

	/**
	 * Show containers with specified image.
	 * 
	 * @param imageName
	 * @return ListContainersParam
	 */
	public static ListContainersParam withImage(String imageName) {
		return filter("ancestor", imageName);
	}

	/**
	 * Show containers with specified name.
	 * 
	 * @param name
	 * @return ListContainersParam
	 */
	public static ListContainersParam withName(String name) {
		return filter("name", name);
	}

	/**
	 * Show containers with specified id.
	 * 
	 * @param containerId
	 * @return ListContainersParam
	 */
	public static ListContainersParam withId(String containerId) {
		return filter("id", containerId);
	}

	/**
	 * Show containers which are Tasks.
	 * 
	 * @param isTask
	 * @return ListContainersParam
	 */
	public static ListContainersParam isContainerTask(boolean isTask) {
		return filter("is-task", String.valueOf(isTask));
	}

	/**
	 * Show containers with specified HealthStatus.
	 * 
	 * @param status
	 * @return ListContainersParam
	 */
	public static ListContainersParam withHealth(HealthStatus status) {
		return filter("health", status.toString().toLowerCase());
	}

	private static boolean isNullOrEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public enum HealthStatus {
		STARTING, HEALTHY, UNHEALTHY, NONE
	}

}

class ListContainersFilterParam extends ListContainersParam implements FilterParam {

	public ListContainersFilterParam(String name, String value) {
		super(name, value);
	}
}
