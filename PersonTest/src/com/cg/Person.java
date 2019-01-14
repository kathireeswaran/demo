package com.cg;

public class Person {

	private String firstName;
	private String lasstName;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lasstName) {
		super();
		this.firstName = firstName;
		this.lasstName = lasstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasstName() {
		return lasstName;
	}

	public void setLasstName(String lasstName) {
		this.lasstName = lasstName;
	}

	public String getFullName() {
		return this.firstName + this.lasstName;
	}

}
