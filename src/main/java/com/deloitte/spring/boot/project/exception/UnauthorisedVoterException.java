package com.deloitte.spring.boot.project.exception;

public class UnauthorisedVoterException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public UnauthorisedVoterException()
	{
		super();
	}
	
	public UnauthorisedVoterException(String msg)
	{
		super(msg);
	}

}
