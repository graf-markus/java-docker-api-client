package com.graf.docker.client.params;

import java.util.Date;

public class LogsParam extends Param {

	protected LogsParam(String name, String value) {
		super(name, value);
	}

	/**
	 * Return stream.
	 *
	 * @return LogsParam
	 */
	public static LogsParam follow() {
		return follow(true);
	}

	/**
	 * Return stream. Default false.
	 *
	 * @param follow Whether to return stream.
	 * @return LogsParam
	 */
	public static LogsParam follow(boolean follow) {
		return create("follow", String.valueOf(follow));
	}

	/**
	 * Show stdout log.
	 *
	 * @return LogsParam
	 */
	public static LogsParam stdout() {
		return stdout(true);
	}

	/**
	 * Show stdout log. Default false.
	 *
	 * @param stdout Whether to show stdout log.
	 * @return LogsParam
	 */
	public static LogsParam stdout(boolean stdout) {
		return create("stdout", String.valueOf(stdout));
	}

	/**
	 * Show stderr log.
	 *
	 * @return LogsParam
	 */
	public static LogsParam stderr() {
		return stderr(true);
	}

	/**
	 * Show stderr log. Default false.
	 *
	 * @param stderr Whether to show stderr log.
	 * @return LogsParam
	 */
	public static LogsParam stderr(boolean stderr) {
		return create("stderr", String.valueOf(stderr));
	}

	/**
	 * Filter logs and only output entries since given Unix timestamp. Only
	 * available in Docker API &gt;= 1.19.
	 *
	 * @param timestamp Only output entries since timestamp.
	 * @return LogsParam
	 */
	public static LogsParam since(Integer timestamp) {
		return create("since", String.valueOf(timestamp));
	}

	public static LogsParam until(Date date) {
		return create("until", String.valueOf(date));
	}

	/**
	 * Print timestamp for every log line.
	 *
	 * @return LogsParam
	 */
	public static LogsParam timestamps() {
		return timestamps(true);
	}

	/**
	 * Print timestamp for every log line. Default false.
	 *
	 * @param timestamps Whether to print timestamp for every log line.
	 * @return LogsParam
	 */
	public static LogsParam timestamps(boolean timestamps) {
		return create("timestamps", String.valueOf(timestamps));
	}

	/**
	 * Output specified number of lines at the end of logs.
	 *
	 * @param lines Number of lines to output at the end of logs.
	 * @return LogsParam
	 */
	public static LogsParam tail(Integer lines) {
		return create("tail", String.valueOf(lines));
	}

	/**
	 * Create a custom parameter.
	 *
	 * @param name  custom name
	 * @param value custom value
	 * @return LogsParam
	 */
	public static LogsParam create(String name, String value) {
		return new LogsParam(name, value);
	}
}
