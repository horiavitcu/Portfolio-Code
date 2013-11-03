package demo.magentocommerce.pages;


import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {
		
	@Test
	public void testProductSearch(){
		
		HomePage homePage = new HomePage();
		
		homePage.get();
		
		SearchResults searchResult = homePage.search().searchInStore("sony");
		
		assertEquals(2, searchResult.getProducts().size());
		
		assertTrue(searchResult.getProducts().contains("Sony Erricson W810i"));
		
		searchResult.close();
	}
	
}
