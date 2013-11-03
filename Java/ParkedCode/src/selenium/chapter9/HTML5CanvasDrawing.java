package selenium.chapter9;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import selenium.chapter6.CompareUtil;

public class HTML5CanvasDrawing {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/html5canvasdraw.html");
	}
	
	@Test
	public void testHTML5CanvasDrawing() throws Exception {
		
		//Get the HTML5 Canvas Element
		WebElement canvas = driver.findElement(By.id("imageTemp"));
		//Select the Pencil Tool
		Select drawtool = new Select(driver.findElement(By.id("dtool")));	
		drawtool.selectByValue("pencil");
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvas).moveByOffset(10, 50).
				 					moveByOffset(50,10).
				 					moveByOffset(-10,-50).
				 					moveByOffset(-50,-10).release().perform();
		FileUtils.copyFile(WebElementExtender.captureElementBitmap(canvas), 
				new File("/Users/horiavitcu/Desktop/html5canvas.png"));
		assertEquals(CompareUtil.Result.Matched, 
				CompareUtil.compareImage("/Users/horiavitcu/Desktop/base_html5canvas.png",
						"/Users/horiavitcu/Desktop/post_html5canvas.png"));		
		
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
