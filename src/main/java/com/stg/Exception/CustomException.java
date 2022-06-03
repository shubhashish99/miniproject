package com.stg.Exception;

public class CustomException extends RuntimeException {

	public CustomException() {
	}

	private String message;

	public CustomException(String message) {

		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
