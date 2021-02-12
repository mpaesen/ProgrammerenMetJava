package com.ibm;

public class PlayerException extends Exception {

	public PlayerException() {
	}

	public PlayerException(String message) {
		super(message);
	}

	public PlayerException(Throwable cause) {
		super(cause);
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
	}

}
