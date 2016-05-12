/**
 * 
 */
package com.sainsbury.web.scraper.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sainsbury.web.scraper.WebScraper;

/**
 * The main class which starts the web scraper.
 * 
 * @author ARaut
 *
 */
public class MainApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainApp.class);

	private static String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

	/**
	 * Start scraping web page.
	 * 
	 * @param args
	 *            possible command line argument for url to scrape
	 */
	public static void main(String[] args) {

		String json;

		if (args.length == 1) {
			url = args[0];
			LOGGER.debug("url: {} supplied at command line.", url);
		}

		LOGGER.debug("Lets start scraping the url: {}", url);

		try {
			json = WebScraper.scrape(url);

			LOGGER.info("Scraping Result for url: {} \n {}", url, json);
		} catch (IllegalArgumentException iae) {
			LOGGER.error("Not a valid url: {} ", url, iae);
		} catch (IOException ie) {
			LOGGER.error("There was problem scraping url: {} \n The cause: {}", url, ie);
		}
	}

}
