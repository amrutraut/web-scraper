/**
 * 
 */
package com.sainsbury.web.scraper.util;

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
public class WebPageParserTest {
	
	private static final String validURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/sainsburys-apricot-ripe---ready-320g.html";
	
	private static final String invalidURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/no_such_products.html";
	
	private WebPageParser parser;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		parser = new WebPageParser(validURL);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		parser = null;
	}

	@Test
	public void getsWebPageForValidURL() throws Exception {
		
		assertNotNull(parser);
	}
	
	@Test
	public void getsWebPageProductTitle(){
		assertEquals("Sainsbury's Apricot Ripe & Ready x5", parser.getProductTitle());
	}
	
	@Test
	public void getsWebPageProductPageSizeInKB(){
		assertNotNull(parser.getWebPageSizeInKB());
		assertEquals("34.0kb", parser.getWebPageSizeInKB());
	}
	
	@Test
	public void getsWebPageProductUnitPrice(){
		assertEquals(3.50, parser.getProdcutUnitPrice(),0.0);
	}
	
	@Test
	public void getsWebPageProductDescription(){
		assertEquals("Apricots", parser.getProductDescription());
	}
	
	@Test(expected = HttpStatusException.class)
	public void getsExceptionForInvalidURL() throws Exception {
		parser = new WebPageParser(invalidURL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getsExceptionForEmptyURL() throws Exception {
		parser = new WebPageParser("");
	}

}