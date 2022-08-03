package com.deloitte.spring.boot.project.exception;

public class NoSuchElectionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchElectionException()
	{
		super();
	}
	
	public NoSuchElectionException(String msg)
	{
		super(msg);
	}

}
