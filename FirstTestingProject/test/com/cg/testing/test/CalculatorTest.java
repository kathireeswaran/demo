package com.cg.testing.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.testing.Calculator;

public class CalculatorTest {

	Calculator calculator = null;

	@Before
	public void setUp() {
		System.out.println("in setup method");
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		int result = calculator.add(12, 23);
		assertEquals(35, result);
	}

	@Test
	public void testAdd1() {
		int result = calculator.add(12, 23);
		assertNotEquals(45, result);
	}

	@Test
	public void testAddNull() {
		int result = calculator.add(12, 23);
		assertNull(result);
	}

	@Test
	public void testMul() {

		int result = calculator.mul(12, 12);
		assertEquals(144, result);
	}

	@After
	public void destroy() {
		System.out.println("in after method");
		calculator = null;
	}

}
