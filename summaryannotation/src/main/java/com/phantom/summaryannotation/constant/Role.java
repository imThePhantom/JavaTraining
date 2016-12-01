package com.phantom.summaryannotation.constant;

public class Role {
	public static final String ADMIN = "ADMIN";
	public static final String USER = "USER";
	public static final String INACTIVE_USER = "INACTIVE_GUEST";
	public static final String GUEST = "GUEST";
	
	private String role;
	
	Role(String role) {
		this.role = role;
	}
	
	public String role() {
		return role;
	}
}
