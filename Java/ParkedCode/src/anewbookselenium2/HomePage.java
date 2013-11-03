package anewbookselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
		
	WebDriver seleniumDriver;
	
	public HomePage(WebDriver driver) {
		this.seleniumDriver = driver;
	}
	
	public Chapter2 clickChapter2(){
		clickChapter("2");
		return new Chapter2(seleniumDriver);
	}

	private void clickChapter(String chapterNumber) {
		
		seleniumDriver.findElement(By.linkText("Chapter" + chapterNumber)).click();
		
	}
	
}
