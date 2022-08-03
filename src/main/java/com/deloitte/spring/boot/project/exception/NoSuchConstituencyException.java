package com.deloitte.spring.boot.project.exception;

public class NoSuchConstituencyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchConstituencyException()
	{
		super();
	}
	
	public NoSuchConstituencyException(String msg)
	{
		super(msg);
	}

}
