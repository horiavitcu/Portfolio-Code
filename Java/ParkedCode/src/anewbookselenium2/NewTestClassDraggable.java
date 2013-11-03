package anewbookselenium2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTestClassDraggable {
	
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://www.theautomatedtester.co.uk/demo2.html");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
//	
	@Test
	public void contextClick(){
		driver.get("http://www.theautomatedtester.co.uk/demo1.html");
		Actions builderContextClick = new Actions(driver);
		WebElement theElementToBeInterractedWith = driver.findElement(By.tagName("body"));
		builderContextClick.contextClick(theElementToBeInterractedWith).build();
		builderContextClick.perform();
	}
}
