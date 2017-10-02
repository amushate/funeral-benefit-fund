package org.fbf.api;

import org.springframework.http.HttpStatus;

class ApiError {

	private HttpStatus status;
	/*@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;*/
	private String message;

	private ApiError() {
		//timestamp = LocalDateTime.now();
	}

	ApiError(HttpStatus status) {
		this();
		this.setStatus(status);
	}

	ApiError(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
	}

	ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage(message);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}