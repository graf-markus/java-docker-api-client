package com.graf.docker.client.interfaces;

import com.graf.docker.client.models.ExecResponse;

public interface IExecResponseListener {

	void onMessage(ExecResponse response);

	void onClosed(int statusCode, ExecResponse response);
}
