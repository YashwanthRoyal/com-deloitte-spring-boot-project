package com.deloitte.spring.boot.project.exception;

public class NoSuchVoterException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchVoterException()
	{
		super();
	}
	
	public NoSuchVoterException(String msg)
	{
		super(msg);
	}

}
