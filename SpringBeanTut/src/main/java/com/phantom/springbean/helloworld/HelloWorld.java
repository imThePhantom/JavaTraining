package com.phantom.springbean.helloworld;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		super();
	}

	public void getMessage() {
		System.out.println("Message: " + message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		System.out.println("Init welcome bean");
	}
	
	public void destroy() {
		System.out.println("Destroy welcome bean" + message);
	}
}
