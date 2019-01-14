package com.cg.ems.model;

public class StringTest {

	public String getReversedString(String input) {
		StringBuilder builder = new StringBuilder(input);
		return builder.reverse().toString();
	}

	public int check() {
		return 10/0;
	}

}
