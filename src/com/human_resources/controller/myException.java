package com.human_resources.controller;

public class myException extends Exception{
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public myException(String message) {
		super();
		this.message = message;
	}
	
}
