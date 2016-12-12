package com.phantom.summaryannotation.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session created");
		se.getSession().setMaxInactiveInterval(30 * 60);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session destroyed");
	}

}
