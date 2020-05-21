package com.lt.journey.exception;

public class MessageException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public MessageException(String msg) {
		this.msg = msg;
	}
	
}
