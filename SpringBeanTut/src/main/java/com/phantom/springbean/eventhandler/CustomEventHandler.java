package com.phantom.springbean.eventhandler;

import org.springframework.context.ApplicationListener;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	public void onApplicationEvent(CustomEvent customEvent) {
		System.out.println(customEvent.toString());
	}
}
