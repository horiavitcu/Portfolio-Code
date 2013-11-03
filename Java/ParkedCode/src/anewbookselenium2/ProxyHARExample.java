package anewbookselenium2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByXPath;

public class ProxyHARExample {
	
	WebDriver driver;

	@Before
	public void setUp(){
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExamples(){
		
		
	}
}
