package com.deloitte.spring.boot.project.exception;

public class ElectionAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 7989276407395735015L;

	public ElectionAlreadyExistsException() {
		super();
	}

	public ElectionAlreadyExistsException(String message) {
		super(message);
	}
}
