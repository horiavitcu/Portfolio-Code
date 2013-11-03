package com.first.junit.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDoubleClick {
	
	@Test
	public void testDoubleClis() throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get
		("http://dl.dropbox.com/u/55228056/DoubleClickDemo.html");
		
		WebElement message = driver.findElement(By.id("message"));
		
		//verify colour is blue
		
		assertEquals("rgb(0, 0, 255)", message.getCssValue("background-color").toString());
		
		Actions builder = new Actions(driver);
		
		builder.doubleClick(message).build().perform();
		
		//verify colour is yellow 
		
		assertEquals("rgb(255,  255, 0)", message.getCssValue("background-color").toString());
		
		driver.close();
	}
	
}
