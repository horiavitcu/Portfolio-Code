package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ClassOne {
	
	private static WebDriver firefoxDriver;
	private File file;
	private WebElement element;
	private List<WebElement> elements;
	
	public ClassOne() {
		// TODO Auto-generated constructor stub
	}
	
	public void setFileLocation(File file) {
		this.file = file;
	}
	
	public void openSite(String siteURL) {
		firefoxDriver = new FirefoxDriver();
		firefoxDriver.get(siteURL);
	}
	public void closeSite() {
		firefoxDriver.quit();
	}
	public void waitSite(int waitTime) throws InterruptedException {
		firefoxDriver.wait(waitTime);
	}
	
	
	public void findElement(String elementAttr, String elementAttrType) {
		if (elementAttrType == "id") {
			element = firefoxDriver.findElement(By.id(elementAttr));
		} else if (elementAttrType == "className") {
			element = firefoxDriver.findElement(By.className(elementAttr));
		} else if (elementAttrType == "tagName") {
			element = firefoxDriver.findElement(By.tagName(elementAttr));
		}	
	}
	
	public void findElementXpath(String elementName, String elementAttr, String elementAttrValue) {
		element = firefoxDriver.findElement(By.xpath("//" + elementName + "[@" + elementAttr + " = " + 
				 "'" + elementAttrValue + "'" +"]"));
	}
	
	public void typeInSearch(String searchQuery) {
		
		element.sendKeys(searchQuery);
		element.submit();
	}

	public List<WebElement> readElements(String elementName, String elementAttr, String elementAttrValue) {
		
		elements = firefoxDriver.findElements(By.xpath("//" + elementName + "[@" + elementAttr + " = " + 
				 "'" + elementAttrValue + "'" +"]"));
		for (int i = 0; i < elements.size(); i++) {
			System.out.println(elements.get(i).getText());
		}
		return elements;
		
	}
	
	public void writeFile(List<WebElement> arrayToBeWritten) {
		 
		   BufferedWriter writer = null;
		    try {

		        writer = new BufferedWriter(new FileWriter(file));
		        for ( int i = 0; i < arrayToBeWritten.size(); i++)
		        {      
		          writer.write(arrayToBeWritten.get(i).getText());
		          writer.newLine();
		          writer.newLine();
		      writer.flush();
		        }

		    } catch(IOException ex) {
		        ex.printStackTrace();
		    } finally{
		        if(writer!=null){
		            try {
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }  
		    }
	}

}