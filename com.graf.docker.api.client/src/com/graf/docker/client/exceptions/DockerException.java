package com.graf.docker.client.exceptions;

public class DockerException extends Exception {

	private static final long serialVersionUID = 2985780012521370368L;
	
	private int statusCode;
	
	public DockerException(String message, int code) {
		super(message);
		this.statusCode = code;
	}
	
	public int getErrorStatusCode(){
		return statusCode;
	}
}
