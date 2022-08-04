package com.deloitte.spring.boot.project.exception;

public class NotScheduledException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public NotScheduledException()
	{
		super();
	}
	
	public NotScheduledException(String msg)
	{
		super(msg);
	}

}
