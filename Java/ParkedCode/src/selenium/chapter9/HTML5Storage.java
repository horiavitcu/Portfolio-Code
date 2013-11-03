package selenium.chapter9;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HTML5Storage {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	String lastName;
	JavascriptExecutor jsExecutor;
	
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/html5storage.html");
	}
	
	@Test
	public void testHTML5LocalStorage() throws Exception{
		
		String lastName;
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		lastName = (String) jsExecutor.executeScript("return localStorage.lastname;");
		
		assertEquals("Smith", lastName);
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
