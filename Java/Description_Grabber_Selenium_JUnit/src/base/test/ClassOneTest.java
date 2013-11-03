package base.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import base.ClassOne;

public class ClassOneTest {
	
	ClassOne classOne;
	final String URL0 = "http://mythepiratebay.com/";
	final String URL1 = "http://www.ebay.co.uk/";
	
	@Before
	public void setUp() {
		classOne = new ClassOne();
	}
	
	@After
	public void tearDown() {
		//classOne.closeSite();
	}
	
	@Test
	public void testSiteConnect() {
		String searchString = "java";
		classOne.openSite(URL1);
		classOne.findElementXpath("input", "id", "gh-ac");
		classOne.typeInSearch(searchString);
		classOne.storeElements("div", "class", "ittl");
	}
	
	
	
}
