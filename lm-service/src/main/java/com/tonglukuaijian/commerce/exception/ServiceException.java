package com.tonglukuaijian.commerce.exception;

public class ServiceException extends RuntimeException {

	public final static Integer ERROR = 400;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

}
