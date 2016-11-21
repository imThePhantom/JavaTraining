package com.phantom.springbean.aop;

public class Logging {
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}
	
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}
	
	public void afterReturningAdvice(Object returnVal) {
		System.out.println("Returning: " + returnVal.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException e) {
		System.out.println("There has been an exception: " + e.toString());
	}
}
