package selenium.chapter6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectMapDemo {
		
	private WebDriver driver;  
	private StringBuffer verificationErrors = new StringBuffer();  
	private ObjectMap map;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
	}
	
	@Test
	public void testBMICalculator(){
		try {
			
			map = new ObjectMap("/JavaTest/res/objectmap.properties");
			
			WebElement height = driver.findElement(map.getLocator("height_field"));;
			height.sendKeys("181");
			//Get the Weight element
			WebElement weight = driver.findElement(map.getLocator("weight_field"));
			weight.sendKeys("80");
	
			//Click on the Calculate button
			WebElement calculateButton = driver.findElement(map.getLocator("calculate_button"));
			calculateButton.click();
			
			//Verify the Bmi
			WebElement bmi = driver.findElement(map.getLocator("bmi_field"));
			assertEquals("24.4", bmi.getAttribute("value"));
			
		} catch (Exception e) {
			//Capture and append Exceptions/Errors
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception {
	
		//Close the browser
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
