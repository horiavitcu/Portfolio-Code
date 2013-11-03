package selenium.chapter6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebTable {
	
	public WebElement _webTable;
	
	public WebElement get_webTable() {
		return _webTable;
	}

	public void set_webTable(WebElement _webTable) {
		this._webTable = _webTable;
	}

	public WebTable(WebElement webTable) {
		
		set_webTable(webTable);
		
	}
	
	public int getRowCount(){
		
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
		return tableRows.size();
		
	}
	public int getColumnCount(){
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableColumns = headerRow.findElements(By.tagName("td"));
		return tableColumns.size();
		
	}
	
	public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) throws NoSuchElementException{
		
		try {
			
			List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
			
			WebElement currentRow = tableRows.get(rowIdx - 1);
			
			List<WebElement> tableColumns = currentRow.findElements(By.tagName("td"));
			
			WebElement currentCell = tableColumns.get(colIdx - 1);
			
			WebElement cellEditor = currentCell.findElements(By.tagName("input")).get(editorIdx);
			
			return cellEditor;
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
		
	}
	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = _webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx-1);
		return cell.getText();		
	}
}
