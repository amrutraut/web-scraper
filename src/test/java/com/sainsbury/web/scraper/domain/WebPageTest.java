/**
 * 
 */
package com.sainsbury.web.scraper.domain;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.nodes.Document;
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
	}

	@Test
	public void getsDocumentForURL() throws IOException {
		WebPage page = new WebPage(url);
		Document jsoupDoc = page.getDocument();
		assertNotNull(jsoupDoc);
	}

}
