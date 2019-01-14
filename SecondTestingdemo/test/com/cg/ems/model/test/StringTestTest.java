package com.cg.ems.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.ems.model.StringTest;

public class StringTestTest {

	static StringTest test = null;

	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("1111");
		test = new StringTest();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		test = null;
		System.out.println("22222");
	}

	@Test
	public void testGetReversedString1() {
		String output = test.getReversedString("capgemini");
		assertEquals("inimegpac", output);
	}

	@Test
	public void testGetReversedString2() {
		String output = test.getReversedString("capgemini");
		assertEquals("inimepac", output);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testCheck() {
		int res = test.check();
		assertNotNull(res);
	}

	@Test()
	@Ignore
	public void testGetReversedStringNull() {
		String output = test.getReversedString("capgemini");
		assertNull(output);
	}

	@Test
	public void testGetReversedStringNotNull() {
		String output = test.getReversedString("capgemini");
		assertNotNull(output);
	}

}
