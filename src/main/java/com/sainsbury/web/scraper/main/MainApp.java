/**
 * 
 */
package com.sainsbury.web.scraper.main;

import java.io.IOException;

import com.sainsbury.web.scraper.WebScraper;

/**
 * The main class which starts the web scraper.
 * 
 * @author ARaut
 *
 */
public class MainApp {
	
	private static String url = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";

	/**
	 * Start scraping web page.
	 * 
	 * @param args possible command line argument for url to scrape
	 */
	public static void main(String[] args) {

		String json;
		
		if (args.length >= 1){
			url = args[1];
		}
 
		try {
			json = WebScraper.scrape(url);
			//TDOD: add logging
			System.out.println(json);
		} catch (IOException ie) {
			// TODO: review exception handling 
			ie.printStackTrace();
		}
	}

}
