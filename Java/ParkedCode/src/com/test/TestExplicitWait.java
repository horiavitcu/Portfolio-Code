package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExplicitWait {

	@Test
	public void test() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		//enter term to search and submit
		WebElement query = driver.findElement(By.name("q"));
		query.sendKeys("selenium");
		query.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("selenium"));
		
		assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
		
		driver.close();
		
	}

}
