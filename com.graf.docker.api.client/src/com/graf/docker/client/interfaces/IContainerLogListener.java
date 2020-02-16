package com.graf.docker.client.interfaces;

public interface IContainerLogListener {

	void onStderrLog();
	void onSTdoutLog();
	
}
