package com.sainsbury.web.scraper;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.HttpStatusException;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sainsbury.web.scraper.domain.ScraperResult;

/**
 * Unit test for web scraper class.
 * 
 * @author ARaut
 */
public class WebScraperTest {
	
	private static final String url="http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
	
	@Before
	public void setup() {

	}

	@After
	public void teardown() {

	}

	/**
	 * This test will scrape all the links on the web page & return Scraper Result.
	 * 
	 * @throws IOException 
	 */
	@Test(expected= NullPointerException.class)
	public void scrapesURL() throws IOException {
		WebScraper app = new WebScraper();
		ScraperResult result = app.scrape(url);
		assertNotNull(result);
	}
	
	@Test(expected = HttpStatusException.class)
	public void getsExceptionForInvalidURL() throws Exception {
		WebScraper app = new WebScraper();
		app.scrape("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/no_such_products.html");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getsExceptionForEmptyURL() throws Exception {
		WebScraper app = new WebScraper();
		app.scrape("");
	}
}
