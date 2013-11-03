package anewbookselenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Chapter2 extends LoadableComponent<Chapter2> {
		
	WebDriver seleniumDriver;
	
	@FindBy(how = How.NAME, using="verifybutton")
	WebElement verifyButton;
	
	public Chapter2(WebDriver driver){
		this.seleniumDriver = driver;
		PageFactory.initElements(seleniumDriver, this);
		
	}
	public boolean isButtonDisplayer(String button){
		return seleniumDriver.findElement(By.id(button)).isDisplayed();
	}
	
	@Override
	protected void load() {
	        seleniumDriver.get("http://book.theautomatedtester.co.uk/chapter2");
	}
	@Override
	protected void isLoaded() {
		
		String url = seleniumDriver.getCurrentUrl();
		if (url != "http://book.theautomatedtester.co.uk/chapter2") {
			try {
				throw new Exception("The wrong page is loaded");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	

