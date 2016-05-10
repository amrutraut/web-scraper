package com.sainsbury.web.scraper;

import static org.junit.Assert.assertNull;

import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for web scraper App.
 */
public class WebScraperTest {
	@Before
	public void setup() {

	}

	@After
	public void teardown() {

	}

	/**
	 * Applicaton Test :-)
	 */
	@Test
	public void testApp() {
		WebScraper app = new WebScraper();
		Document jsoupDoc = app.scrape("");
		assertNull(jsoupDoc);
	}
}
