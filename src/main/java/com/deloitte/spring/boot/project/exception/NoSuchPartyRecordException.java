package com.deloitte.spring.boot.project.exception;

public class NoSuchPartyRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchPartyRecordException()
	{
		super();
	}
	
	public NoSuchPartyRecordException(String msg)
	{
		super(msg);
	}

}
