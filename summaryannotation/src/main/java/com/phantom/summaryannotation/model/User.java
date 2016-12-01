package com.phantom.summaryannotation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class User {
	private Long userId;
	private String email;
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	private String sPIN;
	private List<Order> listOrders;

	public User() {
	}

	public User(String email, String password, boolean enabled, String role) {
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "role", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String user) {
		this.role = user;
	}

	@Column(name = "enabled", nullable = false, columnDefinition = "boolean default true")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name = "spin")
	public String getsPIN() {
		return sPIN;
	}

	public void setsPIN(String sPIN) {
		this.sPIN = sPIN;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> orders) {
		this.listOrders = orders;
	}

	@Override
	public String toString() {
		return userId + "|" + email + "|" + username + "|" + enabled + "|" + role;
	}
}
