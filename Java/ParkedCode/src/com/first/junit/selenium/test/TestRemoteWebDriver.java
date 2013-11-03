package com.first.junit.selenium.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.bcel.generic.NEWARRAY;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

public class TestRemoteWebDriver {

	@Test
	public void test() throws IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver = new Augmenter().augment(driver);
		File srcFile = ((TakesScreenshot)driver) .getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\tmp\\screenshot1.png"));
		
	}

}
