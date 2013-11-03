package selenium.cookbook.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import selenium.cookbook.pageobjects.BmiCalcPage;

public class TestBMICalculation {

	@Test
	public void testBmiCalculation()
	{
		//Create an instance of Bmi Calculator Page class
		//and provide the driver
		BmiCalcPage bmiCalcPage = new BmiCalcPage();
		
		//Open the Bmi Calculator Page
		bmiCalcPage.get();

		//Calculate the Bmi by supplying Height and Weight values
		bmiCalcPage.calculateBmi("181", "80");

		//Verify Bmi & Bmi Category values
		assertEquals("24.4", bmiCalcPage.getBmi());
		assertEquals("Normal", bmiCalcPage.getBmiCategory());
		
		//Close the Bmi Calculator Page
		bmiCalcPage.close();
	}
}
