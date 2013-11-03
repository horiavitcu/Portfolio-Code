package com.first.junit.selenium.test;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScreenShot {

	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		try {
			File scrFile =
			((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new 
					File("d:\\tmp\\main_page.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
