package anewbookselenium2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BestPractices3 {
	WebDriver seleniumDriver;
	
	@Before
	public void setUp(){
		seleniumDriver = new FirefoxDriver();
	}
	
	@After
	public void tearDown(){
		seleniumDriver.quit();
	}
	
	public Chapter2 clickChapter2(){
		clickChapter("2");
		return PageFactory.initElements(seleniumDriver, Chapter2.class);
		
	}
	public void clickChapter(String chapterNumber) {
		
		seleniumDriver.findElement(By.linkText("Chapter" + chapterNumber)).click();
		
	}
	@Test
	public void shouldLoadTheHomePageAndThenCheckButtonOnChapter2(){
		
		Chapter2 ch2 = new Chapter2(seleniumDriver).get();
		ch2.isButtonDisplayer("but1");
	}
}