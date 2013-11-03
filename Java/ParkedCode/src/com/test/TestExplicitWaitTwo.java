package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExplicitWaitTwo {

	@Test
	public void test() {

		WebDriver driver = new FirefoxDriver();    
		driver.get("http://dl.dropbox.com/u/55228056/AjaxDemo.html");
		
		try{
			WebElement page4button = driver.findElement(By.linkText("Page4"));
			
			page4button.click();
			
			
			
			WebElement message = (new WebDriverWait(driver, 5)).
					until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d){
					return d.findElement(By.id("Page4"));
				}
			});
			assertTrue(message.getText().contains("Nunc nibh tortor"));
		}catch (NoSuchElementException e) {        
			fail("Element not found!!");        
		e.printStackTrace();    
		} finally {       
			driver.close();   
			}
		
	}

}
