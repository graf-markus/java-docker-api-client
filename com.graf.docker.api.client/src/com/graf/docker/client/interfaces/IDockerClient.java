package com.graf.docker.client.interfaces;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.graf.docker.client.exceptions.DockerException;
import com.graf.docker.client.models.Container;
import com.graf.docker.client.models.ContainerConfig;
import com.graf.docker.client.models.ContainerCreation;
import com.graf.docker.client.models.ContainerInfo;
import com.graf.docker.client.models.ContainersDeletedInfo;
import com.graf.docker.client.models.KillSignal;
import com.graf.docker.client.models.TopResults;
import com.graf.docker.client.params.ListContainersParam;
import com.graf.docker.client.params.RemoveContainersParam;

public interface IDockerClient {
	/**
	 * List all containers. Default only running ones 
	 */
	List<Container> listContainers(ListContainersParam... params) throws DockerException;
	/**
	 * Inspect a container. Gives more information than <code>listContainers</code>
	 * @param containerId
	 * @return ContainerInfo
	 * @throws DockerException
	 */
	ContainerInfo inspectContainer(final String containerId) throws DockerException;
	/**
	 * Creates a new Container with the given config.
	 * @param config
	 * @return ContainerCreation
	 * @throws DockerException
	 */
	ContainerCreation createContainer(ContainerConfig config) throws DockerException;
	/**
	 * List running Processes inside a Container. Only working on running ones. DEfault ps args are -ef.
	 * @param containerId
	 * @return TopResult
	 * @throws DockerException
	 */
	TopResults topContainer(String containerId) throws DockerException;
	/**
	 * List running Processes inside a Container. Only working on running ones.
	 * @param containerId
	 * @param psargs - e.g aux
	 * @return TopResult
	 * @throws DockerException
	 */
	TopResults topContainer(String containerId, String psargs) throws DockerException;
	/**
	 * List resource usage of a Container
	 * @param containerId
	 * @throws DockerException
	 */
	void statContainer(String containerId) throws DockerException;
	/**
	 * Starts a Container with the given id or name.
	 * @param containerId
	 * @throws DockerException
	 */
	void startContainer(String containerId) throws DockerException;
	/**
	 * Stops a Container with the given id or name.
	 * @param containerId
	 * @throws DockerException
	 */
	void stopContainer(String containerId) throws DockerException;
	/**
	 * Stops a Container with the given id or name.
	 * @param containerId
	 * @param timeToWaitMillis
	 * @throws DockerException
	 */
	void stopContainer(String containerId, int timeToWaitMillis) throws DockerException;
	/**
	 * Stops a Container with the given id or name.
	 * @param containerId
	 * @param time
	 * @param unit
	 * @throws DockerException
	 */
	void stopContainer(String containerId, int time, TimeUnit unit) throws DockerException;
	/**
	 * Restarts a Container with the given id or name.
	 * @param containerId
	 * @throws DockerException
	 */
	void restartContainer(String containerId) throws DockerException;
	/**
	 * Restarts a Container with the given id or name.
	 * @param containerId
	 * @param timeToWaitMillis
	 * @throws DockerException
	 */
	void restartContainer(String containerId, int timeToWaitMillis) throws DockerException;
	/**
	 * Restarts a Container with the given id or name.
	 * @param containerId
	 * @param time
	 * @param unit
	 * @throws DockerException
	 */
	void restartContainer(String containerId, int time, TimeUnit unit) throws DockerException;
	/**
	 * Kills a Container with the given id or name.
	 * @param continerId
	 * @param signal
	 * @throws DockerException
	 */
	void killContainer(String continerId, KillSignal signal) throws DockerException;
	/**
	 * Pauses a Container with the given id or name.
	 * @param containerId
	 * @throws DockerException
	 */
	void pauseContainer(String containerId) throws DockerException;
	/**
	 * Resumes a Container with the given id or name.
	 * @param containerId
	 * @throws DockerException
	 */
	void unpauseContainer(String containerId) throws DockerException;
	/**
	 * Removes a Container with the given id or name.
	 * @param containerId
	 * @param params
	 * @throws DockerException
	 */
	void removeContainer(String containerId, RemoveContainersParam... params) throws DockerException;
	/**
	 * Deletes stopped Containers
	 * @return ContainersDeletedInfo
	 * @throws DockerException
	 */
	ContainersDeletedInfo deleteContainers() throws DockerException;
}
