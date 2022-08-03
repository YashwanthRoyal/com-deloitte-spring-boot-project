package com.deloitte.spring.boot.project.exception;

public class NoSuchRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchRecordException()
	{
		super();
	}
	
	public NoSuchRecordException(String msg)
	{
		super(msg);
	}

}
