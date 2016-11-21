package com.phantom.springbean.eventhandler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CustomEventPublisher implements ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publisher;
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
	
	public void publish() {
		CustomEvent customEvent = new CustomEvent(this);
		publisher.publishEvent(customEvent);
	}

}
