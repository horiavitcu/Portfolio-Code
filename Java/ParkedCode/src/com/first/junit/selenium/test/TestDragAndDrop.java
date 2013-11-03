package com.first.junit.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDragAndDrop {

	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://dl.dropbox.com/u/55228056/DragDropDemo.html");
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).perform();
		
		try {
			assertEquals("Dropped!", target.getText());
		} catch (Exception e) {
		}
		
	}

}
