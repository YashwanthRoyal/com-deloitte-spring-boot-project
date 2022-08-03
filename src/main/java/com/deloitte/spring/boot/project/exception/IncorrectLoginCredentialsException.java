package com.deloitte.spring.boot.project.exception;

public class IncorrectLoginCredentialsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IncorrectLoginCredentialsException()
	{
		super();
	}
	
	public IncorrectLoginCredentialsException(String msg)
	{
		super(msg);
	}

}
