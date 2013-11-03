package selenium.chapter8;

import java.io.File;

import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserMobDemo {
	public static void main(String[] args) throws Exception {
		
	ProxyServer server = new ProxyServer(9090);
	server.start();
	
	Proxy proxy = server.seleniumProxy();
	
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.PROXY, proxy);
	
	WebDriver driver = new FirefoxDriver(capabilities);
	
	server.newHar("Bmi Calculator");
	
	driver.get("http://dl.dropbox.com/u/55228056/bmicalculator.html");
	
	WebElement height = driver.findElement(By.name("heightCMS"));
	height.sendKeys("181");
	
	WebElement weight = driver.findElement(By.name("weightKg"));
	weight.sendKeys("80");

	WebElement calculateButton = driver.findElement(By.id("Calculate"));
	calculateButton.click();
	
	Thread.sleep(5000);
	
	Har har = server.getHar();
	
	File harFile = new File("/Users/horiavitcu/Desktop/harfile.har");
	har.writeTo(harFile);
	
	server.stop();
	
	driver.quit();
	
	}
	
}
