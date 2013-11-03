package selenium.chapter6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class JQueryUITab {
	
	private WebElement _jQueryUITab;

	public WebElement get_jQueryUITab() {
		return _jQueryUITab;
	}

	public void set_jQueryUITab(WebElement _jQueryUITab) {
		this._jQueryUITab = _jQueryUITab;
	}
	
	public JQueryUITab(WebElement element) {
		
		set_jQueryUITab(element);
		
	}
	
	public int getTabCount(){
		List<WebElement> tabs = _jQueryUITab.findElements(By.cssSelector(".ui-tabs-nav > li"));
		return tabs.size();
	}
	
	public String getSelectedTab(){
		WebElement selectedTab = _jQueryUITab.findElement(By.cssSelector(".ui-tabs-nav > li[class*='ui-tabs-selected']"));
		return selectedTab.getText();
	}
	
	public void selectTab(String tabName){
		try {
			
			int idx = 0;
			boolean found = false;
			List<WebElement> tabs = _jQueryUITab.findElements(By.cssSelector(".ui-tabs-nav > li"));
			for (WebElement tab : tabs) {
				if (tabName.equals(tab.getText().toString())) {
					
					WrapsDriver wrappedElement = (WrapsDriver) _jQueryUITab;
					JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
					
					driver.executeScript("jQuery(arguments[0]).tabs().tabs('select',arguments[1]);",_jQueryUITab,idx);
					found = true;
					break;
				}
				idx++;
			}
			
			if (found==false)    {
				throw new Exception("Could not find tab '" + tabName + "'");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
