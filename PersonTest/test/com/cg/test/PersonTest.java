package com.cg.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.Person;

public class PersonTest {

	Person person = null;

	@Before
	public void setUp() throws Exception {
		person = new Person();
	}

	@After
	public void tearDown() throws Exception {
		person = null;
	}

	@Test
	public void testGetFullName() {

		person.setFirstName("pavan");
		person.setLasstName("kumar");
		String result = person.getFullName();
		assertEquals("pavan kumar", result);

	}

}
