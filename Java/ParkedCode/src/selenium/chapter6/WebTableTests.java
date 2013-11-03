package selenium.chapter6;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableTests {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();    
		driver.get("http://dl.dropbox.com/u/55228056/Locators.html");
	}
	
	@Test
	public void testWebTableTests(){
		try {
			
			WebTable table = new WebTable(driver.findElement(By.cssSelector("div.cart-info table")));
			
			assertEquals(3, table.getRowCount());
			
			assertEquals(5, table.getColumnCount());
			
			assertEquals("iPhone",table.getCellData(3,1));
			
			WebElement cellEdit = table.getCellEditor(3, 3, 0);
			cellEdit.clear();
			cellEdit.sendKeys("2");
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() {
		
		//Close the browser
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub
		
	}
}
