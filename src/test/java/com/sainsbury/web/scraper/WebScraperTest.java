package com.sainsbury.web.scraper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.jsoup.HttpStatusException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for web scraper class.
 * 
 * @author ARaut
 */
public class WebScraperTest {

	private static final String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

	@Before
	public void setup() {

	}

	@After
	public void teardown() {

	}

	private String readFile(String fileName) throws IOException{
		String json = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(fileName),"UTF-8");
		return json;
	}

	/**
	 * This test will scrape all the links on the web page & return Scraper
	 * Result.
	 * 
	 * @throws IOException
	 */
	@Test()
	public void scrapesURL() throws IOException {
		String expectedJson = readFile("Expected.json");
		String jsonString = WebScraper.scrape(url);
		assertNotNull(jsonString);
		assertEquals(expectedJson, jsonString);
	}
	
	//TODO: add Json schema validation

	@Test(expected = HttpStatusException.class)
	public void getsExceptionForInvalidURL() throws Exception {
		WebScraper.scrape(
				"http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/no_such_products.html");
	}

	@Test(expected = IllegalArgumentException.class)
	public void getsExceptionForEmptyURL() throws Exception {
		WebScraper.scrape("");
	}
}
