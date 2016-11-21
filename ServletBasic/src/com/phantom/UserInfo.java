package com.phantom;

public class UserInfo {
	public String username;
	private int post;
	private String country;
	public UserInfo(String username, int post, String country) {
		super();
		this.username = username;
		this.post = post;
		this.country = country;
	}
	
	public UserInfo(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
