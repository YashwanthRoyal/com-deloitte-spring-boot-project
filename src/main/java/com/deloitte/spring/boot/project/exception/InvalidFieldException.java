package com.deloitte.spring.boot.project.exception;

public class InvalidFieldException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidFieldException()
	{
		super();
	}
	
	public InvalidFieldException(String msg)
	{
		super(msg);
	}

}
