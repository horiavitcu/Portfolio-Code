package com.first.junit.selenium.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropDown {

	@Test
	public void test() {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		//get the dropdown as a Select using its name attribute
		Select make = new Select(driver.findElement(By.name("make")));
		
		//verify the dropdown does not support multiple selection
		assertFalse(make.isMultiple());
		
		//verify make has 4 options for selection
		assertEquals(4, make.getOptions().size());
		
		// we will verify the dropdown has expected values as listed in an array
		List<String> exp_options = Arrays.asList(new String[]{
				"BMW", "Mercedes", "Audi", "Honda"});
		List<String> act_options = new ArrayList<String>();
		
		// retrieve the options from the dropdown using get option method
		for (WebElement option:make.getOptions()) {
			act_options.add(option.getText());
		}
		
		//verify expected options array and actual options array
		assertArrayEquals(exp_options.toArray(), act_options.toArray());
		
		//check whether an option is available or not
		assertTrue(act_options.contains("BMW"));
		
		//with Select class we can select a visible option in the DropDown using
		// visible text
		make.selectByVisibleText("Honda");
		assertEquals("Honda", make.getFirstSelectedOption().getText());
		
		//or we can select an option using the value attribute
		make.selectByValue("audi");
		assertEquals("audi", make.getFirstSelectedOption().getText());
		
		// or using the index
		make.selectByIndex(0);
		assertEquals("mercedes", make.getFirstSelectedOption().getText());
		
		
		
	}

}
