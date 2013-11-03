package com.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestJava {

	@Test
	public void implicitWait(){
		WebDriver driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/AjaxDemo.html");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
}
