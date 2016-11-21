package com.phantom.springbean.aop;

public class Student {
	private String name;
	private Integer age;
	private Integer id;

	public String getName() {
		System.out.println("Name: " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		System.out.println("Age: " + age);
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}

	public Integer getId() {
		System.out.println("ID: " + id);
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
