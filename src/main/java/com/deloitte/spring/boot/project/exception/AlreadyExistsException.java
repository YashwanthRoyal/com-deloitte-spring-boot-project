package com.deloitte.spring.boot.project.exception;

public class AlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlreadyExistsException()
	{
		super();
	}
	
	public AlreadyExistsException(String msg)
	{
		super(msg);
	}

}
