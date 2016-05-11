/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.jsoup.HttpStatusException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for WebPage class
 * 
 * @author ARaut
 *
 */
public class WebPageTest {
	
	private static final String validURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html";
	
	private static final String invalidURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/no_such_products.html";
	
	private WebPage page;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		page = new WebPage(validURL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		page = null;
	}

	@Test
	public void getsWebPageForValidURL() throws Exception {
		
		assertNotNull(page);
	}
	
	@Test
	public void getsWebPageProductTitle(){
		assertEquals("Sainsbury's Apricot Ripe & Ready x5", page.getProductTitle());
	}
	
	@Test
	public void getsWebPageProductPageSize(){
		assertNotNull(page.getPageSize());
		assertEquals("34.0kb", page.getPageSize());
	}
	
	@Test
	public void getsWebPageProductUnitPrice(){
		assertEquals(3.50, page.getProdcutUnitPrice(),0.0);
	}
	
	@Test
	public void getsWebPageProductDescription(){
		assertEquals("Apricots", page.getProductDescription());
	}
	
	@Test(expected = HttpStatusException.class)
	public void getsExceptionForInvalidURL() throws Exception {
		page = new WebPage(invalidURL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getsExceptionForEmptyURL() throws Exception {
		page = new WebPage("");
	}

}
