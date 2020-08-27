package com.example.demo.helloworld;

public class HelloWorldBean{
	
	private String message;
	
	//constructor
	public HelloWorldBean(String message) {
		this.setMessage(message);
	}

	//getter and setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//toString
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
}
