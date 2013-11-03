package com.first.junit.selenium.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestJavascriptExecutor {

	@Test
	public void test() throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String title = (String) js.executeScript("return document.title");
		
		assertEquals("Google", title);
		
		long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		assertEquals(42, links);
		
		driver.close();
	}

}
