package selenium.chapter9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HTML5SessionStorage {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/html5storage.html");
	}
	
	@Test
	public void testHTML5SessionStorage() throws Exception {
		
		String clickCount;
		
		WebElement clickButton = driver.findElement(By.id("click"));
		WebElement clicksField = driver.findElement(By.id("clicks"));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		//get current value of sessionStorage.clickcount, should be null
		
		clickCount = (String) jsExecutor.executeScript("return sessionStorage.clickCount;");
		assertEquals(null, clickCount);
		assertEquals("0", clicksField.getAttribute("value"));
		
		clickButton.click();
		
		//get current value of sessionStorage.clickcount, should be one
		clickCount = (String) jsExecutor.executeScript("return sessionStorage.clickCount;");
		assertEquals(1, clickCount);
		assertEquals("1", clicksField.getAttribute("value"));
		
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
