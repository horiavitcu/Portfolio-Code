package com.first.junit.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.first.junit.selenium.MyClass;

public class MyClassTest {
	
	@BeforeClass
	public static void testSetup(){
		
	}
	
	@AfterClass
	public static void testCleanup(){
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown(){
		MyClass tester = new MyClass();
		tester.multiply(1000, 5);
	}

	@Test
	public void testMultiply() {
		MyClass tester = new MyClass();
		assertEquals("10 x 5 must be 50 ", 50, tester.multiply(10, 5));
	}

}
