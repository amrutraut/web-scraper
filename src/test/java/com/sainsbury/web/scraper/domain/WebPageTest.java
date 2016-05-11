/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import static org.junit.Assert.assertNotNull;

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
	
	private static final String url="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
	
	private WebPage page;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		page = null;
	}

	@Test
	public void getsDocumentForValidURL() throws Exception {
		page = new WebPage(url);
		assertNotNull(page);
	}
	
	@Test(expected = HttpStatusException.class)
	public void getsExceptionForInvalidURL() throws Exception {
		page = new WebPage("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/no_such_products.html");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getsExceptionForEmptyURL() throws Exception {
		page = new WebPage("");
	}

}
