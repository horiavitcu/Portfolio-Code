package anewbookselenium2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;


public class TestForAndroid {

  WebDriver driver;

  @Before
  public void setUp(){
    driver = new AndroidDriver();
    driver.get("http://book.theautomatedtester.co.uk/chapter4");
  }

  @After
  public void tearDown(){
    driver.quit();
  }

  @Test
  public void testExamples(){
    WebElement element = driver.findElement(By.id("nextBid"));
    element.sendKeys("100");
  }
}

