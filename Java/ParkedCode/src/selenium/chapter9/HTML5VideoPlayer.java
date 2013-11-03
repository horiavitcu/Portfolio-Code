package selenium.chapter9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HTML5VideoPlayer {
		
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/html5video.html");
	}
	
	@Test
	public void testHTML5VideoPlayer() throws Exception {
		
		File srcFile = null;
		
		//get the html5 video element
		WebElement videoPlayer = driver.findElement(By.id("vplayer"));
		
		//we will need a javascript executor for interacting with Video Element's 
		//properties for automation
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		//get the source of video that will be played in the video player
		String source = (String)jsExecutor.executeScript("return arguments[0].currentSrc;", videoPlayer);
		//get the duration of the video
		long duration = (Long) jsExecutor.executeScript("return arguments[0].duration", videoPlayer);
		
		assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		assertEquals(25, duration);
		
		//play the video
		jsExecutor.executeScript("return arguments[0].play()", videoPlayer);
		
		Thread.sleep(5000);
		
		//pause the video
		jsExecutor.executeScript("arguments[0].pause()", videoPlayer);
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("/Users/horiavitcu/Desktop/pause_play.png"));
		
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
	

