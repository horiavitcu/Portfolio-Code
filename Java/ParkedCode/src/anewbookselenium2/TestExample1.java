package anewbookselenium2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestExample1 {
	WebDriver driver;
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.get("http://book.theautomatedtester.co.uk/chapter4");
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	@Test
	public void testExamples(){
		
		WebElement element = ((FindsById)driver).findElementById("verifybutton");
		
		List<WebElement> elements = ((FindsById)driver).findElementsById("selected(1234)");
		
		List<WebElement> xpathElements = ((FindsByXPath)driver).findElementsByXPath("//input");
		assertEquals(5, xpathElements.size());
		
		
	}
	@Test
	public void testExampleOne(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@id='ajaxdiv']"));
		WebElement waitElement = (new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>(){

			@Override
			public WebElement apply(WebDriver d) {
				
				return d.findElement(By.xpath("//div[@id='ajax']"));
			}
			
		}));
		
		Actions builder = new Actions(driver);
	}
}
