package com.graf.docker.client.models;

public class ExecResponse {

	private String id;
	private String message;

	private ExecResponse(Builder builder) {
		this.id = builder.id;
		this.message = builder.message;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {

		private String id;
		private String message;

		public Builder() {
		}

		public Builder id(String id) {
			this.id = id;
			return Builder.this;
		}

		public Builder message(String message) {
			this.message = message;
			return Builder.this;
		}

		public ExecResponse build() {

			return new ExecResponse(this);
		}
	}
}
