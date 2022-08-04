package com.deloitte.spring.boot.project.exception;

public class AlreadyVotedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public AlreadyVotedException()
	{
		super();
	}
	
	public AlreadyVotedException(String msg)
	{
		super(msg);
	}

}
