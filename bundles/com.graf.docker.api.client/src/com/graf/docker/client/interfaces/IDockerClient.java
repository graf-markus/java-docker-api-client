package com.graf.docker.client.interfaces;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.models.ContainerSummary;
import com.graf.docker.client.models.ContainerChangeResponseItem;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreateResponse;
import com.graf.docker.client.models.ContainerWaitResponse;
import com.graf.docker.client.models.ContainerFileInfo;
import com.graf.docker.client.models.ContainerInspectResponse;
import com.graf.docker.client.models.ContainerLog;
import com.graf.docker.client.models.ContainerStats;
import com.graf.docker.client.models.ContainerUpdateResponse;
import com.graf.docker.client.models.ContainerPruneResponse;
import com.graf.docker.client.models.HostConfig;
import com.graf.docker.client.models.ImageSummary;
import com.graf.docker.client.models.BuildPruneResponse;
import com.graf.docker.client.models.ImageDeleteResponseItem;
import com.graf.docker.client.models.HistoryResponseItem;
import com.graf.docker.client.models.Image;
import com.graf.docker.client.models.ImagePruneResponse;
import com.graf.docker.client.models.ImageSearchResponseItem;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.ContainerTopResponse;
import com.graf.docker.client.params.ClearCacheParam;
import com.graf.docker.client.params.CreateImageParam;
import com.graf.docker.client.params.ImageDeleteParam;
import com.graf.docker.client.params.ImageSearchParam;
import com.graf.docker.client.params.ImageTagParam;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.ListImagesParam;
import com.graf.docker.client.params.LogsParam;
import com.graf.docker.client.params.RemoveContainersParam;

public interface IDockerClient {

	// Docker API
	// =========================================================================

	/**
	 * List all containers. Default only running ones
	 */
	List<ContainerSummary> listContainers(ListContainersParam... params) throws DockerException;

	/**
	 * Creates a new Container with the given config.
	 * 
	 * @param config
	 * @return ContainerCreation
	 * @throws DockerException
	 */
	ContainerCreateResponse createContainer(ContainerConfig config) throws DockerException;

	/**
	 * Creates a new Container with the given config and name.
	 * 
	 * @param config
	 * @param containerName
	 * @return ContainerCreation
	 * @throws DockerException
	 */
	ContainerCreateResponse createContainer(ContainerConfig config, String containerName) throws DockerException;

	/**
	 * Inspect a container. Gives more information than <code>listContainers</code>
	 * 
	 * @param containerId
	 * @return ContainerInfo
	 * @throws DockerException
	 */
	ContainerInspectResponse inspectContainer(final String containerId) throws DockerException;

	/**
	 * List running Processes inside a Container. Only working on running ones.
	 * Default ps args are -ef.
	 * 
	 * @param containerId
	 * @return TopResult
	 * @throws DockerException
	 */
	ContainerTopResponse topContainer(String containerId) throws DockerException;

	/**
	 * List running Processes inside a Container. Only working on running ones.
	 * 
	 * @param containerId
	 * @param psargs      - e.g aux
	 * @return TopResult
	 * @throws DockerException
	 */
	ContainerTopResponse topContainer(String containerId, String psargs) throws DockerException;

	/**
	 * Get stdout and stderr logs from a Container.
	 * 
	 * @param containerId
	 * @param param
	 * @return
	 * @throws DockerException
	 */
	ContainerLog logContainer(String containerId, LogsParam... param) throws DockerException;

	/**
	 * Inspects the changes of the Filesystem of a Container.
	 * 
	 * @param containerId
	 * @return
	 * @throws DockerException
	 */
	List<ContainerChangeResponseItem> inspectContainerChanges(String containerId) throws DockerException;

	/**
	 * Export the contents of a Container as a tarball.
	 * @param containerId
	 * @return String with the binary data
	 * @throws DockerException
	 */
	String exportContainer(String containerId) throws DockerException;

	/**
	 * Lists resource usage of a Container
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	ContainerStats statContainer(String containerId) throws DockerException;

	/**
	 * Lists resource usage of a Container
	 * 
	 * @param containerId
	 * @param listener
	 * @throws DockerException
	 */
	void statContainerStream(String containerId, IContainerStatsListener listener) throws DockerException;

	/**
	 * Resize the TTY for a Container.
	 * 
	 * @param containerId
	 * @param height
	 * @param width
	 * @throws DockerException
	 */
	void resizeTTYContainer(String containerId, int height, int width) throws DockerException;

	/**
	 * Starts a Container with the given id or name.
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	void startContainer(String containerId) throws DockerException;

	/**
	 * Stops a Container with the given id or name.
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	void stopContainer(String containerId) throws DockerException;

	/**
	 * Stops a Container with the given id or name.
	 * 
	 * @param containerId
	 * @param timeToWaitMillis
	 * @throws DockerException
	 */
	void stopContainer(String containerId, int timeToWaitMillis) throws DockerException;

	/**
	 * Stops a Container with the given id or name.
	 * 
	 * @param containerId
	 * @param time
	 * @param unit
	 * @throws DockerException
	 */
	void stopContainer(String containerId, int time, TimeUnit unit) throws DockerException;

