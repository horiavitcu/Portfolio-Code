package com.facebook;

import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLogin {
	
	 private CharSequence user = "vitcuhoria01@gmail.com";
	 private CharSequence pass = "!@#$qwertyuiop";
	 
	 private String macDest = "/Users/horiavitcu/Desktop/screenshotFacebook.png";
	 private String pcDest = "d:\\tmp\\screenshotFacebook.png";
	 
	 private StringBuffer verificationErrors = new StringBuffer();
	 private WebDriver driver;
	 private WebElement username;
	 private WebElement password;
	 private WebElement loginButton;
	 
	 
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		 username = driver.findElement(By.id("email"));
		 password = driver.findElement(By.id("pass"));
		 loginButton = driver.findElement(By.id("u_0_e"));
		
	}
	
	@Test
	public void test() {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		driver.get("http://facebook.com");
		WebElement textArea = driver.findElement(By.id("u_0_16"));
		textArea.sendKeys("Hello World!");
		WebElement submitButton = driver.findElement(By.cssSelector("._42g-"));
		submitButton.click();
		
		try {
			File scrFile =
			((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new 
					File(macDest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
