package com.deloitte.spring.boot.project.exception;

public class InvalidAadhaarException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidAadhaarException()
	{
		super();
	}
	
	public InvalidAadhaarException(String msg)
	{
		super(msg);
	}

}