	/**
	 * Restarts a Container with the given id or name.
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	void restartContainer(String containerId) throws DockerException;

	/**
	 * Restarts a Container with the given id or name.
	 * 
	 * @param containerId
	 * @param timeToWaitMillis
	 * @throws DockerException
	 */
	void restartContainer(String containerId, int timeToWaitMillis) throws DockerException;

	/**
	 * Restarts a Container with the given id or name.
	 * 
	 * @param containerId
	 * @param time
	 * @param unit
	 * @throws DockerException
	 */
	void restartContainer(String containerId, int time, TimeUnit unit) throws DockerException;

	/**
	 * Kills a Container with the given id or name.
	 * 
	 * @param continerId
	 * @param signal
	 * @throws DockerException
	 */
	void killContainer(String continerId, KillSignal signal) throws DockerException;

	/**
	 * Updates a existing Container without recreating it.
	 * 
	 * @param containerId
	 * @param config
	 * @return
	 * @throws DockerException
	 */
	ContainerUpdateResponse updateContainer(String containerId, HostConfig config) throws DockerException;

	/**
	 * Renames a existing Container.
	 * 
	 * @param containerId
	 * @param name
	 * @throws DockerException
	 */
	void renameContainer(String containerId, String name) throws DockerException;

	/**
	 * Pauses a Container with the given id or name.
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	void pauseContainer(String containerId) throws DockerException;

	/**
	 * Resumes a Container with the given id or name.
	 * 
	 * @param containerId
	 * @throws DockerException
	 */
	void unpauseContainer(String containerId) throws DockerException;

	/**
	 * Block until a container stops, then returns the exit code.<br>
	 * <b>Attention</b> Blocking Call
	 * 
	 * @param containerId
	 * @return
	 * @throws DockerException
	 */
	ContainerWaitResponse waitForContainer(String containerId) throws DockerException;

	/**
	 * Removes a Container with the given id or name.
	 * 
	 * @param containerId
	 * @param params
	 * @throws DockerException
	 */
	void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException;

	/**
	 * Get Metadata of a given file or folder in a Container.
	 * 
	 * @param containerId
	 * @param path
	 * @return
	 * @throws DockerException
	 */
	ContainerFileInfo fileInfoContainer(String containerId, String path) throws DockerException;

	/**
	 * Get a tar archive of a resource in the filesystem of a Container.
	 * 
	 * @param containerId
	 * @param path
	 * @throws DockerException
	 */
	String archiveContainer(String containerId, String path) throws DockerException;

	/**
	 * Extracts an archive to a Container.
	 * 
	 * @param containerId
	 * @param path
	 * @throws DockerException
	 */
	void extractToContainer(String containerId, String containerPath, String hostPath) throws DockerException;

	/**
	 * Deletes stopped Containers.
	 * 
	 * @return ContainersDeletedInfo
	 * @throws DockerException
	 */
	ContainerPruneResponse deleteContainers() throws DockerException;

	// Image API
	// ===================================================================================
	
	List<ImageSummary> listImages(ListImagesParam... param) throws DockerException;
	BuildPruneResponse clearImageBuildCache(ClearCacheParam... param) throws DockerException;
	void createImage(CreateImageParam... param) throws DockerException;
	Image inspectImage(String imageName) throws DockerException;
	List<HistoryResponseItem> imageHistory(String imageName) throws DockerException;
	void tagImage(String name, ImageTagParam... param) throws DockerException;
	List<ImageDeleteResponseItem> deleteImage(String imageName, ImageDeleteParam... param) throws DockerException;
	List<ImageSearchResponseItem> searchImage(String term, ImageSearchParam... param) throws DockerException;
	ImagePruneResponse deleteUnusedImages() throws DockerException;
	
	// Additionally Methods
	// ===================================================================================

	/**
	 * Creates a new Container and then starts the newly created Container.<br>
	 * <b>Attention!</b> if the Container already exists this Method throws an
	 * error.<br>
	 * Use the autoRemove option in ContainerConfig to delete the Container after
	 * termination.
	 * 
	 * @param config
	 * @throws DockerException
	 */
	ContainerCreateResponse runContainer(ContainerConfig config) throws DockerException;

	/**
	 * Creates a new Container and then starts the new created Container.<br>
	 * <b>Attention!</b> if the Container already exists this Method throws an
	 * error.<br>
	 * Use the autoRemove option in ContainerConfig to delete the Container after
	 * termination.
	 * 
	 * @param config
	 * @param containerName
	 * @throws DockerException
	 */
	ContainerCreateResponse runContainer(ContainerConfig config, String containerName) throws DockerException;

	/**
	 * Stops listening on stats of a Container
	 * 
	 * @param containerId
	 */
	void stopStatContainerStream(String containerId);
	/**
	 * Stops the Container with the given containerId and then removes the Container.
	 * @param containerId
	 * @throws DockerException
	 */
	void stopAndRemoveContainer(String containerId) throws DockerException;
}
