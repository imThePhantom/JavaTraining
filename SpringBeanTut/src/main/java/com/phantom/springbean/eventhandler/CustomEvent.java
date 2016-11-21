package com.phantom.springbean.eventhandler;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source) {
		super(source);
	}

	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "My Custom Event";
	}
}
