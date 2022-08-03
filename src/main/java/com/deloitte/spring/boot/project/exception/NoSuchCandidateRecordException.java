package com.deloitte.spring.boot.project.exception;

public class NoSuchCandidateRecordException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchCandidateRecordException()
	{
		super();
	}
	
	public NoSuchCandidateRecordException(String msg)
	{
		super(msg);
	}

}
