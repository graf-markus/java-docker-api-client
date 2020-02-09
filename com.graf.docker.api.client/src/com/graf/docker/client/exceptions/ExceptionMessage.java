package com.graf.docker.client.exceptions;

import com.google.gson.annotations.SerializedName;

public class ExceptionMessage {
	
	@SerializedName("message")
	private String message;
	
	public String getMessage() {
		return message;
	}
	
}
