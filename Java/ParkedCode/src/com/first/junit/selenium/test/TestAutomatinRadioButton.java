package com.first.junit.selenium.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAutomatinRadioButton {
	
	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
        driver.get("https://dl.dropbox.com/u/55228056/Config.html");
		WebElement petrol = driver.findElement(By.xpath("//input[@value='Petrol']"));
		
		// check if it is selected and if not select it
		
		if (!petrol.isSelected()) {
			petrol.click();
		}
		
		// verify radio button is selected
		assertTrue(petrol.isSelected());
		
		// we can also get all the radio elements in a list using the radio group identifier
		
		List<WebElement> fuel_type = driver.findElements(By.name("fuel_type"));
		for (WebElement type : fuel_type) {
			// search for diesel radio button and select it
			if (type.getAttribute("value").equals("diesel")) {
				if (!type.isSelected()) {
					type.click();
					assertTrue(type.isSelected());
					break;
				}
			}
		}
		
	}

}
